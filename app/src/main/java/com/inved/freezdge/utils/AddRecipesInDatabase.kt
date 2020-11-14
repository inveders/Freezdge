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
                    ustensilesList = "", 
                    isForDinner = false
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
                    ustensilesList = "", 
                    isForDinner = false
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
                    ustensilesList = "", 
                    isForDinner = true
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
                    ustensilesList = "", 
                    isForDinner = false
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
                    ustensilesList = "", 
                    isForDinner = false
                )
            )

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
                    ustensilesList = "", 
                    isForDinner = true
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
                    ustensilesList = "", 
                    isForDinner = true
                )
            )

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
                    ustensilesList = "", 
                    isForDinner = false
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
                    ustensilesList = "", 
                    isForDinner = false
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
                    ustensilesList = "", 
                    isForDinner = false
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
                    ustensilesList = "", 
                    isForDinner = true
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
                    ustensilesList = "", 
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Cookie aux pépites de chocolat à la poêle",
                    recipeCalories = "",
                    totalrecipeTime = 30,
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
                    ustensilesList = "", 
                    isForDinner = false
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
                    ustensilesList = "", 
                    isForDinner = true
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Roulés aux oeufs et aux champignons",
                    recipeCalories = "",
                    totalrecipeTime = 5,
                    preparationTime = 3,
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
                    ustensilesList = "", 
                    isForDinner = true
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Cabillaud pané à la marmelade",
                    recipeCalories = "",
                    totalrecipeTime = 25,
                    preparationTime = 15,
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
                    ustensilesList = "", 
                    isForDinner = true
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
                    ustensilesList = "", 
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Gratin de coquilettes au reblochon",
                    recipeCalories = "",
                    totalrecipeTime = 40,
                    preparationTime = 15,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 25,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_gratin_reblochon_coquilette.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "4 tranches de jambon,1 petit reblochon,45 cl de lait entier,60 g de beurre,2 jaunes d'oeufs,450 g de coquillettes,40 g de farine,3 pincées de noix de muscade,Huile d'olive,Sel,Poivre du moulin",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 5,
                    step1 = "Cuisez les coquillettes avec un filet d’huile d’olive. Égouttez et réservez.",
                    step2 = "Dans une grande casserole, faites fondre 40 g de beurre, ajoutez la farine d’un seul coup et fouettez vivement pour homogénéiser. Versez alors le lait et la crème peu à peu sans cesser de battre. Salez, poivrez, parsemez de muscade et continuez à tourner sur feu doux jusqu’à ce que la sauce devienne onctueuse. Hors du feu, incorporez les jaunes d’oeufs.",
                    step3 = "Préchauffez le four à th. 6 – 180 °C. Retirez le plus gros de la croûte du reblochon puis coupez-le en lamelles. Détaillez le jambon en lanières.",
                    step4 = "Amalgamez les pâtes et la sauce, versez la moitié de cette préparation dans un plat à gratin préalablement graissé avec le reste de beurre, ajoutez la moitié du fromage et couvrez de la préparation restante mélangée au jambon",
                    step5 = "Répartissezpar-dessus les dernières lamelles de reblochon et enfournez pour 15 minutes environ, jusqu’à ce que le plat soit bien gratiné.",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "", 
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Croque-Monsieur",
                    recipeCalories = "",
                    totalrecipeTime = 18,
                    preparationTime = 12,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 6,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/tous_en_cuisine_croque-monsieur.jpeg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/tousencuisine_logo.jpeg",
                    recipeUrlOwnerLink = "https://www.cuisineaz.com/communaute/tous-en-cuisine-906949.aspx",
                    recipeIngredients = "16 tranches de pain de mie frais,100 g de crème fraîche,Muscade ou cumin en poudre,100 g de jambon blanc en tranche fine ou jambon de dinde,1 trait d’huile d’olive,200 g d’emmental râpé ou parmesan râpé ou gruyère râpé,1 œuf,100 g de beurre,1 botte de ciboulette,15 g de beurre",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Coupez des tranches de pain de mie si ce n’est pas taillé.",
                    step2 = "Ciselez la ciboulette. Gardez-la de côté.",
                    step3 = "Faites fondre le beurre.",
                    step4 = "Dans un robot ou un bol de mixeur, mixez le fromage râpé, l’œuf et la crème, assaisonnez de sel et parfumez-la de muscade ou de cumin.",
                    step5 = "Il faut que la pâte soit un peu lisse.",
                    step6 = "Nappez les tranches de pain de mie avec ce mélange, déposez le jambon blanc sur 8 tranches, refermez avec 8 autres tranches. Coupez les bords. Badigeonnez de beurre fondu à l’aide d’un pinceau les 2 côtés des tranches.",
                    step7 = "Dans une poêle, versez un peu de beurre fondu qui reste, déposez les croques et dorez des deux faces. Déposez ensuite sur une planche et taillez au couteau en deux. Déposez sur les assiettes à cheval et parsemez de ciboulette ciselée.",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "Saladier,Couteau éminceur,Poêle,Mixeur ou blendeur,Planche,spatule",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Petit flan express au roquefort",
                    recipeCalories = "",
                    totalrecipeTime = 30,
                    preparationTime = 10,
                    cuisineType = "Européen",
                    dishType = "Starter",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_flan_express_roquefort.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "4 oeufs,225 g de roquefort,40 cl de lait,115 g de farine,1 bouquet de ciboulette,Sel,Poivre",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 3,
                    step1 = "Préchauffez le four à th. 7 – 210 °C. Ciselez la ciboulette.",
                    step2 = "Versez la farine, le roquefort, les œufs entiers et le lait dans le bol d’un mixer. Mixez quelques secondes à puissance maximale. Ajoutez la ciboulette, salez légèrement et poivrez.",
                    step3 = "Répartissez la préparation dans 6 ramequins et disposez-les dans un bain-marie. Enfournez pour 20 minutes.",
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
                    ustensilesList = "", 
                    isForDinner = false
                )
            )


            //todo check the number of person
            recipeBox?.put(
                Recipes(
                    recipeTitle = "Crêpe au jambon et au comté",
                    recipeCalories = "",
                    totalrecipeTime = 45,
                    preparationTime = 15,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 30,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmad_Crêpes-au-jambon-et-au-comté.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "1 oeuf,15 cl de lait écrémé,125 g de farine 15 cl d'eau gazeuse,Sel,1 tranche épaisse de jambon cuit fumé (150g),200 g de comté,20 cl de crème fraiche liquide,10 cl de lait,10 g de beurre,1.5 c.a.s de farine,Muscade,Poivre",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 7,
                    step1 = "Tamisez la farine avec le sel, ajoutez l’œuf, puis versez le lait et l’eau gazeuse en filet. Laissez reposer 2 heures.",
                    step2 = "Confectionnez les crêpes. Réservez.",
                    step3 = "Vous pouvez aussi prendre des crêpes surgelées pour gagner du temps et allez directement à l'étape 4",
                    step4 = " Faites fondre le beurre dans une casserole, ajoutez le jambon coupé en gros dés, puis la farine. Mélangez bien. Versez la crème et le lait, faites épaissir en remuant.",
                    step5 = "Incorporez le comté coupé en petits dés et laissez-le fondre. Salez, poivrez et saupoudrez d’une pincée de muscade.",
                    step6 = " Préchauffez le four à th. 6 – 180 °C.",
                    step7 = "Fourrez chaque crêpe avec 2 cuillerées à soupe de garniture. Enfournez pour 10 minutes. Servez bien chaud.",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Pizza tomate mozzarella",
                    recipeCalories = "",
                    totalrecipeTime = 55,
                    preparationTime = 20,
                    cuisineType = "Italien",
                    dishType = "Main course",
                    cookedTime = 35,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_pizza_tomate_mooza.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "3 rouleaux de pâte à pizza,3 mozzarellas,200 g de tomates séchées,2 gousses d'ail,1 boite de tomates pelées,3 c.à.s d'huile d'olive,2 c.à.s d'origan,1 pincée de piment en poudre,Sel",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Pelez et hachez finement les gousses d’ail. Mixez les tomates pelées et leur jus jusqu’à obtention d’un coulis épais. Versez le coulis de tomate et l’ail haché dans une casserole. Salez et faites cuire à feu doux en remuant régulièrement pendant 20 minutes. Retirez du feu et laissez refroidir.",
                    step2 = "Préchauffez le four à th. 6/7 – 200 °C.",
                    step3 = "Lavez les tomates séchées, séchez-les et coupez-les en deux. Gouttez les mozzarellas et coupez-les en tranches. Mélangez l’huile d’olive et le piment.",
                    step4 = " Déroulez les rouleaux de pâte sur le plan de travail fariné. Étalez la sauce tomate sur chacune d’elles. Disposez les tranches de mozzarella et les demi-tomates. Arrosez d’huile pimentée et saupoudrez d’origan.",
                    step5 = "Salez légèrement et faites glisser les pizzas sur une plaque de cuisson recouverte de papier sulfurisé. Enfournez pour 15 minutes. ",
                    step6 = "Servez dés la sortie du four.",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Taboulet au poulet",
                    recipeCalories = "",
                    totalrecipeTime = 35,
                    preparationTime = 15,
                    cuisineType = "Européen",
                    dishType = "Starter",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_taboule-poulet.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "200 g de boulgour,2 blancs de poulet,3 tomates,2 oignons moyens,1 citron jaune,1 petit bouquet de menthe fraiche,1 petit bouquet de persil plat,2 c.à.s d'huile d'olive,Sel,Poivre du moulin.",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Rincez le boulgour à l’eau froide dans une passoire et faites-le cuire 10 à 12 minutes à l’eau bouillante salée.",
                    step2 = "Égouttez-le, aérez-le à la fourchette et laissez-le refroidir dans la passoire.",
                    step3 = "Émincez les blancs de poulet (classique, halal ou cacher) en très -fines lamelles dans le sens de la fibre, salez et poivrez. ",
                    step4 = " Chauffez 1 cuillerée à soupe d’huile d’olive dans une sauteuse à revêtement antiadhésif et faites-y sauter le poulet 2 ou 3 minutes. Laissez refroidir.",
                    step5 = " Lavez les tomates, épépinez-les et coupez-les en tout petits dés. Pelez et hachez les oignons, rincez et séchez les herbes, effeuillez-les et ciselez-les finement. Ajoutez-les à la graine de boulgour refroidie avec les lamelles de poulet. Mélangez.",
                    step6 = " Pressez le citron. Dans un bol, émulsionnez-en le jus avec du sel, du poivre et le reste d’huile d’olive. Versez sur le taboulé et mélangez de nouveau, filmez le saladier et placez au frais jusqu’au moment de servir.",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Tagliatelles à la carbonara",
                    recipeCalories = "",
                    totalrecipeTime = 25,
                    preparationTime = 10,
                    cuisineType = "Italien",
                    dishType = "Main course",
                    cookedTime = 15,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_Tagliatelles-à-la-carbonara.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "500 g de tagliatelles,150 g de lardons,1 jaune d'oeuf,200 g de crème fraiche épaisse,100 g de parmesan râpé,1 c.à.s d'huile,Sel,Poivre",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 4,
                    step1 = "Plongez les pâtes dans de l’eau bouillante salée et faites-les cuire le temps indiqué sur le paquet.",
                    step2 = "Pendant ce temps, faites chauffer l’huile dans une sauteuse et faites dorer les lardons.",
                    step3 = "Quand ils sont bien colorés, ajoutez la crème fraîche et réduisez le feu au minimum. Salez modérément et mélangez. Laissez cuire doucement sans bouillir.",
                    step4 = "Égouttez les pâtes. Versez-les dans la sauteuse, ajoutez le jaune d’œuf et mélangez vivement. Poivrez. Répartissez les pâtes dans des assiettes chaudes et servez aussitôt avec le parmesan râpé.",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Salade César au lapin",
                    recipeCalories = "234",
                    totalrecipeTime = 100,
                    preparationTime = 30,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 70,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_salade-caesar_lapin.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "2 râbles de lapin,20 cl de vin blanc,5 c.à.s d'huile d'olive,2 feuilles de laurier,Sel,Poivre,1 salade (romaine),6 tomates cerises,1 c.à.s de jus de citron,50 g de copeaux de parmesan,100 g de petits croutons,1 c.à.s de vinaigre de vin",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 8,
                    step1 = "Faites chauffer l’huile dans une cocotte et faites dorer les râbles de tous les cotés.",
                    step2 = "Versez le vin blanc, salez, poivrez et ajoutez le laurier. Couvrez et poursuivez la cuisson 1 heure.",
                    step3 = "Pendant ce temps, lavez, épluchez et essorez la salade. ",
                    step4 = "Lavez et coupez les tomates cerise en quatre. Déposez la salade dans un grand saladier. Ajoutez les tomates cerise et les croûtons et mélangez.",
                    step5 = "Sortez les râbles de la cocotte, laissez-les tiédir, puis détachez la chair et coupez-la en petits morceaux. Ajoutez les morceaux de lapin à la salade.",
                    step6 = "Préparez une vinaigrette en fouettant l’huile, le vinaigre et le jus de citron. Salez et poivrez. ",
                    step7 = "Versez la sauce dans le saladier et mélangez bien. Répartissez la salade dans les assiettes et parsemez de copeaux de parmesan.",
                    step8 = "Servez aussitôt.",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Paëlla express",
                    recipeCalories = "",
                    totalrecipeTime = 40,
                    preparationTime = 15,
                    cuisineType = "Espagnol",
                    dishType = "Main course",
                    cookedTime = 25,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_paella_express.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "500 g de riz,500g de calamars en rondelles,2 blancs de poulet,18 crevettes roses décortiquées,1 poivron rouge,2 oignons,2 gousses d'ail,8 cl d'huile d'olive,2 c.à.s de concentré de tomate,1 c.à.c de paprika,1 dose de safran en poudre,Persil plat,Sel",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Coupez les blancs de poulet en cubes.",
                    step2 = "Pelez et hachez finement les oignons et l’ail. Lavez, épépinez et coupez le poivron en tous petits dés.",
                    step3 = "Faites chauffer l’huile dans une cocotte. Faites-y revenir le poivron, l’oignon, l’ail, les cubes de poulet et les rondelles de calamar pendant 5 minutes.",
                    step4 = "Ajoutez le concentré de tomate, versez 2 litres d’eau et portez à ébullition. Laissez cuire 10 minutes.",
                    step5 = " Ajoutez le riz, les crevettes, le safran et le paprika. Poursuivez la cuisson 10 à 12 minutes. Rectifiez l’assaisonnement.",
                    step6 = "Servez aussitôt parsemé de feuilles de persil.",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Hachis parmentier diététique",
                    recipeCalories = "",
                    totalrecipeTime = 55,
                    preparationTime = 20,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 35,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_hachis-parmentier-dietetique.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "500 g de viande de boeuf haché,500 g de courgettes,1 oignon,2 gousses d'ail,6 brins de thym,80 g de gruyère allégé râpé,2 c.à.s d'huile d'olive,Sel,Poivre",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 6,
                    step1 = "Lavez et séchez les courgettes. Coupez-les en morceaux et faites‑les cuire 15 minutes à la vapeur.",
                    step2 = "Pelez et émincez l’oignon et l’ail. Versez 2 cuillerées à soupe d’huile dans une sauteuse et faites-y revenir l’oignon et l’ail sans coloration.",
                    step3 = "Ajoutez la viande hachée et faites cuire 5 minutes en remuant. Salez et poivrez.",
                    step4 = "Préchauffez le four à th. 7 – 210 °C.",
                    step5 = "Écrasez les courgettes à la fourchette. Huilez un plat à gratin et répartissez-y la viande hachée, puis recouvrez de purée de courgette. Salez légèrement, poivrez et parsemez de gruyère râpé.",
                    step6 = "Enfournez pour 20 minutes. Lorsque le hachis est bien gratiné, servez directement dans le plat.",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Wrap au thon",
                    recipeCalories = "",
                    totalrecipeTime = 5,
                    preparationTime = 5,
                    cuisineType = "Européen",
                    dishType = "Starter",
                    cookedTime = 0,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_wraps-au-thon.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "6 feuilles de laitue,2 boites de thon entier au naturel de 140 g,6 tortillas souples de blé,3 c.à.s de mayonnaise allégée,Sel,Poivre",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = " Égouttez le thon et émiettez-le dans un saladier. Ajoutez la mayonnaise, du sel, du poivre et mélangez.",
                    step2 = "Lavez et essorez les feuilles de laitue.",
                    step3 = " Étalez les tortillas sur le plan de travail et garnissez-les d’une feuille de laitue, recouvrez de la préparation au thon. Roulez les tortillas pour les fermer comme une crêpe.",
                    step4 = " Coupez-les en deux en biais. Servez aussitôt, ou réservez au frais emballé dans un film alimentaire.",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Sauté de veau et aubergines vapeur aux champignons",
                    recipeCalories = "",
                    totalrecipeTime = 100,
                    preparationTime = 25,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 75,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_saute_veau_aubegines_vapeur.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "800 g d'épaule de veau,4 aubergines,250 g de champignons de paris,2 gousses d'ail,1 bouquet de ciboule,50 g de beurre,1 c.à.s d'huile d'olive,1 c.à.s de concentré de tomate,20 cl de vin blanc sec,Sel,Poivre",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 5,
                    step1 = "Détaillez le veau en cubes. Lavez et coupez les aubergines en morceaux. Placez-les dans un saladier d’eau salée et laissez-les ainsi pendant 30 minutes. Épongez-les. Cuisez-les à la vapeur  45 minutes.",
                    step2 = "Pendant ce temps, faites fondre le beurre avec 1 cuillerée à soupe d’huile d’olive. Mettez-y la viande à revenir.",
                    step3 = "Ajoutez l’ail pelé et haché ainsi que les champignons. Attendez que l’eau de végétation se soit évaporée puis versez le vin blanc. Salez et poivrez. Poursuivez la cuisson  30 minutes sur feu doux.",
                    step4 = "Mettez les aubergines et cuisez 15 minutes. Ajoutez le concentré de tomate et prolongez la cuisson de 5 minutes sur feu vif. Parsemez de ciboule émincée.",
                    step5 = "Mélangez et servez.",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Riz à la sauce tomate et au jambon",
                    recipeCalories = "",
                    totalrecipeTime = 25,
                    preparationTime = 20,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 5,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_riz_sauce_tomate_jambon.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "350 g d'allumettes de jambon,1 branche de romarin,20 g de beurre,300 g de riz,380 g de sauce-tomate en boîte,Sel,Poivre",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 4,
                    step1 = "Faites cuire le riz le temps indiqué sur le paquet dans une grande quantité d’eau salée.",
                    step2 = "Pendant ce temps, faites fondre le beurre dans une poêle antiadhésive et faites-y rissoler les allumettes de jambon. Égouttez-les et déposez-les sur du papier absorbant.",
                    step3 = "Égouttez le riz et reversez-le dans la casserole avec la sauce-tomate. Mélangez. Ajoutez les lardons, salez et poivrez.",
                    step4 = "Faites réchauffer 5 minutes. Répartissez la préparation dans six assiettes. Décorez d’un brin de romarin et servez aussitôt.",
                    step5 = "",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Croque-Madame",
                    recipeCalories = "",
                    totalrecipeTime = 30,
                    preparationTime = 15,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 15,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_Croque-madame.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "8 tranches de pain de mie,4 tranches de jambon blanc,4 oeufs,4 tranches de fromage type toastinette,50 g de beurre,2 c.à.s d'huile,Sel,Poivre blanc",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 0,
                    step1 = "Beurrez légèrement les tranches de pain de mie. Coupez les tranches de jambon d’abord en deux, puis à la taille des tranches du pain de mie.",
                    step2 = "Sur chaque tranche de pain de mie, posez 2 tranches de jambon l’une sur l’autre, 1 tranche de fromage et recouvrez par 1 tranche de pain de mie.",
                    step3 = " Préchauffez le four à th. 8-240 °C.",
                    step4 = "Posez les croque-monsieur sur la plaque du four recouverte de papier aluminium. Enfournez pour 10 minutes en les retournant à mi-cuisson.",
                    step5 = " Cinq minutes avant la fin de la cuisson, chauffez l’huile dans une poêle. Cassez-y les œufs et faites-les cuire 5 minutes.",
                    step6 = "Mettez les croque-monsieur dans les assiettes, posez 1 œuf au plat dessus, salez et donnez un tour de moulin à poivre. Servez aussitôt.",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Curry express de légumes",
                    recipeCalories = "",
                    totalrecipeTime = 40,
                    preparationTime = 25,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 15,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_curry-chou-fleur.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "1 chou-fleur,8 carottes,1 citron,6 petits oignons blancs,100 g de petits pois écossés,3 c.à.s de feuilles de coriandre hachées,1 boite de lait de coco,1 c.à.s d'huile d'olive,1 c.à.c de curcuma,1 c.à.c de gingembre en poudre,Sel,Poivre blanc",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 8,
                    step1 = "Détaillez le chou-fleur en bouquets, lavez-le.",
                    step2 = "Pelez et lavez les carottes, coupez-les en gros cubes.",
                    step3 = "Épluchez les oignons, coupez-les en quatre. Pressez le citron.",
                    step4 = "Dans un wok, faites bouillir de l’eau salée et mettez le chou-fleur à cuire 4 minutes.",
                    step5 = "Ajoutez les carottes et les petits pois, faites cuire 3 minutes de plus. Égouttez et réservez.",
                    step6 = "Faites revenir les épices avec les oignons et l’huile dans le wok, faites-y sauter tous les légumes 4 minutes en remuant.",
                    step7 = " Salez et poivrez, ajoutez le jus de citron et le lait de coco.",
                    step8 = "Portez à ébullition et ajoutez la coriandre. Laissez cuire 2 minutes et servez.",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Riz à l'espagnole",
                    recipeCalories = "",
                    totalrecipeTime = 45,
                    preparationTime = 15,
                    cuisineType = "Espagnol",
                    dishType = "Main course",
                    cookedTime = 30,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/gourmand_riz-espagnol.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/gourmand_logo.JPG",
                    recipeUrlOwnerLink = "https://gourmand.viepratique.fr/recettes-par-produit",
                    recipeIngredients = "200 g de riz grain long,150 g de petits pois (frais ou surgelés),2 oignons,1 poivron vert,1 poivron rouge,3 piments en bocal,1 c.à.s d'olives vertes,50 cl de bouillon de volaille,1 c.à.c de safran en poudre,3 c.à.s d'huile d'olive,Sel,Poivre",
                    numberPersons = 6,
                    selectedRecipe = false,
                    numberSteps = 5,
                    step1 = "Épluchez et émincez les oignons.",
                    step2 = "Lavez, essuyez et coupez les poivrons en deux, retirez les pépins et émincez-les finement.",
                    step3 = "Faites cuire les petits pois pendant 5 minutes dans une casserole d’eau bouillante salée. Égouttez-les.",
                    step4 = "Dans une grande poêle, faites revenir les oignons dans l’huile d’olive pendant 2 minutes, ajoutez les poivrons et laissez cuire 5 minutes. Ajoutez le riz. Lorsqu’il devient transparent, versez le bouillon de volaille, saupoudrez de safran et laissez cuire 15 minutes. Ajoutez les petits pois et remuez en prolongeant la cuisson de 5 minutes. Salez poivrez.",
                    step5 = "Servez avec les piments égouttés et quelques olives.",
                    step6 = "",
                    step7 = "",
                    step8 = "",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Dorade à la sauce oseille avec ses légumes et son riz",
                    recipeCalories = "",
                    totalrecipeTime = 70,
                    preparationTime = 20,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 50,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/Freezdge_dorade_legumes_riz.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "500 g de filets de dorade,500 g d'oseille,Riz,6 champignons,500 g de chou-fleur surgelés,1 aubergine,1 poivron rouge,20 cl de crème fraiche semi-épaisse,10 cl de vin blanc,50 g de beurre,4 c.à.s d'huile d'olive,Sel,Poivre,Ail",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 12,
                    step1 = "Faites cuire le riz (1 verre de riz pour 1 verre d'eau).",
                    step2 = "Préparation des légumes et du poisson",
                    step3 = "Dans une casserole d'eau bouillante, versez les chou-fleurs et laisser décongeler/cuire pendant 10 minutes. Pendant ce temps coupez les champignons en lamelles. Coupez-les aubergines avec la peau et les poivrons en dés. Salez les aubergines",
                    step4 = "Dans poêle wok, versez 2 c.à.s l'huile, et ajoutez les aubergines, le poivron, et les champignons pendant 7 min. Pendant ce temps égouttez les chou-fleurs, puis couper-les en petits morceaux.",
                    step5 = "Puis ajoutez les aux autres légumes, laissez cuire 5 min en tournant de temps en temps, assaisonez avec du sel, de l'ail et du poivre,du persil",
                    step6 = "Pendant ce temps, faites chauffer 2 c.à.s d'huile dans une autre poêle. Insérer y la dorade assaisonée de sel et de poivre, côté peau, à feu vif pendant 5 min",
                    step7 = "Puis tourner la dorade et laisser cuire à feu doux pendant 10 min",
                    step8 = "Préparation de la sauce oseille",
                    step9 = "Équeuter les feuilles d'oseille à la main. Laver, sécher puis ciseler finement l'oseille. Éplucher les échalotes et les émincer finement.",
                    step10 = "Faire fondre le beurre dans une casserole de taille moyenne en veillant à ne pas le brûler. Ajouter les échalotes et les faire cuire durant 2 à 3 minutes. Quand elles prennent la couleur, déglacer avec le vin. Ajouter l'oseille et remuer à feu doux jusqu'à ce que l'oseille soit également fondue. Couvrir et laisser cuire 5 minutes à feu doux.",
                    step11 = "Ajouter ensuite toute la crème et laisser réduire jusqu'à l'obtention d'une consistance un peu épaisse pendant encore 2 à 3 minutes, saler et poivrer. Mélanger régulièrement avec une cuillère en bois afin que la crème ne brûle pas dans le fond de la casserole.",
                    step12 = "Suggestion de présentation : servir le riz, en boule sur un quart de l'assiette, les légumes sur un autre quart, et placer le poisson sur la moitié de l'assiette avec la sauce oseille versée dessus.",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )


            recipeBox?.put(
                Recipes(
                    recipeTitle = "Lasagnes bolognaise façon Freezdge",
                    recipeCalories = "",
                    totalrecipeTime = 60,
                    preparationTime = 10,
                    cuisineType = "Italien",
                    dishType = "Main course",
                    cookedTime = 50,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/freezdge_lasagnes-bolognaise.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "500 g de viande hachée surgelée,2 oignons,1 gousse d'ail,Huile d'olive,1 carotte,Sauce bolognaise toute prête,Sauce Béchamel,Pâtes lasagnes,Emmental râpé,Persil",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 11,
                    step1 = "Hâcher les oignons et l'ail, puis les faire revenir dans un peu d'huile dans une poêle. Une fois que l'oignon est un peu caramélisée, rajouter la carotte coupée en tout petits cubes, laisser cuire 5 min",
                    step2 = "Ajouter la viande hachée, avec le persil, l'ail et le poivre, laisser cuire jusqu'à ce que la viande hachée soit bien cuite",
                    step3 = "Ajouter la sauce bolognaise et un peu d'eau, puis laisser cuire pendant 15 min, saler et poivrer",
                    step4 = "Préchauffer le four à 180°C",
                    step5 = "Prendre un plat de four (ou équivalent), y mettre de l'eau tiède et un peu d'huile. Utiliser cela pour ramolir les pâtes de lasagnes avant de les disposer dans le plat qui ira au four",
                    step6 = "Prendre un plat de four pour les lasagnes, et y étaler avecun pinceau de la sauce béchamel, puis une couche de pâtes, puis de la bolognaise, puis l'emmental",
                    step7 = "Recommencer encore deux fois (sauce béchamel, pâtes, bolognaise, emmental)",
                    step8 = "Pour terminer mettre des pâtes sur le dessus, puis de la sauce béchamel et de l'emmental avec un peu de parmesan pour fermer",
                    step9 = "Introduire le plat au four pendant 25 min",
                    step10 = "Laisser refroidir un peu et servez. Accompagnez vos lasagnes avec une petite salade",
                    step11 = "Bon appétit",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            recipeBox?.put(
                Recipes(
                    recipeTitle = "Spaghettis bolognaise façon Freezdge",
                    recipeCalories = "",
                    totalrecipeTime = 25,
                    preparationTime = 5,
                    cuisineType = "Italien",
                    dishType = "Main course",
                    cookedTime = 20,
                    recipePhotoUrl = "gs://freezdge.appspot.com/recipes/freezdge_spaghettis-bolognaise.jpg",
                    recipePhotoUrlOwner = "gs://freezdge.appspot.com/Owners_traiteurs/ic_freezdge_launcher-playstore.png",
                    recipeUrlOwnerLink = "https://github.com/inveders/Freezdge",
                    recipeIngredients = "500 g de viande hachée surgelée,2 oignons,1 gousse d'ail,Huile d'olive,1 carotte,Sauce bolognaise toute prête,500 g de Spaghettis,Emmental râpé,Persil",
                    numberPersons = 4,
                    selectedRecipe = false,
                    numberSteps = 8,
                    step1 = "Hâcher les oignons et l'ail, puis les faire revenir dans un peu d'huile dans une poêle. Une fois que l'oignon est un peu caramélisée, rajouter la carotte coupée en tout petits cubes, laisser cuire 5 min",
                    step2 = "Ajouter la viande hachée, avec le persil, l'ail et le poivre, laisser cuire jusqu'à ce que la viande hachée soit bien cuite",
                    step3 = "Ajouter la sauce bolognaise et un peu d'eau, puis laisser cuire pendqnt 15 min, saler et poivrer",
                    step4 = "Pendant ce temps faire cuire les spaghettis dans une casserole d'eau bouillante salée pendant le temps indiqué sur le paquet",
                    step5 = "Une fois les spaghettis cuits, égoutter dans une passoire et remettre dans la casserole",
                    step6 = "Y ajouter la bolognaise et mélanger avec les spaghettis",
                    step7 = "Ajouter l'emmental à votre convenance. Servez et ajoutez du persil frais par dessus",
                    step8 = "Bon appétit",
                    step9 = "",
                    step10 = "",
                    step11 = "",
                    step12 = "",
                    urlVideo = "",
                    ustensilesList = "",
                    isForDinner = false
                )
            )

            //todo lentilles photo à ajouter
           /* recipeBox?.put(
                Recipes(
                    recipeTitle = "Lentilles saucisse de strasbourg et lard",
                    recipeCalories = "",
                    totalrecipeTime = 0,
                    preparationTime = 0,
                    cuisineType = "Européen",
                    dishType = "Main course",
                    cookedTime = 0,
                    recipePhotoUrl = "",
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
                    ustensilesList = "",
                    isForDinner = false
                )
            )*/

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
                    ustensilesList = "",
                    isForDinner=true
                )
            )*/

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
                    ustensilesList = "", 
                    isForDinner = false
                )
            )


        }
    }
}