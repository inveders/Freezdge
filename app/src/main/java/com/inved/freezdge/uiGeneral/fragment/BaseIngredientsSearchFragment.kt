package com.inved.freezdge.uiGeneral.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.ui.SearchIngredientsActivity
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.utils.App
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.*


abstract class BaseIngredientsSearchFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    lateinit var ingredientViewmodel: IngredientsViewModel
    val foodSearchItemAdapter = ItemAdapter<Ingredients>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(getLayoutRes(), container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
        setHasOptionsMenu(true)
        initViewModel()
        setupRecyclerView()
        return view
    }

    override fun onResume() {
        super.onResume()
        SearchIngredientsActivity.currentPage?.let { getForegroundFragment(it) }
    }

    abstract fun getLayoutRes(): Int

    //INITIALIZATION
    private fun initViewModel() {
        ingredientViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)

    }

    override fun onPrepareOptionsMenu(menu: Menu) {

        val searchItem = menu.findItem(R.id.search_menu)

        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView

            val edittext =
                searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            edittext.hint = getString(R.string.search_ingredient_searchview_label)
            val tf = ResourcesCompat.getFont(App.applicationContext(), R.font.bebasneue_regular)
            edittext.typeface=tf

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {

                        foodSearchItemAdapter.clear()
                        val search = newText.toLowerCase(Locale.ROOT)
                        ingredientViewmodel.getAllIngredients()
                            .observe({ lifecycle }, { list ->

                                var count =0
                                if(list.size!=0){
                                    list.forEach {
                                        if (it.name!!.toLowerCase(Locale.ROOT).contains(search)) {
                                            foodSearchItemAdapter.add(it)
                                            count=count.plus(1)
                                        }
                                    }

                                    if(count==0){
                                        Toast.makeText(activity,getString(R.string.toastNoIngredientResultSearch),
                                            Toast.LENGTH_SHORT).show()
                                    }

                                }

                            })
                    }else{
                        SearchIngredientsActivity.currentPage?.let { getForegroundFragment(it) }
                    }

                    return true
                }
            })


        }
        return super.onPrepareOptionsMenu(menu)
    }


    fun getForegroundFragment(value:Int) {
         when (value) {
            0 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_cream))
            }
            1 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_fruits_vegetables))
            }
            2 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_epicerie))
            }
            3 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_fish))
            }
            4 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_meat))
            }
        }
    }

    private fun getAllFoodByType(typeIngredient:String) {
        foodSearchItemAdapter.clear()
        ingredientViewmodel.getAllIngredientsByType(typeIngredient).observe(viewLifecycleOwner, Observer {
            foodSearchItemAdapter.add(it)

        })

    }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapterFoodSearch


        fastAdapterFoodSearch.onClickListener= { v: View?, _: IAdapter<Ingredients>, item: Ingredients, _: Int ->
            v?.let {

                val bool:Boolean? =ingredientViewmodel.isIngredientSelected(item.name)
                if(bool!!){
                    item.getViewHolder(v).imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
                }else{
                    item.getViewHolder(v).imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
                }

                GlobalScope.async (Dispatchers.IO) {
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