package com.inved.freezdge.ingredientslist.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.ingredientslist.database.Ingredients

class FirebaseIngredientsUtils {

    fun getIngredientByName(ingredientName: String?,isToDelete:Boolean,isInGrocery: Boolean,isSelected:Boolean,ingredient: Ingredients?) {
        IngredientListHelper.getIngredientByName(
            FirebaseAuth.getInstance().currentUser?.uid,
            ingredientName
        )?.get()
            ?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result?.documents?.size == 0) {
                        createIngredientInFirebase(ingredient)
                    }else if (task.result?.documents?.isNotEmpty() == true) {
                       if(isToDelete){
                           deleteIngredient(task.result!!.documents[0].id)
                       } else{
                           updateIngredientInSelected(isSelected,task.result!!.documents[0].id)
                           updateIngredientInGrocery(isInGrocery,task.result!!.documents[0].id)
                       }
                    }
                }
            }?.addOnFailureListener {
                Log.e(
                    "firebase",
                    "Problem during the ingredient search"

                )
            }
    }

    private fun createIngredientInFirebase(ingredient:Ingredients?){
        FirebaseAuth.getInstance().currentUser?.uid?.let {
            IngredientListHelper.createIngredient(
                it,
                ingredient
            )
        }
    }

    private fun deleteIngredient(ingredientId: String) {
        IngredientListHelper.deleteIngredients(
            FirebaseAuth.getInstance().currentUser?.uid,
            ingredientId
        )
    }

    private fun updateIngredientInGrocery(isInGrocery: Boolean,ingredientId: String) {
        IngredientListHelper.updateIngredientGrocery(
            FirebaseAuth.getInstance().currentUser?.uid,
            isInGrocery,ingredientId
        )
    }

    private fun updateIngredientInSelected(isSelected: Boolean,ingredientId: String) {
        IngredientListHelper.updateIngredientSelected(
            FirebaseAuth.getInstance().currentUser?.uid,
            isSelected,ingredientId
        )
    }

}