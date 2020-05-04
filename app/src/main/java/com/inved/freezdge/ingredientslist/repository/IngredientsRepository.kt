package com.inved.freezdge.ingredientslist.repository

import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.database.IngredientsDAO
import io.objectbox.android.ObjectBoxLiveData


class IngredientsRepository {

    companion object {

        fun getIngredientsLiveDataBySelected(): MutableList<Ingredients> {
            return IngredientsDAO.getAllIngredientBySelected()
        }

        fun getIngredientsLiveDataBySelectedForGrocery(): ObjectBoxLiveData<Ingredients> {
            return IngredientsDAO.getAllIngredientBySelectedForGrocery()
        }

        fun getIngredientsLiveDataById(): ObjectBoxLiveData<Ingredients> {
            return IngredientsDAO.getAllIngredientsById()
        }

        fun getIngredientsLiveDataByTypeId(typeIngredient:String): ObjectBoxLiveData<Ingredients> {
            return IngredientsDAO.getAllIngredientsByTypeId(typeIngredient)
        }


        fun isIngredientSelected(name: String?): Boolean {
            return IngredientsDAO.isIngredientSelected(name)
        }

        fun isIngredientSelectedInGrocery(name: String?): Boolean {
            return IngredientsDAO.isIngredientSelectedInGrocery(name)
        }

        fun insertIngredients() {
            return IngredientsDAO.insertIngredients()
        }

        fun updateIngredient(ingredient: Ingredients) {
            return IngredientsDAO.updateIngredient(ingredient)
        }

        fun updateIngredientSelectedByName(name: String?,bool:Boolean) {
            return IngredientsDAO.updateIngredientSelectedByName(name,bool)
        }

        fun updateIngredientSelectedForGroceryByName(name: String?,bool:Boolean) {
            return IngredientsDAO.updateIngredientSelectedForGroceryByName(name,bool)
        }



        //Mock data for testing
        fun initDatabase() {
       /*     val mTotalCount:Long = 7
            val valueIcon: Int = R.drawable.ic_btn_speak_now
            val modelList: ArrayList<Ingredients> = ArrayList()
            if (IngredientsDAO.getIngredientsBox().count() != mTotalCount) {
                IngredientsDAO.removeAll()
            }
            if (IngredientsDAO.getIngredientsBox().count() == 0) {
                for (i in 0 until mTotalCount) {
                    modelList.add(Ingredients(i.toLong(), "Beurre","Crèmerie","valueIcon",false))
                }
                IngredientsDAO.getIngredientsBox().put(modelList)
            }*/
        }
    }



}