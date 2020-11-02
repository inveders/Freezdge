package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.databinding.ActivityMyGroceryListBinding
import com.inved.freezdge.ingredientslist.adapter.GroceryItem
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.enumtype.SupermarketSectionType
import com.inved.freezdge.utils.eventbus.ChipClickEvent
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import kotlinx.android.synthetic.main.fragment_my_ingredients_list.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MyGroceryListActivity: BaseActivity() {

    private lateinit var binding: ActivityMyGroceryListBinding
    private lateinit var ingredientsViewmodel: IngredientsViewModel
    private var supermarketSectionList: MutableList<String>? = mutableListOf()
    var itemAdapter = GenericItemAdapter()
    var fastAdapter = FastAdapter.with(itemAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbarBaseActivity(R.string.toolbar_grocery_list)
       initViewModel()
        setupRecyclerView()
        setupSupermarketSection()
        setupChips()
    }

    private fun setupSupermarketSection() {
        supermarketSectionList?.add(SupermarketSectionType.PAINS_PATISSERIE.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.PAINS_MIE.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.BOUCHERIE.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.VOLAILLE_GIBIERS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.POISSONNERIE.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.FRUITS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.LEGUMES.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.LAITS_OEUFS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.BEURRES_CREMES.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.FROMAGES.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.CHARCUTERIE.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.YAHOURTS_PRODUITS_LAITIERS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.DESSERTS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.BOISSONS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.EPICERIE_SUCREE.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.PATES_RIZ_FECULENTS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.CONSERVES.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.ASSAISONNEMENTS_CONDIMENTS.sectionName)
        supermarketSectionList?.add(SupermarketSectionType.SURGELES.sectionName)
    }

    private fun initViewModel() {
        val viewModelFactory = Injection.providesViewModelFactory(App.ObjectBox.boxStore)
        ingredientsViewmodel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(IngredientsViewModel::class.java)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_my_grocery_list
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("BACKPRESS", 0)
        startActivity(intent)
    }

    // configure chip with ingredient name, color
    private fun setupChips() {

        ingredientsViewmodel.getIngredientsForGrocery()
            .observe(this, Observer { result ->
                if (result != null) {
                    if (result.size != 0) {
                        itemAdapter.clear()
                        not_found.visibility = View.GONE
                        val items = mutableListOf<GenericItem>()
                        supermarketSectionList?.forEach {sectionList->
                            val ingredientsByType:MutableList<Ingredients>? = mutableListOf()
                            result.forEach {
                                if(it.supermarketSection==sectionList){
                                    ingredientsByType?.add(it)
                                }
                            }
                            if(ingredientsByType?.size!=0){
                                items.add(GroceryItem().apply {
                                    this.ingredientTypeName = sectionList
                                    this.ingredientsByType = ingredientsByType
                                    this.context = this@MyGroceryListActivity
                                })
                            }


                        }
                        itemAdapter.add(items)
                    } else {
                        not_found.visibility = View.VISIBLE
                        not_found.text = getString(R.string.no_item_found_grocery)
                    }
                }
            })
    }

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        EventBus.getDefault().unregister(this)
        super.onPause()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: ChipClickEvent) {
        ingredientsViewmodel.updateIngredientSelectedByName(event.chipText, true)
        ingredientsViewmodel.updateIngredientSelectedForGroceryByName(
            event.chipText,
            false
        )
    }



    private fun setupRecyclerView() {

        recyclerview?.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerview?.adapter = fastAdapter

    }
}