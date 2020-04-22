package com.inved.freezdge.uiGeneral.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.ui.*
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.android.synthetic.main.fragment_fish.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

abstract class BaseIngredientsSearchFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    lateinit var ingredientViewmodel: IngredientsViewModel
    private val foodSearchItemAdapter = ItemAdapter<Ingredients>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(getLayoutRes(), container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
        initViewModel()
        insertFood()
        setupRecyclerView()
        detectWichFragmentIsOpen()
        return view
    }

    abstract fun getLayoutRes(): Int

    //INITIALIZATION
    private fun initViewModel() {
        ingredientViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)

    }

    private fun detectWichFragmentIsOpen() {
        when {
            getForegroundFragment() is CreamFragment -> run {
                getAllFoodByType(getString(R.string.ingredient_type_cream))
            }
            getForegroundFragment() is FruitsVegetablesFragment -> run {
                getAllFoodByType(getString(R.string.ingredient_type_fruits_vegetables))
            }
            getForegroundFragment() is EpicerieFragment -> run {
                getAllFoodByType(getString(R.string.ingredient_type_epicerie))
            }
            getForegroundFragment() is FishFragment -> run {
                getAllFoodByType(getString(R.string.ingredient_type_fish))
            }
            getForegroundFragment() is MeatFragment -> run {
                getAllFoodByType(getString(R.string.ingredient_type_meat))
            }
        }
    }

    fun getForegroundFragment(): Fragment? {
        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.navHostIngredient)
        return if (navHostFragment == null) null else navHostFragment.childFragmentManager.fragments[0]
    }

    private fun insertFood() {
        ingredientViewmodel.insertIngredients()
    }

    fun getAllFoodByType(typeIngredient:String) {
        foodSearchItemAdapter.clear()
        ingredientViewmodel.getAllIngredientsByType(typeIngredient).observe(viewLifecycleOwner, Observer {
            foodSearchItemAdapter.add(it)

        })

    }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapterFoodSearch


        fastAdapterFoodSearch.onClickListener= { v: View?, _: IAdapter<Ingredients>, item: Ingredients, pos: Int ->
            v?.let {

                val bool:Boolean? =ingredientViewmodel.isIngredientSelected(item.name)
                Log.d("debago", "boolean in ingredient search is $bool")
                if(bool!!){
                    item.getViewHolder(v).imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
                }else{
                    item.getViewHolder(v).imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
                }

                GlobalScope.async (Dispatchers.IO) {
                    Log.d("debago", "In coroutine")
                    ingredientViewmodel.updateIngredient(item)
                    if(ingredientViewmodel.isIngredientSelectedInGrocery(item.name)){
                        ingredientViewmodel.updateIngredientSelectedForGroceryByName(item.name,false)
                    }
                }


            }
            true
        }


    }
}