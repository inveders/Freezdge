package com.inved.freezdge.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class IngredientsHelper {

    companion object {
        private const val COLLECTION_GENERAL:String="Freezdge"
        private val USER_UID:String?= FirebaseAuth.getInstance().currentUser?.uid
        const val COLLECTION_AT_HOME_INGREDIENT:String="at_home_ingredients"
        const val COLLECTION_USED_INGREDIENT:String="used_ingredients"
        const val COLLECTION_GROCERY_LIST:String="grocery_list"

        fun getIngredientsCollection(goodCollection:String): CollectionReference? {
            return USER_UID?.let {
                FirebaseFirestore.getInstance().collection(COLLECTION_GENERAL).document(
                    it
                ).collection(goodCollection)
            }
        }

        // --- CREATE ---

     /*   fun createIngredient(collectionName:String,ingredientName:String,numberIngredients:Int){

            val createIngredient=Ingredients(ingredientName,numberIngredients)

                getIngredientsCollection().document(USER_UID).set(createIngredientAtHome)
            }
        }


        // --- GET ---

        fun getMyElements(collectionName:String): Task<DocumentSnapshot>? {
            if (USER_UID != null) {
                return getIngredientsCollection().document(USER_UID).get()
            }
            return null
        }

        // --- UPDATE ---

        fun updateIngredientsAtHome(collectionName:String,ingredientsAtHome: String): Task<Void>? {
            if (USER_UID != null) {
                getIngredientsCollection().document(USER_UID).update("ingredientsAtHome",ingredientsAtHome)
            }
            return null
        }

        fun updateUsedIngredients(collectionName:String,usedIngredients: String): Task<Void>? {
            if (USER_UID != null) {
                getIngredientsCollection().document(USER_UID).update("usedIngredients",usedIngredients)
            }
            return null
        }

        fun updateChoosenRecipes(collectionName:String,choosenRecipes: String): Task<Void>? {
            if (USER_UID != null) {
                getIngredientsCollection().document(USER_UID).update("choosenRecipes",choosenRecipes)
            }
            return null
        }

        fun updateGroceryList(collectionName:String,groceryList: String): Task<Void>? {
            if (USER_UID != null) {
                getIngredientsCollection().document(USER_UID).update("groceryList",groceryList)
            }
            return null
        }*/

    }
}