package com.inved.freezdge.ingredientslist.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.inved.freezdge.ingredientslist.database.Ingredients

class IngredientListHelper {

    companion object{
        private const val COLLECTION_NAME = "users"

        private const val SUB_COLLECTION_INGREDIENT_LIST = "ingredientsList"

        // --- COLLECTION REFERENCE ---
        private fun getUsersIngredientsListCollection(uid: String): CollectionReference? {
            return FirebaseFirestore.getInstance()
                .collection(COLLECTION_NAME).document(uid)
                .collection(SUB_COLLECTION_INGREDIENT_LIST)
        }

        // --- CREATE ---
        fun createIngredient(
            uid: String,
            ingredient:Ingredients?
        ): Task<Void?>? {
            // 1 - Create Obj
            return ingredient?.let { getUsersIngredientsListCollection(uid)?.document()?.set(it) }
        }

        // --- GET ---
        fun getAllIngredients(uid: String?): Query? {
            return uid?.let {
                getUsersIngredientsListCollection(
                    it
                )
            }
        }

        fun getIngredientByName(uid: String?,ingredientName: String?): Query? {
            return uid?.let {
                getUsersIngredientsListCollection(it)
                    ?.whereEqualTo("name", ingredientName)
            }
        }

        fun updateIngredientGrocery(
            uid: String?,isInGrocery: Boolean?,id:String
        ): Task<Void?>? {
            return uid?.let { getUsersIngredientsListCollection(it)
                ?.document(id)?.update("grocerySelectedIngredient", isInGrocery) }
        }

        fun updateIngredientSelected(
            uid: String?,isSelected: Boolean?,id:String
        ): Task<Void?>? {
            return uid?.let { getUsersIngredientsListCollection(it)
                ?.document(id)?.update("selectedIngredient", isSelected) }
        }

        // --- DELETE ---
        fun deleteIngredients(
            uid: String?,
            id: String
        ) {
            uid?.let {
                getUsersIngredientsListCollection(
                    it
                )?.document(id)?.delete()
            }
        }
    }
}