package com.inved.freezdge.utils

import com.inved.freezdge.recipes.database.Recipes
import io.objectbox.Box

class AddRecipesInDatabase(var recipeBox: Box<Recipes>) {

    init {
        addRecipes()

    }

    private fun addRecipes() {

        if (recipeBox.isEmpty) {
            recipeBox.put(
                Recipes(
                    recipeTitle = "Burger et frites de patate douce",
                    recipeCalories = "",
                    totalrecipeTime = "45 min",
                    preparationTime = "10 min",
                    cookedTime = "35 min",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/frite_patate_douce_burger.jpg",
                    recipePhotoUrlOwner="",
                    recipeUrlOwnerLink="",
                    recipeIngredients = "1 pain de burger, 1 steak haché,2 cornichons, 1 patate douce, Ail, Poivre, Sel, Herbes de Provence, 2 cuillères à soupe d’Huile d’olive, Ketchup, Mayonnaise, 1 oignon",
                    numberPersons = 1,
                    selectedRecipe = false,
                    numberSteps = 9,
                    step1 = "Préchauffer le four à 180°",
                    step2 = "Éplucher la patate douce, et la découper en frites",
                    step3 = "Assaisonner les frites de patates douce avec l’ail, le poivre, le sel à votre convenance, puis verser dessus l’huile d’olive et malaxer les frites pour les imprégner d’huile",
                    step4 = "Mettre les frites de patate douce dans du papier aluminium dans un plat au four et laisser cuire 35 minutes (tourner de temps en temps)",
                    step5 = "Faire cuire le steak dans une poêle en l’assaisonnant de sel, de poivre et d’herbes de Provence (10 min de chaque côté)",
                    step6 = "Pendant ce temps, ciseler l’oignon et le suer dans de l’huile dans une petite casserole",
                    step7 = "Rajouter du ketchup et de la mayonnaise en quantité égale et mélanger jusqu’à obtenir une sauce à votre convenance",
                    step8 = "Sur le pain de burger, tartiner la sauce sur les deux faces du pain, découpez quelques cornichons en tranches et les placer sur la partie basse du pain ",
                    step9 = "Mettre le steak dans le pain de burger et servir les frites de patate douce encore chaude, Bon appétit !",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )
        }
    }
}