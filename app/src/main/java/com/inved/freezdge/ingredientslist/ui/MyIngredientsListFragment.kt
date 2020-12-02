package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.R
import com.inved.freezdge.databinding.ActivityMainBinding
import com.inved.freezdge.databinding.FragmentMyIngredientsListBinding
import com.inved.freezdge.ingredientslist.adapter.GroceryItem
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.firebase.IngredientListHelper
import com.inved.freezdge.onboarding.OnboardingActivity
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.schedule.adapter.CalendarDayNameItem
import com.inved.freezdge.schedule.firebase.FirebaseCalendarUtils
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.enumtype.IngredientsType
import com.inved.freezdge.utils.eventbus.ChipClickEvent
import com.mikepenz.fastadapter.GenericItem
import kotlinx.android.synthetic.main.fragment_my_ingredients_list.*
import kotlinx.android.synthetic.main.fragment_my_recipes.floatingActionButton
import kotlinx.android.synthetic.main.fragment_my_recipes.not_found
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MyIngredientsListFragment :
    BaseFragment<FragmentMyIngredientsListBinding, ActivityMainBinding>() {

    private var ingredientsTypeList: MutableList<String> = mutableListOf()
    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMyIngredientsListBinding {
        return FragmentMyIngredientsListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detectUid()
        floatingActionButton.hide()
        floatingActionButton.setOnClickListener { openSearchIngredientActivity() }
        setupIngredientsTypeList()
        setHasOptionsMenu(true)
    }

    private fun detectUid() {
        FirebaseAuth.getInstance().currentUser?.uid?.let {
            if (FirebaseAuth.getInstance().currentUser?.uid != OnboardingActivity.sharedPrefFirebaseUid.getString(
                    OnboardingActivity.FIREBASE_UID,
                    ""
                )
            ) {
                FirebaseAuth.getInstance().currentUser?.uid?.let { Domain().updateUid(it) }
                ingredientsViewModel.deleteAllIngredients()
                ingredientsListViewModel.deleteAllIngredientsList()
                recipeViewModel.deleteAllRecipesInDatabase()
                daySelectedViewModel.deleteAllDays()
                Domain().updateSharedPrefFirstConnexion(true)
                setupSyncFirebase()

            } else {
                setupSyncFirebase()
            }
        }
    }

    private fun setupSyncFirebase() {
        if (OnboardingActivity.sharedPrefFirstConnexion.getBoolean(
                OnboardingActivity.FIRST_CONNEXION,
                true
            )
        ) {
            FirebaseCalendarUtils().getAllScheduledDaySelected()
            getAllSavedIngredients()
            Domain().updateSharedPrefFirstConnexion(false)
        } else {
            setupChips()
        }
    }


    private fun setupIngredientsTypeList() {
        ingredientsTypeList.add(IngredientsType.CREAMERY.typeName)
        ingredientsTypeList.add(IngredientsType.FRUITS_VEGETABLES.typeName)
        ingredientsTypeList.add(IngredientsType.FISH.typeName)
        ingredientsTypeList.add(IngredientsType.MEAT.typeName)
        ingredientsTypeList.add(IngredientsType.EPICERIE.typeName)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.searchItem)
        searchItem.isVisible = false
        val clearIngredientItem = menu.findItem(R.id.clearIngredientItem)
        val likeItem = menu.findItem(R.id.likeItem)
        likeItem.isVisible = false
        val result: MutableList<Ingredients>? = ingredientsViewModel.getIngredientsForFreezdgeList()
        clearIngredientItem.isVisible = result?.size != 0

        clearIngredientItem.setOnMenuItemClickListener {
            launchAlertDialog()
            true
        }
        super.onPrepareOptionsMenu(menu)
    }

    // if there is no ingredient change UI to show text, if there is ingredient, show chips
    private fun setupChips() {

        itemAdapter.clear()
        val result: MutableList<Ingredients>? = ingredientsViewModel.getIngredientsForFreezdgeList()

        if (result?.size != 0) {
            not_found.visibility = View.GONE
            imageArrowIng.visibility = View.GONE
            floatingActionButton.visibility = View.VISIBLE
            floatingActionButton.show()
            if (result != null) {
                handleChip(result)
            } else {
                listener?.hideLoader()
            }
        } else {
            not_found.visibility = View.VISIBLE
            imageArrowIng.visibility = View.VISIBLE
            not_found.text = getString(R.string.no_item_found_ingredients)
            floatingActionButton.visibility = View.VISIBLE
            floatingActionButton.show()
            listener?.hideLoader()
        }

    }

    private fun getAllSavedIngredients() {
        listener?.showLoader()
        IngredientListHelper.getAllIngredients(
            FirebaseAuth.getInstance().currentUser?.uid
        )?.get()
            ?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result?.documents?.isNotEmpty() == true) {

                        task.result?.documents?.let {
                            it.forEach { ingredientList ->
                                val ingredient: Ingredients? =
                                    ingredientList.toObject(Ingredients::class.java)
                                ingredient?.let { it1 ->
                                    ingredientsViewModel.updateIngredientSelectedByName(
                                        it1.name,
                                        it1.selectedIngredient
                                    )
                                }
                                ingredient?.let { it1 ->
                                    ingredientsViewModel.updateIngredientSelectedForGroceryByName(
                                        it1.name,
                                        it1.grocerySelectedIngredient
                                    )
                                }
                            }
                            setupChips()

                        } ?: kotlin.run {
                            setupChips()
                        }
                    } else {
                        setupChips()
                    }
                }
            }?.addOnFailureListener {
                Log.e(
                    "firebase",
                    "Problem during the ingredient search"

                )
                setupChips()
            }
    }

    // configure chip with ingredient name, color
    private fun handleChip(result: MutableList<Ingredients>) {

        not_found.visibility = View.GONE
        val items = mutableListOf<GenericItem>()
        items.add(CalendarDayNameItem().apply {
            this.dayName = getString(R.string.ingredients_list_page_name)
        })
        ingredientsTypeList.forEach { sectionList ->
            val ingredientsByType: MutableList<Ingredients>? = mutableListOf()
            result.forEach {
                if (it.typeIngredient == sectionList) {
                    ingredientsByType?.add(it)
                }
            }
            if (ingredientsByType?.size != 0) {
                items.add(GroceryItem().apply {
                    this.ingredientTypeName = sectionList
                    this.ingredientsByType = ingredientsByType
                    this.isIngredientType = true
                    this.context = getContext()
                })
            }


        }
        itemAdapter.add(items)
        listener?.hideLoader()
    }


    // Open Search Ingredient Activity on floating button click
    private fun openSearchIngredientActivity() {
        activity?.let {
            val intent = Intent(it, SearchIngredientsActivity::class.java)
            it.startActivity(intent)
        }
    }

    //launch dialog to choose if we really want to clear our ingredient list
    private fun launchAlertDialog() {
        val builder = context?.let { MaterialAlertDialogBuilder(it) }
        builder?.setTitle(getString(R.string.menu_bottom_ingredient_at_home))
        builder?.setMessage(getString(R.string.dialog_question_clear_ingredients))

        builder?.setPositiveButton(getString(R.string.Yes)) { _, _ ->
            Toast.makeText(
                activity,
                getString(R.string.ingredient_list_clear), Toast.LENGTH_SHORT
            ).show()
            unselectAllIngredients()
        }

        builder?.setNegativeButton(android.R.string.no) { dialog, _ ->
            Toast.makeText(
                activity,
                getString(R.string.dialog_cancel_action), Toast.LENGTH_SHORT
            ).show()
            dialog.dismiss()
        }
        builder?.show()
    }


    //clear all ingredients in the list and put ingredient not selected in the objectbox database
    private fun unselectAllIngredients() {
        val result: MutableList<Ingredients>? = ingredientsViewModel.getIngredientsForFreezdgeList()
        if (result != null) {
            for (myresult in result) {
                // Set chip close icon click listener
                ingredientsViewModel.updateIngredientSelectedByName(
                    myresult.name,
                    false
                )
                myresult.name?.let { it1 ->
                    GlobalScope.launch(Dispatchers.Main) { updateGroceryListIfNecessary(it1) }
                }
            }
        }
        setupChips()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: ChipClickEvent) {
        GlobalScope.launch(Dispatchers.IO) {
            ingredientsViewModel.updateIngredientSelectedByName(
                event.chipText,
                false
            )
        }
        GlobalScope.launch(Dispatchers.Main) { updateGroceryListIfNecessary(event.chipText) }
    }


    private fun updateGroceryListIfNecessary(ingredientName: String?) {
        daySelectedViewModel.getSelectedDay()?.forEach { daySelected ->
            val lunchRecipe = daySelected.lunch?.let { recipeViewModel.getRecipeLiveDataById(it) }
            val dinnerRecipe = daySelected.dinner?.let { recipeViewModel.getRecipeLiveDataById(it) }
            updateGroceryToTrue(lunchRecipe, ingredientName)
            updateGroceryToTrue(dinnerRecipe, ingredientName)
        }
    }


    private fun updateGroceryToTrue(recipe: Recipes?, ingredientName: String?) {
        recipe?.recipeIngredients?.let {
            domain.retrieveListFromString(it).forEach { eachIngredient ->
                if (eachIngredient.contains(ingredientName.toString(), true)) {
                    ingredientsViewModel.updateIngredientSelectedForGroceryByName(
                        ingredientName,
                        true
                    )
                }
            }
        }
    }


}