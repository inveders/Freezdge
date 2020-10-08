package com.inved.freezdge.utils

import com.inved.freezdge.recipes.database.Recipes
import io.objectbox.Box

class AddRecipesInDatabase(private var recipeBox: Box<Recipes>?) {

    init {
        addRecipes()

    }

    private fun addRecipes() {

        //FREEZDGE RECIPES

        if (recipeBox?.isEmpty == true) {
            recipeBox?.put(
                Recipes(
                    recipeTitle = "Burger et frites de patate douce",
                    recipeCalories = "",
                    totalrecipeTime = 45,
                    preparationTime = 10,
                    cuisineType = "Americain",
                    dishType = "Main course",
                    cookedTime = 35,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/frite_patate_douce_burger.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "1 pain de burger,1 steak haché,2 cornichons,1 patate douce,Ail,Poivre,Sel,Herbes de Provence,Huile d’olive,Ketchup,Mayonnaise,1 oignon",
                    numberPersons = 1,
                    selectedRecipe = false,
                    numberSteps = 9,
                    step1 = "Préchauffer le four à 180°",
                    step2 = "Éplucher la patate douce, et la découper en frites",
                    step3 = "Assaisonner les frites de patates douce avec l’ail, le poivre, le sel à votre convenance, puis verser dessus 2 cuillères à soupe d’huile d’olive et malaxer les frites pour les imprégner d’huile",
                    step4 = "Mettre les frites de patate douce dans du papier aluminium dans un plat au four et laisser cuire 35 minutes (tourner de temps en temps)",
                    step5 = "Faire cuire le steak dans une poêle en l’assaisonnant de sel, de poivre et d’herbes de Provence (10 min de chaque côté)",
                    step6 = "Pendant ce temps, ciseler l’oignon et le suer dans de l’huile dans une petite casserole",
                    step7 = "Rajouter du ketchup et de la mayonnaise en quantité égale et mélanger jusqu’à obtenir une sauce à votre convenance",
                    step8 = "Sur le pain de burger, tartiner la sauce sur les deux faces du pain, découpez quelques cornichons en tranches et les placer sur la partie basse du pain ",
                    step9 = "Mettre le steak dans le pain de burger et servir les frites de patate douce encore chaude, Bon appétit !",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Saka saka (Brazaville)",
                    recipeCalories = "",
                    totalrecipeTime = 150,
                    preparationTime = 30,
                    cuisineType = "Congolais",
                    dishType = "Main course",
                    cookedTime = 120,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/saka-saka_brazaville.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "1 boule congélée de saka saka de 500g,2 oignons,1 courgette,1 aubergine,1 poivron,1 poisson chinchard ou colin,200ml d'huile,250g de beurre de cacahuète,Huile de Palme",
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Poisson salé",
                    recipeCalories = "",
                    totalrecipeTime = 25,
                    preparationTime = 5,
                    cuisineType = "Congolais",
                    dishType = "Main course",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/poisson_salé.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "500g de poisson salé coupé en morceaux,2 gros oignons,1 poivron rouge,1 poivron jaune,1 poivron vert,huile de tournesol",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Dessaler le poisson en le trempant dans l'eau pendant 12h en changeant l'eau fréquemment",
                    step2 = "Le lendemain, bien laver le poisson en le passant sous l'eau chaude, l'écailler en même temps",
                    step3 = "Frire le poisson dans une poêle avec un peu d'huile jusqu'à ce que chaque face soit bien dorée",
                    step4 = "Dans une autre poêle, mettre un peu d'huile, et faire revenir les oignons et les poivrons coupés en lamelles",
                    step5 = "Incorpoer le poisson frit, mélanger délicatement avec les oignons et les poivrons, rajouter un petit filet d'eau et couvrir pendant 5 minutes",
                    step6 = "Disposer dans un plat et c'est prêt : se mange avec du riz, de la chikwang, de la banane frie...",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Bouillon de porc aux plantains (Ngoulou Mu Mako)",
                    recipeCalories = "",
                    totalrecipeTime = 75,
                    preparationTime = 55,
                    cuisineType = "Congolais",
                    dishType = "Main course",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/ngoulou_mu_mako.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "1 rouelle de porc,2 bananes plantains,1 oignon,1 oignon vert,2 gousses d'ail",
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Haricots blancs au poisson salé",
                    recipeCalories = "",
                    totalrecipeTime = 35,
                    preparationTime = 5,
                    cuisineType = "Congolais",
                    dishType = "Main course",
                    cookedTime = 30,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/haricots_blancs_poisson_salé.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "250g de poisson salé coupés en petits morceaux dessalé,500g d'haricots blancs en boite,1 boite de 250g de purée de tomate,Huile,1 oignon",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Egoutter les haricots blancs, les rincer et les réserver",
                    step2 = "Prendre le poisson salé préalablement dessalé (12h pour le dessalement en changeant régulièrement l'eau) et le frire, réserver",
                    step3 = "Dans une casserole, faire revenir 4 cuillères à soupe d'huile, les oignons coupés en dés, la purée de tomate",
                    step4 = "Incorporer le poisson salé et les haricots, couvrir d'eau jusqu'au au niveau des haricots, laisser mijoter pendant 15min",
                    step5 = "Saler et poivrer à votre convenance, c'est prêt !",
                    step6 = "Variante : avec des haricots blans secs -> Faire cuire les haricots 40min à la cocotte minute en les trempant (l'eau doit être au-dessus des haricots). Rincer, réserver, puis reprendre à l'étape 2",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

           /* recipeBox?.put(
                Recipes(
                    recipeTitle = "Poulet fumé aux courges (M'bika)",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "Main course",
                    cookedTime = "",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/no_image.jpg",
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )*/


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Tartine avocat saumon",
                    recipeCalories = "",
                    totalrecipeTime = 10,
                    preparationTime = 10,
                    cuisineType = "Européen",
                    dishType = "Starter",
                    cookedTime = 0,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/tartine_avocat_saumon.jpeg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "Pain complet de seigle,Avocat,Saumon frais,Huile d'olive,Citron",
                    numberPersons = 1,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Couper l'avocat en petits rectangles",
                    step2 = "Couper le saumon frais en fines tranches",
                    step3 = "Couper le pain en 2 grands rectangles et y déposer les petits rectangles d'avocats comme sur la photo",
                    step4 = "Déposer une tranche de saumon sur l'ensemble",
                    step5 = "Vous pouvez ajouter un filet d'huile d'olive au dessus et y presser un peu de citron si vous le souhaitez",
                    step6 = "Note : peut être mangé en Snack à 16h. Bon appétit",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            //AUDREY LE GOFF RECIPES

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Wok saumon sauté au brocolis et au quinoa",
                    recipeCalories = "",
                    totalrecipeTime = 75,
                    preparationTime = 40,
                    cuisineType = "Asiatique, chinoise",
                    dishType = "Main course",
                    cookedTime = 35,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/wok_saumon_sauté_brocolis_audrey_le_goff.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/audrey_le_goff.jpg",
                    recipeUrlOwnerLink = "https://cuisine-test.com/2019/04/11/saumon-saute-au-brocoli-et-au-quinoa-recette-du-livre-wok-de-audrey-le-goff/",
                    recipeIngredients = "4 pavés de saumon,2 citrons vert,Huile d'olive,150 g de quinoa,2 échalottes,1 botte de brocolis,50 g d'amande effilées,Sauce soja,Sel,Poivre",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 12,
                    step1 = "La recette nécessite un temps de repos de 1 h, alors je vous conseille d'anticiper la préparation et ne pas attendre la dernière minutes pour se lancer",
                    step2 = "Le brocoli se mange très croquant dans cette recette, si vous n'aimez pas le côté croquant, faites cuire le brocoli pendant 3 minutes dans une eau bien bouillante.",
                    step3 = "Commencez par couper les pavés de saumon en gros cube puis disposez-les dans un grand bol. Pressez les citrons puis arrosez les morceaux de saumon avec,",
                    step4 = "Ajoutez 2 cuillères à soupe d'huile d'olive. Mélangez puis couvrez avec une assiette et laisser mariner pendant une heure au frigo",
                    step5 = "Faites cuire le quinoa selon les indications portées sur l'emballage puis réserver. Lavez le brocoli et détaillez-le en petits bouquets. Épluchez les échalotes et émincez-les finement,",
                    step6 = "Faites griller les amandes dans le wok 1 à 2 minutes justes le temps qu'elles prennent une légère coloration en mélangeant constamment. Vous pouvez faire cette étape au four,",
                    step7 = "Dans le wok versez une demi-cuillère à soupe d'huile d'olive puis faîtes dorer les cubes de saumon pendant 3 minutes à feu vif. Faites cette opération en plusieurs fois,",
                    step8 = "Retirez le poisson et réserver dans une assiette,",
                    step9 = "Versez une cuillère à soupe d'huile d'olive dans le wok vide puis faites sauter les échalotes et le brocoli environ 5 minutes à feu moyen, ",
                    step10 = "Salez et poivrez selon votre goût puis ajoutez le saumon et le quinoa cuit,",
                    step11 = "Arrosez avec 3 cuillères à soupe de sauce soja. Mélangez délicatement et laissez cuire encore 3 minutes,",
                    step12 = "Servez aussitôt après la cuisson et parsemez avec les amandes grillées,",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )


          /*  recipeBox?.put(
                Recipes(
                    recipeTitle = "Tartine guacamole et sa salade d'épinards",
                    recipeCalories = "",
                    totalrecipeTime = "",
                    preparationTime = "",
                    cuisineType = "",
                    dishType = "",
                    cookedTime = "",
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/salade_epinard_tartine_guacamole.jpeg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )*/

            //TRESOR D'AFRIQUE RECIPES

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Poulet yassa",
                    recipeCalories = "",
                    totalrecipeTime = 100,
                    preparationTime = 40,
                    cuisineType = "Africain",
                    dishType = "Main course",
                    cookedTime = 60,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/poulet_yassa_tresor_afrique.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/trésor_afrique_logo.jpg",
                    recipeUrlOwnerLink = "https://www.facebook.com/tresordafriktraiteur",
                    recipeIngredients = "4 cuisses de poulet de préférence élevé en plein air,Jus de citron,Moutarde,2 gros oignons,2 gousses d’ail,Huile de votre choix,Sel fin,Poivre blanc,Poivre noir,1 feuille de laurier",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Lavez et nettoyez les cuisses de poulet à l’eau claire. Vous pouvez garder ou retirer la peau selon vos préférences.",
                    step2 = "Mettre les morceaux dans un saladier, salez, puis incorporez le 3 cuillères à soupe de jus de citron (ou le jus de 2 citrons) et bien mélanger.",
                    step3 = "Incorporez ensuite les autres assaisonnements : la gousse d’ail écrasée,½ cuillère à café de poivre noir, ½ cuillère à café de  poivre blanc, les 2 cuillères à soupe de moutarde. Incorporez aussi l’oignon coupé en lamelles moyennes, et 1 cuillère à soupe d’huile. Bien mélanger le tout. Laissez reposer environ 2 heures au frais en mélangeant toutes les demi-heures afin que les éléments incorporent bien le poulet.",
                    step4 = "Faire chauffer un peu d’huile dans une poêle et faire revenir les cuisses de poulet uniquement, à feu moyennement fort, à raison de 7 minutes environ pour chaque côté, afin qu’ils soient bien dorés, puis réservez.",
                    step5 = "Dans la même poêle, retirez l’excédent d’huile et faire revenir le reste de l’assaisonnement (mélange d’oignon, moutarde …) à feu moyen pendant 10 minutes. Ajoutez régulièrement un peu l’eau, à chaque fois que la préparation s’assèche . En effet, le mélange ne doit ni coller à la poêle, ni être trop liquide. La sauce (oignon comprit) doit avoir la consistance d’une pâte à crêpe.",
                    step6 = "Rectifiez l’assaisonnement et incorporez les cuisses de poulet à la sauce. Couvrir si possible, et laisser mijoter à feu doux pendant 5 minutes. Retournez chaque cuisse de poulet et laisser à nouveau mijoter 5 minutes.",
                    step7 = "Servir avec du riz blanc.",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Bar à l’africaine",
                    recipeCalories = "",
                    totalrecipeTime = 35,
                    preparationTime = 15,
                    cuisineType = "Africain",
                    dishType = "Main course",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/bar_tresor_afrique.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/trésor_afrique_logo.jpg",
                    recipeUrlOwnerLink = "https://www.facebook.com/tresordafriktraiteur",
                    recipeIngredients = "1 bar entier,1 oignon jaune,1 grosse tomate,1 gousse d’ail,1 citron,Sel,Poivre blanc,Poivre noir,½ Gingembre en poudre,Moutarde,Huile d’olive",
                    numberPersons = 2,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Videz et nettoyez le poisson. Le tremper dans un peu d’eau salée et citronnée. Nettoyez puis rincer.",
                    step2 = "Faire 4-5 entailles sur chacune des faces du poisson.",
                    step3 = "Assaisonnez l’intérieur et l’extérieur avec l’ail écrasé, le sel, ½ cuillère café de poivre blanc, ½ cuillère café de poivre noir, gingembre en poudre. Finir en versant un filet d’huile d’olive et laisser reposer 2 heures au frais après avoir recouvert de cellophane.",
                    step4 = "Dans un peu d’huile, faire cuire le bar pendant 7-8 minutes à feu moyennement fort afin de faire dorer la première face.",
                    step5 = "Retournez délicatement le poisson et incorporez sur le poisson, l’oignon coupé en fine lamelles et la tomate coupée en dés. Couvrir et laissez cuire à feu doux pendant 5 minutes.",
                    step6 = "Faire descendre les oignons et la tomate tout autour du poisson afin qu’ils cuisent à leur tour. Couvrir à nouveau et laisser à feu doux pendant 10 minutes en mélanger à nouveau le mix oignon/tomate au bout de 5 minutes.",
                    step7 = "Servez avec du riz blanc ou l’accompagnement de votre choix (semoule, abolo, gari, manioc)",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            //MN TRAITEUR RECIPES

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Pâtes fusilli façon bolognaise",
                    recipeCalories = "",
                    totalrecipeTime = 30,
                    preparationTime = 10,
                    cuisineType = "Italien",
                    dishType = "Main course",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/fusili_bolo_mntraiteur.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/aime_n_traiteur.jpg",
                    recipeUrlOwnerLink = "https://www.facebook.com/Aime-N-Traiteur-489588211127218/",
                    recipeIngredients = "500g de pâtes fusilli,800g de viande hachée,500g de julienne de légumes surgelés,Huile,Sel,Poivre,Basilic séché,1 cube de bouillon,1 oignon,1 bocal de sauce cuisinée aux légumes (400g environ)",
                    numberPersons = 8,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Faire cuire les pâtes comme indiqué sur le paquet",
                    step2 = "Faire revenir la viande hachée avec 1 cuillère à soupe de l'huile et l'oignon, le bouillon, et un peu de sel",
                    step3 = "Lorsque la viande est égrénée assaisonnez puis ajoutez les légumes. Bien mélanger.",
                    step4 = "Cuire pendant 5 minutes environ et mettre la sauce tomate",
                    step5 = "Cuire encore 5 minutes.",
                    step6 = "C'est prêt !",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            //LA CUISINE DE MONICA RECIPES

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Quiche brocolis épinards feta tomates séchées",
                    recipeCalories = "",
                    totalrecipeTime = 55,
                    preparationTime = 25,
                    cuisineType = "Française",
                    dishType = "Main course",
                    cookedTime = 30,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/quiche_brocolis_epinards_feta_tomate_sechees_cuisine_monica.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/la_cuisine_de_monica.png",
                    recipeUrlOwnerLink = "https://www.youtube.com/watch?v=1-CNtEnP530&feature=youtu.be",
                    recipeIngredients = "1 pâte brisée,380g de brocolis (sans pied),300g d’épinards,200g de feta,70g de tomates séchées,4 oeufs,250g de fromage grec,Sel,Poivre",
                    numberPersons = 8,
                    selectedRecipe = false,
                    numberSteps = 8,
                    step1 = "Cuire le brocolis 8 minutes dans l'eau bouillante. Laisser refroidir.",
                    step2 = "Cuire les épinards à la poêle. Ils vont bien diminuer en taille, c'est ça qui est cool :)",
                    step3 = "Couper votre fêta en dés et couper finement vos tranches de tomates séchées.",
                    step4 = "Préparer votre appareil à quiche avec 4 oeufs et 250g de fromage grec. Saler et poivrer. Le fromage grec rend plus légère la quiche et nous emmène encore plus en Grèce avec la fêta déjà présente.",
                    step5 = "Sortez votre pâte brisée et mettez-là dans votre moule à tarte. Commencer par napper avec vos épinards, puis la feta et les tomates séchées (gardez-en quelques unes)",
                    step6 = "Verser votre appareil à quiche. Ajouter le brocolis que vous avez détaché en bouquet et enlever un peu les pieds. Finissez par les morceaux de tomates séchées restantes.",
                    step7 = "Enfournez dans un four préchauffé à 200°C pendant 30 minutes.",
                    step8 = "Note : Servir avec une salade et ça vous fait un repas complet pour le soir.",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )


            //NADYA HUSSAIN RECIPES

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Churros au Milk-Shake à la fraise",
                    recipeCalories = "",
                    totalrecipeTime = 15,
                    preparationTime = 10,
                    cuisineType = "Américain",
                    dishType = "Desserts",
                    cookedTime = 5,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/Nadya_churros_milk-shake_fraise.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/nadya_hussain.jpg",
                    recipeUrlOwnerLink = "https://www.nadiyahussain.com",
                    recipeIngredients = "300g de farine de blé avec de la levure incorporée,Levure chimique,Sucre glace,275 ml de lait,2 oeufs,Huile,Milk-Shake à la framboise en poudre",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Mettre la farine dans un grand bol et ajouter 2 cuillères à soupe de levure chimique et 2 cuillères à soupe de sucre glace",
                    step2 = "Ajouter le lait et les oeufs, puis mélanger le tout avec un fouet pour avoir une pâte bien homogène et épaisse. Il faut que ça coule sans être liquide",
                    step3 = "Prendre un verre long et y insérer une poche à douille. Remplir la poche à douille avec la pâte, fermer simplement avec une pince.",
                    step4 = "Faire chauffer l'huile dans une casserole. Une fois que l'huile est chaude, ouvrir l'extremité de la douille et appuyer dessus pour faire sortir la pâte dans l'huile. Faire des formes de serpentins qui se touchent comme pour les churros",
                    step5 = "Dans l'huile, la pâte gonfle et remonte à la surface. Compter 1 minute de cuisson de chaque côté",
                    step6 = "Dès que les beignets sortent de l'huilde, saupoudrer de Milk-shake à la framboise en poudre (soyez généreux)",
                    step7 = "Bon appétit",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Cookie aux pépites de chocolat à la poêle",
                    recipeCalories = "",
                    totalrecipeTime =30,
                    preparationTime = 10,
                    cuisineType = "Américain",
                    dishType = "Desserts",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/Nadya_cookies.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/nadya_hussain.jpg",
                    recipeUrlOwnerLink = "https://www.nadiyahussain.com",
                    recipeIngredients = "1 oeuf,Extrait d'amandes,Extrait de vanille,225g de farine,Bicarbonate de sodium,Sel,150g de beurre doux,Sucre brun,Pépites de chocolat ",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "Prendre 2 bols, un pour le ingrédients secs, un pour les liquides",
                    step2 = "Casser un oeuf dans le bol pour liquides, ajouter de l'extrait d'amandes et de l'extrait de vanille (à votre convenance), puis fouetter avec une fourchette",
                    step3 = "Dans le bol pour ingrédients secs ajouter la farine, ½ cuillère à café de bicarbonate de sodium, et ½ cuillère à café de sel",
                    step4 = "Faire chauffer la poêle, y ajouter le beurre et laisser fondre tranquillement, le feu doit être le plus doux possible.",
                    step5 = "Ajouter du sucre brun (à votre convenance) pour avoir une pâte qui résiste un peu sous la dent",
                    step6 = "Verser les ingrédients secs et bien mélanger, ça commence à ressembler à de la pâte à cookie.",
                    step7 = "Verser les ingrédients liquide (oeuf) et faire attention à ce moment là de ne pas trop trainer, bien étaler la pâte sur l'ensemble de la poêle de façon homogène",
                    step8 = "Placer les pépites de chocolat à votre convenance sur le dessus du cookie",
                    step9 = "Laisser cuire à feu très doux pendant 20 minutes, c'est prêt",
                    step10 = "Variante : au lieu des pépites de chocolat, vous pouvez mettre des smarties",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Nouilles instantanées maison",
                    recipeCalories = "",
                    totalrecipeTime = 16,
                    preparationTime = 6,
                    cuisineType = "Asiatique",
                    dishType = "Main course",
                    cookedTime = 10,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/Nadya_nouilles_instantanées_maison.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/nadya_hussain.jpg",
                    recipeUrlOwnerLink = "https://www.nadiyahussain.com",
                    recipeIngredients = "Pâte d'épices,Poulet rôti découpé,Petits pois en boite,Vermicelles instantanées,Oignons coupés,Jus de citron vert,Aneth,Boeuf séché,Kimchi,Ciboule,Paprika,Epinards surgelés,Champignons en conserves,Protéines de soja texturées,Jus de citron,1 oeuf",
                    numberPersons = 3,
                    selectedRecipe = false,
                    numberSteps = 12,
                    step1 = "Pour les trois variantes utiliser des bocaux en verre et de la pâte d'épices (la recette est dans l'appli)",
                    step2 = "Mettre 1 cuillère à café de pâte d'épices au fond des trois bocaux (ou plus en fonction des goûts) et les vermicelles instantanées",
                    step3 = "Variante 1 : Poulet petits pois",
                    step4 = "Ajouter les oignons, les petits pois, et le poulet",
                    step5 = "Pour le goût et les saveurs rajouter le jus de citron vert, et une pincée d'aneth. Refermez le bocal c'est prêt ",
                    step6 = "Variante 2 :A boeuf séché",
                    step7 = "Couper le boeuf séché en petits morceaux et l'ajouter dans le bocal, puis insérer du kimchi (les deux se trouvent en supermarché)",
                    step8 = "Puis ajouter la ciboule coupée en petits morceaux, et le paprika à votre convenance",
                    step9 = "Variante 3 : Epinard/Champignons",
                    step10 = "Ajouter les épinargs surgelés, les protéines de soja texturées, et les champignons",
                    step11 = "Insérer également du jus de citron, et un oeuf qu'on casse dans le bocal",
                    step12 = "Les bocaux peuvent être préparés la veille, on met juste de l'eau bouillante dedans qui recouvre le tout, lorsqu'on veut manger, mélanger et c'est prêt en 10 min",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Roulés aux oeufs et aux champignons",
                    recipeCalories = "",
                    totalrecipeTime = 5,
                    preparationTime = 3 ,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 2,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/Nadya_Roulés_aux oeufs_champignons.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/nadya_hussain.jpg",
                    recipeUrlOwnerLink = "https://www.nadiyahussain.com",
                    recipeIngredients = "3 oeufs,Champignons frais,Persil déshydraté,Ail en semoule,Galette de blé,Concentré de tomates séchées,Huile,Olives noires ",
                    numberPersons = 1,
                    selectedRecipe = false,
                    numberSteps = 10,
                    step1 = "Battre 3 oeufs dans un récipient et y ajouter le persil, l'ail, le sel et le poivre",
                    step2 = "Couper les champignons et les olives en lamelles",
                    step3 = "Prendre les galettes et y étaler sur toute la surface le concentré de tomates séchées. Si vous n'en avez pas, prendre du concentré de tomate classique",
                    step4 = "Mettre l'huile dans une poêle, y verser les oeufs",
                    step5 = "Dès que les oeufs commencent à cuire sur le bord, ajouter les champignons, puis les olivres en les répartissant bien sur la surface des oeufs",
                    step6 = "Déposer la galette côté tartiné avec le concentré sur les oeufs, ne pas hésiter à bien appuyer sur la galette",
                    step7 = "Compter 30 secondes et retourner la galette.",
                    step8 = "Variante : on peut ajouter des tomates, des oignons, du fromage, du jambon",
                    step9 = "Rouler la galette sur elle même, et la couper en deux",
                    step10 = "Servir avec de la salade",
                    step11 = "Astuce: On peut les fairee d'avance pour le déjeuner du lendemain",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Cabillaud pané à la marmelade",
                    recipeCalories = "",
                    totalrecipeTime = 25,
                    preparationTime = 15 ,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 10,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/Nadya_cabillaud_pane_marmelade.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/nadya_hussain.jpg",
                    recipeUrlOwnerLink = "https://www.nadiyahussain.com",
                    recipeIngredients = "1 boite de pommes de terres en conserves,Tomates séchées,Sel,Vinaigre balsamique,4 morceaux de Cabillaud,Marmelade,Purée d'ail,Aneth,Chapelure,Flocons de piment",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 11,
                    step1 = "Préchauffer le four à 200°",
                    step2 = "Prendre les pommes de terre et les couper en deux et les mettre dans un plat qui va au four",
                    step3 = "Y ajouter les tomates séchées, et prendre un peu de l'huile végétale de la boite des tomates séchées et la rajouter dans le plat",
                    step4 = "Ajouter au dessus une grosse pincée de sel ert le vinaigre balsamique ",
                    step5 = "Mettre le plat au four pendant le temps de préparer le cabillaud",
                    step6 = "Dans un mixer ajouter la marmelade, la purée d'ail, 4 cuillères à soupe d'aneth, la chapelure, le sel, le piment (à votre convenance). Mixez le tout",
                    step7 = "Sortez les pommes de terre du four",
                    step8 = "Déposer les morceaux de cabillaud sur les pommes de terre",
                    step9 = "Ajouter sur chaque morceau le mélange d'herbes et d'épices avec la marmelade",
                    step10 = "Enfournez pendant 10min",
                    step11 = "Servez c'est prêt !",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Pâte d'épices pour 2 mois au frigo",
                    recipeCalories = "",
                    totalrecipeTime = 30,
                    preparationTime = 5,
                    cuisineType = "Asiatique",
                    dishType = "Other",
                    cookedTime = 25,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/Nadya_pâte_d'épices.png",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/nadya_hussain.jpg",
                    recipeUrlOwnerLink = "https://www.nadiyahussain.com",
                    recipeIngredients = "2 têtes d'ail,3 oignons,Vinaigre balsamique,Sauce soja,Nuoc mam,Sucre roux en poudre,2 petits bocaux de pâte de piment",
                    numberPersons = 0,
                    selectedRecipe = false,
                    numberSteps = 8,
                    step1 = "Plutôt que déplucher chaque gousse d'ail une à une, les mettre dans un bol, y verser de l'eau bouillante et attendre 1min. Puis les éplucher",
                    step2 = "Enlever la peau des oignons",
                    step3 = "Mettre le tout dans un robot mixeur (ail + oignons) et hâcher le tout",
                    step4 = "Faire suer les oignons et l'ail hachés dans une poêle jsuqu'à ce qu'ils soient bien dorés",
                    step5 = "Puis ajouter du vinaigne balsamique, de la sauce soja, du nuoc-mâm, le sucre roux, et le piment",
                    step6 = "Laisser réduire 20 minutes à feu doux",
                    step7 = "Une fois prêt, attendre que ça refroidisse un peu et mettre dans un bocal. Cela se conserve 2 mois dans le frigo",
                    step8 = "Cette pâte dépices sert dans plusieurs recettes, notamment asiatique",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = 0,
                    preparationTime = 0,
                    cuisineType = "",
                    dishType = "",
                    cookedTime = 0,
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = 0,
                    preparationTime = 0,
                    cuisineType = "",
                    dishType = "",
                    cookedTime = 0,
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = 0,
                    preparationTime = 0,
                    cuisineType = "",
                    dishType = "",
                    cookedTime = 0,
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "",
                    recipeCalories = "",
                    totalrecipeTime = 0,
                    preparationTime = 0,
                    cuisineType = "",
                    dishType = "",
                    cookedTime = 0,
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
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = ""
                )
            )


        }
    }
}