package com.inved.freezdge.utils

import com.inved.freezdge.recipes.database.Recipes
import io.objectbox.Box

class AddRecipesInDatabase(private var recipeBox: Box<Recipes>?) {

    init {
        addRecipes()

    }

    private fun addRecipes() {

        if (recipeBox?.isEmpty == true) {
            recipeBox?.put(
                Recipes(
                    recipeTitle = "Burger et frites de patate douce",
                    recipeCalories = "",
                    totalrecipeTime = "45 min",
                    preparationTime = "10 min",
                    cuisineType = "Americain",
                    dishType = "Main course",
                    cookedTime = "35 min",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/frite_patate_douce_burger.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
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

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Poulet yassa",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "Africain",
                    dishType = "Main course",
                    cookedTime = "",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/poulet_yassa_tresor_afrique.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/trésor_afrique_logo.jpg",
                    recipeUrlOwnerLink = "https://www.facebook.com/tresordafriktraiteur",
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


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Bar à l’africaine",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "Africain",
                    dishType = "Main course",
                    cookedTime = "",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/bar_tresor_afrique.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/trésor_afrique_logo.jpg",
                    recipeUrlOwnerLink = "https://www.facebook.com/tresordafriktraiteur",
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

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Pâtes fusilli façon bolognaise",
                    recipeCalories = "",
                    totalrecipeTime = "30 min",
                    preparationTime = "",
                    cuisineType = "Italien",
                    dishType = "Main course",
                    cookedTime = "",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/fusili_bolo_mntraiteur.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/aime_n_traiteur.jpg",
                    recipeUrlOwnerLink = "https://www.facebook.com/Aime-N-Traiteur-489588211127218/",
                    recipeIngredients = "500g de pâtes fusilli, 800g de viande hachée, 500g de julienne de légumes surgelés, 1 c à s d'huile, Sel, Poivre, Basilic séché, 1 cube de bouillon, 1 oignon, 1 bocal de sauce cuisinée aux légumes (400g environ) ",
                    numberPersons = 8,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Faire cuire les pâtes comme indiqué sur le paquet",
                    step2 = "Faire revenir la viande hachée avec l'huile et l'oignon, le bouillon, et un peu de sel",
                    step3 = "Lorsque la viande est égrénée assaisonnez puis ajoutez les légumes. Bien mélanger.",
                    step4 = "Cuire pendant 5 minutes environ et mettre la sauce tomate",
                    step5 = "Cuire encore 5 minutes.",
                    step6 = "C'est prêt !",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Saka saka (Brazaville)",
                    recipeCalories = "",
                    totalrecipeTime = "2h",
                    preparationTime = "30min",
                    cuisineType = "Congolais",
                    dishType = "Main course",
                    cookedTime = "2h",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/frite_patate_douce_burger.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "1 boule congélée de saka saka de 500g, 2 oignons, 1 courgette, 1 aubergine,1 poivron, 1 poisson chinchard ou colin ,200ml d'huile, 250g de beurre de cacahuète, 1 cuillère à soupe d'huile de Palme",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 10,
                    step1 = "Décongeler la boule et la nettoyer (chercher s'il y a des intrus). Mettre la boule dans une casserole, couvrir avec suffisamment d'eau;faire bouillir à grand feu",
                    step2 = "A ébullition réduire le feu pour maintenir l'ébullition. Faire cuire pendant une heure, en remuant de temps en temps, rajouter de l'eau si besoin. C'est cuit lorsque les feuilles sont bien molles sous la dent",
                    step3 = "Couper les légumes (courgettes, poivrons, oignons) en dés, écraser les aubergines, les ajouter dans la casserole, et faire bouillir jusqu'à cuisson des légumes. Ajouter l'huile et continuer la cuisson.",
                    step4 = "une fois que l'eau est suffisamment réduite, émietter le poisson et l'incorporer dans le mélange;laisser mijoter pendant 10min",
                    step5 = "Délayer le beurre de cacachète dans un peu d'eau froide et incorporer au mélange",
                    step6 = "Laisser mijoter une dizaine de minutes à feu très doux, jusqu'à ce que le mélange devienne plus foncé",
                    step7 = "Ajuster l'huile (une cuillère à soupe d'huile de palme si besoin)",
                    step8 = "Salez et rajouter des épices à votre convenance (ail en poudre, poivre, muscade...)",
                    step9 = "Astuce : c'est encore meilleur le lendemain",
                    step10 = "Variante : Avec 1/4 de choux blanc",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Poisson salé",
                    recipeCalories = "",
                    totalrecipeTime = "25min",
                    preparationTime = "5min",
                    cuisineType = "Congolais",
                    dishType = "Plat principal",
                    cookedTime = "20min",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "500g de poisson salé coupé en morceaux, 2 gros oignons, 1 poivron rouge, 1 poivron jaune, 1 poivron vert, huile de tournesol",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Dessaler le poisson en le trempant dans l'eau pendant 12h en changeant l'eau fréquemment",
                    step2 = "Le lendemain, bien laver le poisson en le passant sous l'eau chaude, l'écailler en même temps",
                    step3 = "Frire le poisson dans une poêle avec un peu d'huile jusqu'à ce que chaque face soit bien dorée",
                    step4 = "Dans une autre poêle, mettre un peu d'huile, et faire revenir les oignons et les poivrons coupés en lamelles",
                    step5 = "Incorpoer le poisson frit, mélanger délicatement avec les oignons et les poivrons, rajouter un petit filet d'eau et couvrir pendant 5 minutes",
                    step6 = "Disposer dans un plat et c'est prêt : se mange avec du riz, de la chikwang, de la babane frie...",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Bouillon de porc aux plantains (Ngoulou Mu Mako)",
                    recipeCalories = "",
                    totalrecipeTime = "1h15",
                    preparationTime = "55min",
                    cuisineType = "Congolais",
                    dishType = "Plat principal",
                    cookedTime = "20min",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "1 rouelle de porc, 2 bananes plantains, 1 oignon, 1 oignon vert, 2 gousses d'ail ",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Couper la rouelle de porc en morceaux et saler",
                    step2 = "Faire revenir dans une casserole, sans huile et sans eau. Faire dégorger à petit feu",
                    step3 = "Une fois qu'il n'y a plus d'eau, faire revenir avec l'huile naturelle du porc, les dorer",
                    step4 = "Mettre les oignons et l'ail, et couvrir avec de l'eau jusqu'à cuisson complète du porc",
                    step5 = "Couper les bananes en 4 ou 5 morceaux maximum selon sa longueur",
                    step6 = "5 minutes avant la fin de la cuisson, incorporer les bananes",
                    step7 = "Ajuster le sel, c'est prêt",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Haricots blancs au poisson salé",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "Congolais",
                    dishType = "Plat principal",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "250g de poisson salé coupés en petits morceaux dessalé, 500g d'haricots blancs, & boite de 250g de purée de tomate, 4 cuillières à soupe d'huile, 1 oignon",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Faire cuire les haricots 40min à la cocotte minute en les trempant (l'eau doit être au-dessus des haricots) ",
                    step2 = "Une fois les haricots cuits, bien les égoutter et les rincer, réserver",
                    step3 = "Prendre le poisson salé préalablement dessalé (12h pour le dessalement en changeant régulièrement l'eau) et le frire, réserver",
                    step4 = "Dans une casserole, faire revenir l'huile, les oignons coupés en dés, la purée de tomate",
                    step5 = "Incorporer le poisson salé et les haricots, couvrir d'eau jusqu'au au niveau des haricots, laisser mijoter pendant 15min",
                    step6 = "Saler et poivrer à votre convenance, c'est prêt !",
                    step7 = "Variante : Remplacer les haricots secs par une boite de 500g d'haricots blancs en boite, en rinçant préalablement à l'eau froide et en égouttant, réserver. Puis reprendre à l'étape 3",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Poulet fumé aux courges (M'bika)",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "1 poulet fumé coupé en morceaux,",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "Retirer la peau du poulet, assaisoner selon votre convenance avec du sel et du poivre. Mettre dans un récipient, entourer de papier film; laisser reposer 1h",
                    step2 = "Pendant",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )



            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "",
                    recipePhotoUrlOwner = "",
                    recipeUrlOwnerLink = "",
                    recipeIngredients = "",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "",
                    step2 = "",
                    step3 = "",
                    step4 = "",
                    step5 = "",
                    step6 = "",
                    step7 = "",
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