package com.inved.freezdge.ingredientslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.databinding.FragmentTypeIngredientsBinding
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.utils.App
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.android.synthetic.main.fragment_type_ingredients.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class TypeIngredientsFragment : Fragment() {

    private lateinit var binding : FragmentTypeIngredientsBinding
    lateinit var ingredientViewmodel: IngredientsViewModel
    val foodSearchItemAdapter = ItemAdapter<Ingredients>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = FragmentTypeIngredientsBinding.inflate(inflater, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        initViewModel()
        setupRecyclerView()
        arguments?.takeIf { it.containsKey("PositionViewpager") }?.apply {
            val position: Int = getInt("PositionViewpager")
            getForegroundFragment(position)
        }
    }

    private fun initViewModel() {
        val viewModelFactory =
            Injection.providesViewModelFactory(App.ObjectBox.boxStore)
        ingredientViewmodel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(IngredientsViewModel::class.java)
    }

    // handle searchview on ingredient name
    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.searchItem)
        val clearIngredientItem = menu.findItem(R.id.clearIngredientItem)
        val likeItem = menu.findItem(R.id.likeItem)
        likeItem.isVisible = false
        clearIngredientItem.isVisible = false
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            val edittext =
                searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            edittext.hint = getString(R.string.search_ingredient_searchview_label)
            val tf = ResourcesCompat.getFont(App.applicationContext(), R.font.bebasneue_regular)
            edittext.typeface = tf
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    if (newText.isNotEmpty()) {

                        foodSearchItemAdapter.clear()
                        val search = newText.toLowerCase(Locale.ROOT)
                        ingredientViewmodel.getAllIngredients()
                            .observe({ lifecycle }, { list ->
                                handleList(list,search)
                            })
                    } else {
                        SearchIngredientsActivity.currentPage?.let { getForegroundFragment(it) }
                    }
                    return true
                }
            })
        }
        return super.onPrepareOptionsMenu(menu)
    }

    // handle searchview result while typing
    fun handleList(list:MutableList<Ingredients>,search:String){
        var count = 0
        if (list.size != 0) {
            list.forEach {
                if (it.name?.toLowerCase(Locale.ROOT)?.contains(search)==true) {
                    foodSearchItemAdapter.add(it)
                    count = count.plus(1)
                }
            }
            if (count == 0) {
                Toast.makeText(
                    activity,
                    getString(R.string.toastNoIngredientResultSearch),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // detect on wich ingredient type page we are (Creamery, Fruit & vegetables, fish, meat or epicerie)
    fun getForegroundFragment(value: Int) {
        when (value) {
            0 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_cream))
            }
            1 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_fruits_vegetables))
            }
            2 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_fish))
            }
            3 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_meat))
            }
            4 -> run {
                getAllFoodByType(getString(R.string.ingredient_type_epicerie))
            }
        }
    }

    // fill adapter with good ingredient (from good type)
    private fun getAllFoodByType(typeIngredient: String) {
        foodSearchItemAdapter.clear()
        ingredientViewmodel.getAllIngredientsByType(typeIngredient)
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                foodSearchItemAdapter.add(it)
            })
    }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = fastAdapterFoodSearch
        fastAdapterFoodSearch.onClickListener =
            { v: View?, _: IAdapter<Ingredients>, item: Ingredients, _: Int ->
                v?.let {
                    val bool: Boolean? = ingredientViewmodel.isIngredientSelected(item.name)
                    if (bool==true) {
                        item.getViewHolder(v).imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
                    } else {
                        item.getViewHolder(v).imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
                    }
                    GlobalScope.launch(Dispatchers.IO) {
                        ingredientViewmodel.updateIngredient(item)
                        if (ingredientViewmodel.isIngredientSelectedInGrocery(item.name)==true) {
                            ingredientViewmodel.updateIngredientSelectedForGroceryByName(
                                item.name,
                                false
                            )
                        }
                    }
                }
                true
            }
    }
}