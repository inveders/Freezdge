package com.inved.freezdge.utils

import com.inved.freezdge.recipes.database.Recipes
import io.objectbox.Box

class AddRecipesInDatabase(var recipeBox: Box<Recipes>) {

    init {
        addRecipes()

    }

    private fun addRecipes() {

        if (recipeBox.isEmpty) {
            //TODO change url for burger to google play page
            recipeBox.put(
                Recipes(
                    recipeTitle = "Burger et frites de patate douce",
                    recipeCalories = "",
                    totalrecipeTime = "45 min",
                    preparationTime = "10 min",
                    cuisineType="Americain",
                    dishType="Main course",
                    cookedTime = "35 min",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/frite_patate_douce_burger.jpg",
                    recipePhotoUrlOwner="gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
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

            recipeBox.put(
                Recipes(
                    recipeTitle = "Poulet yassa",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType="Africain",
                    dishType="Main course",
                    cookedTime = "",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/poulet_yassa_tresor_afrique.jpg",
                    recipePhotoUrlOwner="gs://freezdge.appspot.com/Owners_traiteurs/trésor_afrique_logo.jpg",
                    recipeUrlOwnerLink="https://www.facebook.com/tresordafriktraiteur",
                    recipeIngredients = "4 cuisses de poulet de préférence élevé en plein air, 2 citrons ou 3 cuillères à soupe de jus de citron,2 cuillères à soupe de moutarde,2 gros oignons,2 gousses d’ail,Huile de votre choix,Sel fin,½ cuillère à café de Poivre blanc,½ cuillère à café de Poivre noir,1 feuille de laurier",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Lavez et nettoyez les cuisses de poulet à l’eau claire. Vous pouvez garder ou retirer la peau selon vos préférences.",
                    step2 = "Mettre les morceaux dans un saladier, salez, puis incorporez le jus de citron et bien mélanger.",
                    step3 = "Incorporez ensuite les autres assaisonnements : la gousse d’ail écrasée, le poivre noir, le poivre blanc, la moutarde. Incorporez aussi l’oignon coupé en lamelles moyennes, et 1 cuillère à soupe d’huile. Bien mélanger le tout. Laissez reposer environ 2 heures au frais en mélangeant toutes les demi-heures afin que les éléments incorporent bien le poulet.",
                    step4 = "Faire chauffer un peu d’huile dans une poêle et faire revenir les cuisses de poulet uniquement, à feu moyennement fort, à raison de 7 minutes environ pour chaque côté, afin qu’ils soient bien dorés, puis réservez.",
                    step5 = "Dans la même poêle, retirez l’excédent d’huile et faire revenir le reste de l’assaisonnement (mélange d’oignon, moutarde …) à feu moyen pendant 10 minutes. Ajoutez régulièrement un peu l’eau, à chaque fois que la préparation s’assèche . En effet, le mélange ne doit ni coller à la poêle, ni être trop liquide. La sauce (oignon comprit) doit avoir la consistance d’une pâte à crêpe.",
                    step6 = "Rectifiez l’assaisonnement et incorporez les cuisses de poulet à la sauce. Couvrir si possible, et laisser mijoter à feu doux pendant 5 minutes. Retournez chaque cuisse de poulet et laisser à nouveau mijoter 5 minutes.",
                    step7 = "Servir avec du riz blanc.",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox.put(
                Recipes(
                    recipeTitle = "Bar à l’africaine",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType="Africain",
                    dishType="Main course",
                    cookedTime = "",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/bar_tresor_afrique.jpg",
                    recipePhotoUrlOwner="gs://freezdge.appspot.com/Owners_traiteurs/trésor_afrique_logo.jpg",
                    recipeUrlOwnerLink="https://www.facebook.com/tresordafriktraiteur",
                    recipeIngredients = "1 bar entier,1 oignon jaune,1 grosse tomate,1 gousse d’ail,1 citron,Sel,½ cuillère café de Poivre blanc,½ cuillère café de Poivre noir,½ Gingembre en poudre,Moutarde,Huile d’olive",
                    numberPersons = 2,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Videz et nettoyez le poisson. Le tremper dans un peu d’eau salée et citronnée. Nettoyez puis rincer.",
                    step2 = "Faire 4-5 entailles sur chacune des faces du poisson.",
                    step3 = "Assaisonnez l’intérieur et l’extérieur avec l’ail écrasé, le sel, poivre blanc, poivre noir, gingembre en poudre. Finir en versant un filet d’huile d’olive et laisser reposer 2 heures au frais après avoir recouvert de cellophane.",
                    step4 = "Dans un peu d’huile, faire cuire le bar pendant 7-8 minutes à feu moyennement fort afin de faire dorer la première face.",
                    step5 = "Retournez délicatement le poisson et incorporez sur le poisson, l’oignon coupé en fine lamelles et la tomate coupée en dés. Couvrir et laissez cuire à feu doux pendant 5 minutes.",
                    step6 = "Faire descendre les oignons et la tomate tout autour du poisson afin qu’ils cuisent à leur tour. Couvrir à nouveau et laisser à feu doux pendant 10 minutes en mélanger à nouveau le mix oignon/tomate au bout de 5 minutes.",
                    step7 = "Servez avec du riz blanc ou l’accompagnement de votre choix (semoule, abolo, gari, manioc)",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )
        }
    }
}