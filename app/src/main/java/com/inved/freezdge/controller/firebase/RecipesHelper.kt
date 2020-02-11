package com.inved.freezdge.controller.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class RecipesHelper {

    companion object {
        private const val COLLECTION_NAME:String="recipes"
        private val USER_UID:String?=FirebaseAuth.getInstance().currentUser?.uid

        fun getRecipesCollection():CollectionReference{
            return FirebaseFirestore.getInstance().collection(COLLECTION_NAME)
        }


        // --- CREATE ---

        fun createIngredientsAtHome(ingredientAtHome:String){

            val createIngredientAtHome=Recipes(ingredientAtHome,null,null,null)
            if (USER_UID != null) {
                getRecipesCollection().document(USER_UID).set(createIngredientAtHome)
            }
        }

        // --- GET ---

        fun getMyElements(): Task<DocumentSnapshot>? {
            if (USER_UID != null) {
                return getRecipesCollection().document(USER_UID).get()
            }
            return null
        }

        // --- UPDATE ---

        fun updateIngredientsAtHome(ingredientsAtHome: String): Task<Void>? {
            if (USER_UID != null) {
                getRecipesCollection().document(USER_UID).update("ingredientsAtHome",ingredientsAtHome)
            }
            return null
        }

        fun updateUsedIngredients(usedIngredients: String): Task<Void>? {
            if (USER_UID != null) {
                getRecipesCollection().document(USER_UID).update("usedIngredients",usedIngredients)
            }
            return null
        }

        fun updateChoosenRecipes(choosenRecipes: String): Task<Void>? {
            if (USER_UID != null) {
                getRecipesCollection().document(USER_UID).update("choosenRecipes",choosenRecipes)
            }
            return null
        }

        fun updateGroceryList(groceryList: String): Task<Void>? {
            if (USER_UID != null) {
                getRecipesCollection().document(USER_UID).update("groceryList",groceryList)
            }
            return null
        }

    }



}