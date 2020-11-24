package com.inved.freezdge.utils

import com.inved.freezdge.ingredientslist.database.IngredientsList
import io.objectbox.Box

class AddIngredientsListDatabase(private var ingredientsListBox: Box<IngredientsList>?) {

    init {
        addIngredientsList()
    }

    private fun addIngredientsList() {

        //FREEZDGE INGREDIENTS LIST

        if (ingredientsListBox?.isEmpty == true) {
            //recipe 1
            //  recipeIngredients = "1 pain de burger,1 steak haché,2 cornichons,1 patate douce,Ail,Poivre,Sel,Herbes de Provence,Huile d’olive,Ketchup,Mayonnaise,1 oignon",
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 257, ingredientsName = "pain de burger", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 380, ingredientsName = "steak haché", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 185, ingredientsName = "cornichons", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 125, ingredientsName = "patate douce", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 155, ingredientsName = "ail", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 101, ingredientsName = "herbes de provence", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 223, ingredientsName = "huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 229, ingredientsName = "ketchup", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 238, ingredientsName = "mayonnaise", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 117, ingredientsName = "oignon", ingredientsReplacementId = 83, quantity = 1.0, unit = null, recipeMirror = null))

            //recipe 2
            //  recipeIngredients = "1 boule congélée de saka saka de 500g,2 oignons,1 courgette,1 aubergine,1 poivron,1 poisson chinchard ou colin,200ml d'huile,250g de beurre de cacahuète,Huile de Palme"
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 90, ingredientsName = "1 boule congelée de saka saka", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 117, ingredientsName = "oignons", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 81, ingredientsName = "courgette", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 48, ingredientsName = "aubergine", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 132, ingredientsName = "poivron", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 324, ingredientsName = "poisson chinchard ou colin", ingredientsReplacementId = 325, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 226, ingredientsName = "huile de tournesol", ingredientsReplacementId = 223, quantity = 200.0, unit = "ml", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 159, ingredientsName = "beurre de cacahuète", ingredientsReplacementId = null, quantity = 250.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 225, ingredientsName = "huile de Palme", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 3
            // recipeIngredients = "500g de poisson salé coupé en morceaux,2 gros oignons,1 poivron rouge,1 poivron jaune,1 poivron vert,huile de tournesol",
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 335, ingredientsName = "de poisson salé coupé en morceaux", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 117, ingredientsName = "gros oignons", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 132, ingredientsName = "poivron rouge", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 132, ingredientsName = "poivron jaune", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 132, ingredientsName = "poivron vert", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 226, ingredientsName = "huile de tournesol", ingredientsReplacementId = 223, quantity = 0.0, unit = null, recipeMirror = null))


            //recipe 4
            //recipeIngredients = "1 rouelle de porc,2 bananes plantains,1 oignon,1 ciboulette,2 gousses d'ail",
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 375, ingredientsName = "rouelle de porc", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 51, ingredientsName = "bananes plaintains", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 117, ingredientsName = "oignon", ingredientsReplacementId = 83, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 73, ingredientsName = "ciboulette", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 155, ingredientsName = "gousses d'ail", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))

            //recipe 5
            //recipeIngredients = "250g de poisson salé coupés en petits morceaux dessalé,500g d'haricots blancs en boite,1 boite de 250g de purée de tomate,Huile,1 oignon",
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 335, ingredientsName = "de poisson salé coupés en petits morceaux dessalés", ingredientsReplacementId = null, quantity = 250.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 98, ingredientsName = "d'haricots blancs en boite", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 297, ingredientsName = "de purée de tomate en boite", ingredientsReplacementId = null, quantity = 250.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 226, ingredientsName = "huile de tournesol", ingredientsReplacementId = 223, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 117, ingredientsName = "oignon", ingredientsReplacementId = 83, quantity = 1.0, unit = null, recipeMirror = null))

            //recipe 6
            //recipeIngredients = "Pain complet de seigle,Avocat,Saumon frais,Huile d'olive,Citron",
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 255, ingredientsName = "Pain complet de seigle", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 49, ingredientsName = "Avocat", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 338, ingredientsName = "Saumon frais", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 223, ingredientsName = "Huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 74, ingredientsName = "Citron", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 7
            //recipeIngredients = "4 pavés de saumon,2 citrons vert,Huile d'olive,150 g de quinoa,2 échalottes,1 botte de brocolis,50 g d'amande effilées,Sauce soja,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 338, ingredientsName = "pavés de saumon", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 74, ingredientsName = "citrons vert", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 223, ingredientsName = "Huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 283, ingredientsName = "de quinoa", ingredientsReplacementId = null, quantity = 150.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 83, ingredientsName = "échalottes", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 55, ingredientsName = "botte de brocolis", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 157, ingredientsName = "d'amandes éffilées", ingredientsReplacementId = null, quantity = 50.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 296, ingredientsName = "Sauce soja", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 298, ingredientsName = "Sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 278, ingredientsName = "Poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 8
            //recipeIngredients = "4 cuisses de poulet de préférence élevé en plein air,Jus de citron,Moutarde,2 gros oignons,2 gousses d’ail,Huile de votre choix,Sel fin,Poivre blanc,Poivre noir,1 feuille de laurier",
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 372, ingredientsName = "cuisses de poulet de préférence élevé en plein air", ingredientsReplacementId = null, quantity = 4.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 74, ingredientsName = "jus de citron", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 243, ingredientsName = "moutarde", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 117, ingredientsName = "gros oignons", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 155, ingredientsName = "gousses d'ail", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 226, ingredientsName = "Huile de tournesol", ingredientsReplacementId = 223, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 298, ingredientsName = "Sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 278, ingredientsName = "Poivre blanc", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 278, ingredientsName = "Poivre noir", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 232, ingredientsName = "feuille de laurier", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))

            //recipe 9
            //recipeIngredients = "1 bar entier,1 oignon jaune,1 grosse tomate,1 gousse d’ail,1 citron,Sel,Poivre blanc,Poivre noir,½ Gingembre en poudre,Moutarde,Huile d’olive",
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 320, ingredientsName = "bar entier", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 117, ingredientsName = "oignon jaune", ingredientsReplacementId = 83, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 147, ingredientsName = "grosse tomate", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 155, ingredientsName = "gousse d'ail", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 74, ingredientsName = "citron", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 278, ingredientsName = "poivre blanc", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 278, ingredientsName = "poivre noir", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 212, ingredientsName = "gingembre en poudre", ingredientsReplacementId = null, quantity = 0.5, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 243, ingredientsName = "moutarde", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 223, ingredientsName = "huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 10
            //recipeIngredients = "500g de pâtes fusilli,800g de viande hachée,500g de julienne de légumes surgelés,Huile,Sel,Poivre,Basilic séché,1 cube de bouillon,1 oignon,1 bocal de sauce cuisinée aux légumes (400g environ)",
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 269, ingredientsName = "de pâtes fusilli", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 382, ingredientsName = "de viande hachée", ingredientsReplacementId = null, quantity = 800.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 102, ingredientsName = "de julienne de légumes", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 223, ingredientsName = "Huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 298, ingredientsName = "Sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 278, ingredientsName = "Poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 52, ingredientsName = "Basilic séché", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 166, ingredientsName = "cube de bouillon de boeuf", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 117, ingredientsName = "oignon", ingredientsReplacementId = 83, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 297, ingredientsName = "de sauce cuisinée aux légumes (1 bocal)", ingredientsReplacementId = null, quantity = 400.0, unit = "g", recipeMirror = null))

            //recipe 11
            //recipeIngredients = "1 pâte brisée,380g de brocolis (sans pied),300g d’épinards,200g de feta,70g de tomates séchées,4 oeufs,250g de fromage grec,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 263, ingredientsName = "pâte brisée", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 55, ingredientsName = "de brocolis (sans pied)", ingredientsReplacementId = null, quantity = 380.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 86, ingredientsName = "d'épinards hachés", ingredientsReplacementId = null, quantity = 300.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 15, ingredientsName = "de feta", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 150, ingredientsName = "de tomates séchées", ingredientsReplacementId = null, quantity = 70.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 28, ingredientsName = "oeufs", ingredientsReplacementId = null, quantity = 4.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 15, ingredientsName = "de fromage grec (feta par exemple)", ingredientsReplacementId = null, quantity = 250.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 298, ingredientsName = "Sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 278, ingredientsName = "Poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))


            //recipe 12
            //recipeIngredients = "300g de farine de blé avec de la levure incorporée,Levure chimique,Sucre glace,275 ml de lait,2 oeufs,Huile,Milk-Shake à la framboise en poudre",
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 197, ingredientsName = "de farine de blé avec de la levure incorporée", ingredientsReplacementId = null, quantity = 300.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 233, ingredientsName = "de levure chimique", ingredientsReplacementId = null, quantity = 1.0, unit = "paquet", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 307, ingredientsName = "sucre glace", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 22, ingredientsName = "de lait", ingredientsReplacementId = null, quantity = 275.0, unit = "ml", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 28, ingredientsName = "oeufs", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 226, ingredientsName = "Huile de tournesol", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 240, ingredientsName = "Milk-Shake à la framboise en poudre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 13
            //recipeIngredients = "1 oeuf,Extrait d'amandes,Extrait de vanille,225g de farine,Bicarbonate de sodium,Sel,150g de beurre doux,Sucre brun,Pépites de chocolat ",
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 28, ingredientsName = "oeuf", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 158, ingredientsName = "extrait d'amandes", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 196, ingredientsName = "extrait de vanille", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 197, ingredientsName = "de farine", ingredientsReplacementId = null, quantity = 225.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 161, ingredientsName = "bicarbonate de sodium", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = "de beurre doux", ingredientsReplacementId = null, quantity = 150.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 308, ingredientsName = "sucre brun", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 273, ingredientsName = "pépites de chocolat", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 14
            //recipeIngredients = "Pâte d'épices,Poulet rôti découpé,Petits pois en boite,Vermicelles instantanées,Oignons coupés,Jus de citron vert,Aneth,Boeuf séché,Kimchi,Ciboule,Paprika,Epinards surgelés,Champignons en conserves,Protéines de soja texturées,Jus de citron,1 oeuf",
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 0, ingredientsName = "Pâte d'épices", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = 17))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 371, ingredientsName = "Poulet rôti découpé", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 128, ingredientsName = "Petits pois en boite", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 250, ingredientsName = "Vermicelles de riz instantanées", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 117, ingredientsName = "Oignons coupés", ingredientsReplacementId = 83, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 74, ingredientsName = "Jus de citron", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 156, ingredientsName = "Aneth", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 349, ingredientsName = "Boeuf séché", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 103, ingredientsName = "Kimchi", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 72, ingredientsName = "Ciboule", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 260, ingredientsName = "Paprika", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 86, ingredientsName = "Epinards surgelés", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 63, ingredientsName = "Champignons en conserves", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 281, ingredientsName = "Protéines de soja texturées", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 74, ingredientsName = "Jus de citron", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 28, ingredientsName = "oeuf", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))

            //recipe 15
            //recipeIngredients = "3 oeufs,Champignons frais,Persil déshydraté,Ail en semoule,Galette de blé,Concentré de tomates séchées,Huile,Olives noires",
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 28, ingredientsName = "oeufs", ingredientsReplacementId = null, quantity = 3.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 63, ingredientsName = "Champignons frais", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 127, ingredientsName = "Persil déshydraté", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 155, ingredientsName = "Ail en semoule", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 207, ingredientsName = "Galette de blé", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 150, ingredientsName = "Concentré de tomates séchées", ingredientsReplacementId = 181, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 223, ingredientsName = "Huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 253, ingredientsName = "Olives (noires)", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 16
            //recipeIngredients = "1 boite de pommes de terres en conserves,Tomates séchées,Sel,Vinaigre balsamique,4 morceaux de Cabillaud,Marmelade,Purée d'ail,Aneth,Chapelure,Flocons de piment",
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 134, ingredientsName = "de pommes de terres en conserves", ingredientsReplacementId = null, quantity = 1.0, unit = "boite", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 150, ingredientsName = "tomates séchées", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 315, ingredientsName = "vinaigre balsamique", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 321, ingredientsName = "morceaux de cabillaud", ingredientsReplacementId = null, quantity = 4.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 237, ingredientsName = "marmelade", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 155, ingredientsName = "purée d'ail", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 156, ingredientsName = "aneth", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 174, ingredientsName = "chapelure", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 276, ingredientsName = "flocons de piment", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            
            //recipe 17
            //recipeIngredients = "2 têtes d'ail,3 oignons,Vinaigre balsamique,Sauce soja,Nuoc mam,Sucre roux en poudre,2 petits bocaux de pâte de piment",
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 155, ingredientsName = "têtes d'ail", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 117, ingredientsName = "oignons", ingredientsReplacementId = 83, quantity = 3.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 315, ingredientsName = "vinaigre balsamique", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 296, ingredientsName = "sauce soja", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 252, ingredientsName = "nuoc mam", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 308, ingredientsName = "sucre roux en poudre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 272, ingredientsName = "de pâte de piment", ingredientsReplacementId = 276, quantity = 2.0, unit = "petits bocaux", recipeMirror = null))

            //recipe 18
            //recipeIngredients = "4 tranches de jambon,1 petit reblochon,45 cl de lait entier,60 g de beurre,2 jaunes d'oeufs,450 g de coquillettes,40 g de farine,3 pincées de noix de muscade,Huile d'olive,Sel,Poivre du moulin",
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 360, ingredientsName = "de jambon", ingredientsReplacementId = null, quantity = 4.0, unit = "tranches", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 33, ingredientsName = "petit reblochon", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 22, ingredientsName = "de lait entier", ingredientsReplacementId = null, quantity = 45.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 60.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 28, ingredientsName = "jaunes d'oeufs", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 264, ingredientsName = "de coquillettes", ingredientsReplacementId = null, quantity = 450.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 197, ingredientsName = "de farine", ingredientsReplacementId = null, quantity = 40.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 248, ingredientsName = "de noix de muscade", ingredientsReplacementId = null, quantity = 3.0, unit = "pincées", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 223, ingredientsName = "huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 278, ingredientsName = "poivre du moulin", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 19
            //recipeIngredients = "16 tranches de pain de mie frais,100 g de crème fraîche,Muscade ou cumin en poudre,100 g de jambon blanc en tranche fine ou jambon de dinde,1 trait d’huile d’olive,200 g d’emmental râpé ou parmesan râpé ou gruyère râpé,1 œuf,100 g de beurre,1 botte de ciboulette,15 g de beurre",
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 258, ingredientsName = "de pain de mie frais", ingredientsReplacementId = null, quantity = 16.0, unit = "tranches", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 343, ingredientsName = "de crème fraiche", ingredientsReplacementId = null, quantity = 100.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 245, ingredientsName = "muscade ou cumin en poudre", ingredientsReplacementId = 191, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 360, ingredientsName = "de jambon blanc en tranche fine ou jambon de dinde", ingredientsReplacementId = null, quantity = 100.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 1.0, unit = "trait", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 346, ingredientsName = "d'emmental râpé ou parmesan râpé ou gruyère râpé", ingredientsReplacementId = 353, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 28, ingredientsName = "oeuf", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 100.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 73, ingredientsName = "de ciboulette", ingredientsReplacementId = null, quantity = 1.0, unit = "botte", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 15.0, unit = "g", recipeMirror = null))

            //recipe 20
            //recipeIngredients = "4 oeufs,225 g de roquefort,40 cl de lait,115 g de farine,1 bouquet de ciboulette,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 28, ingredientsName = "oeufs", ingredientsReplacementId = null, quantity = 4.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 366, ingredientsName = "de roquefort", ingredientsReplacementId = null, quantity = 225.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 22, ingredientsName = "de lait", ingredientsReplacementId = null, quantity = 40.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 197, ingredientsName = "de farine", ingredientsReplacementId = null, quantity = 115.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 73, ingredientsName = "de ciboulette", ingredientsReplacementId = null, quantity = 1.0, unit = "bouquet", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 21
            //recipeIngredients = "1 oeuf,15 cl de lait écrémé,125 g de farine 15 cl d'eau gazeuse,Sel,1 tranche épaisse de jambon cuit fumé (150g),200 g de comté,20 cl de crème fraiche liquide,10 cl de lait,10 g de beurre,1.5 c.a.s de farine,Muscade,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 28, ingredientsName = "oeuf", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 22, ingredientsName = "de lait écrémé", ingredientsReplacementId = null, quantity = 15.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 197, ingredientsName = "de farine", ingredientsReplacementId = null, quantity = 125.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 195, ingredientsName = "d'eau gazeuse", ingredientsReplacementId = null, quantity = 15.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 363, ingredientsName = "épaisse de jambon cuit fumé (150 g)", ingredientsReplacementId = null, quantity = 1.0, unit = "tranche", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 8, ingredientsName = "de comté", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 344, ingredientsName = "de crème fraiche liquide", ingredientsReplacementId = null, quantity = 20.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 22, ingredientsName = "de lait", ingredientsReplacementId = null, quantity = 10.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 10.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 197, ingredientsName = "de farine", ingredientsReplacementId = null, quantity = 1.5, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 245, ingredientsName = "muscade", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            //recipe 22
            //recipeIngredients = "3 rouleaux de pâte à pizza,3 mozzarellas,200 g de tomates séchées,2 gousses d'ail,1 boite de tomates pelées,3 c.à.s d'huile d'olive,2 c.à.s d'origan,1 pincée de piment en poudre,Sel",
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 261, ingredientsName = "de pâte à pizza", ingredientsReplacementId = null, quantity = 3.0, unit = "rouleaux", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 359, ingredientsName = "mozzarellas", ingredientsReplacementId = null, quantity = 3.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 150, ingredientsName = "de tomates séchées", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 155, ingredientsName = "gousses d'ail", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 149, ingredientsName = "de tomates pelées", ingredientsReplacementId = null, quantity = 1.0, unit = "boite", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 3.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 119, ingredientsName = "d'origan", ingredientsReplacementId = null, quantity = 2.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 276, ingredientsName = "de piment en poudre", ingredientsReplacementId = null, quantity = 1.0, unit = "pincée", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 23
            //recipeIngredients = "200 g de boulgour,2 blancs de poulet,3 tomates,2 oignons moyens,1 citron jaune,1 petit bouquet de menthe fraiche,1 petit bouquet de persil plat,2 c.à.s d'huile d'olive,Sel,Poivre du moulin.",
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 169, ingredientsName = "de boulgour", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 373, ingredientsName = "blancs de poulet", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 147, ingredientsName = "tomates", ingredientsReplacementId = null, quantity = 3.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 117, ingredientsName = "oignons moyens", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 74, ingredientsName = "citron jaune", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 112, ingredientsName = "petit bouquet de menthe fraiche", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 127, ingredientsName = "petit bouquet de persil plat", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 2.0, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 278, ingredientsName = "poivre du moulin", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 24
            //recipeIngredients = "500 g de tagliatelles,150 g de lardons,1 jaune d'oeuf,200 g de crème fraiche épaisse,100 g de parmesan râpé,1 c.à.s d'huile,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 271, ingredientsName = "de tagliatelles", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 367, ingredientsName = "de lardons", ingredientsReplacementId = null, quantity = 150.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 28, ingredientsName = "jaune d'oeuf", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 343, ingredientsName = "de crème fraiche épaisse", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 362, ingredientsName = "de parmesan râpé", ingredientsReplacementId = null, quantity = 100.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 1.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 25
            //recipeIngredients = "2 râbles de lapin,20 cl de vin blanc,5 c.à.s d'huile d'olive,2 feuilles de laurier,Sel,Poivre,1 salade (romaine),6 tomates cerises,1 c.à.s de jus de citron,50 g de copeaux de parmesan,100 g de petits croutons,1 c.à.s de vinaigre de vin",
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 365, ingredientsName = "de lapin", ingredientsReplacementId = null, quantity = 2.0, unit = "râbles", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 312, ingredientsName = "de vin blanc", ingredientsReplacementId = null, quantity = 20.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 5.0, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 232, ingredientsName = "feuilles de laurier", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 145, ingredientsName = "salade (romaine)", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 148, ingredientsName = "tomates cerises", ingredientsReplacementId = null, quantity = 6.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 74, ingredientsName = "de jus de citron", ingredientsReplacementId = null, quantity = 1.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 362, ingredientsName = "de copeaux de parmesan", ingredientsReplacementId = null, quantity = 50.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 190, ingredientsName = "de petits croutons", ingredientsReplacementId = null, quantity = 100.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 317, ingredientsName = "de vinaigre de vin", ingredientsReplacementId = null, quantity = 1.0, unit = "cuillère à soupe", recipeMirror = null))

            //recipe 26
            //recipeIngredients = "500 g de riz,500g de calamars en rondelles,2 blancs de poulet,18 crevettes roses décortiquées,1 poivron rouge,2 oignons,2 gousses d'ail,8 cl d'huile d'olive,2 c.à.s de concentré de tomate,1 c.à.c de paprika,1 dose de safran en poudre,Persil plat,Sel",
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 286, ingredientsName = "de riz", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 322, ingredientsName = "de calamars en rondelles", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 373, ingredientsName = "blancs de poulet", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 326, ingredientsName = "crevettes roses décortiquées", ingredientsReplacementId = null, quantity = 18.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 132, ingredientsName = "poivron rouge", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 117, ingredientsName = "oignons", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 155, ingredientsName = "gousses d'ail", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 8.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 181, ingredientsName = "de concentré de tomate", ingredientsReplacementId = null, quantity = 2.0, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 260, ingredientsName = "de paprika", ingredientsReplacementId = null, quantity = 1.0, unit = "cuillère à café", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 289, ingredientsName = "de safran en poudre", ingredientsReplacementId = null, quantity = 1.0, unit = "dose", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 127, ingredientsName = "persil plat", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 27
            //recipeIngredients = "500 g de viande de boeuf haché,500 g de courgettes,1 oignon,2 gousses d'ail,6 brins de thym,80 g de gruyère allégé râpé,2 c.à.s d'huile d'olive,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 382, ingredientsName = "de viande de boeuf haché", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 81, ingredientsName = "de courgettes", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 117, ingredientsName = "oignon", ingredientsReplacementId = 83, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 155, ingredientsName = "gousses d'ail", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 311, ingredientsName = "brins de thym", ingredientsReplacementId = null, quantity = 6.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 353, ingredientsName = "de gruyère allégé râpé", ingredientsReplacementId = null, quantity = 80.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 2.0, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 28
            //recipeIngredients = "6 feuilles de laitue,2 boites de thon entier au naturel de 140 g,6 tortillas souples de blé,3 c.à.s de mayonnaise allégée,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 105, ingredientsName = "de laitue", ingredientsReplacementId = null, quantity = 6.0, unit = "feuilles", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 342, ingredientsName = "de thon entier au naturel (2 boites de 140g)", ingredientsReplacementId = null, quantity = 280.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 207, ingredientsName = "souples de blé (galettes de blé)", ingredientsReplacementId = null, quantity = 6.0, unit = "tortillas", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 238, ingredientsName = "de mayonnaise allégée", ingredientsReplacementId = null, quantity = 3.0, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 29
            // recipeIngredients = "800 g d'épaule de veau,4 aubergines,250 g de champignons de paris,2 gousses d'ail,1 bouquet de ciboule,50 g de beurre,1 c.à.s d'huile d'olive,1 c.à.s de concentré de tomate,20 cl de vin blanc sec,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 358, ingredientsName = "d'épaule de veau", ingredientsReplacementId = null, quantity = 800.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 48, ingredientsName = "aubergines", ingredientsReplacementId = null, quantity = 4.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 63, ingredientsName = "de champignons de Paris", ingredientsReplacementId = null, quantity = 250.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 155, ingredientsName = "gousses d'ail", ingredientsReplacementId = null, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 72, ingredientsName = "de ciboule", ingredientsReplacementId = 73, quantity = 1.0, unit = "bouquet", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 50.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 1.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 181, ingredientsName = "de concentré de tomate", ingredientsReplacementId = null, quantity = 1.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 312, ingredientsName = "de vin blanc", ingredientsReplacementId = null, quantity = 20.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 30
            //recipeIngredients = "350 g d'allumettes de jambon,1 branche de romarin,20 g de beurre,300 g de riz,380 g de sauce-tomate en boîte,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 344, ingredientsName = "d'allumettes de jambon", ingredientsReplacementId = null, quantity = 350.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 288, ingredientsName = "de romarin", ingredientsReplacementId = null, quantity = 1.0, unit = "branche", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 20.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 286, ingredientsName = "de riz", ingredientsReplacementId = null, quantity = 300.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 297, ingredientsName = "de sauce tomate en boîte", ingredientsReplacementId = null, quantity = 380.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 31
            //recipeIngredients = "8 tranches de pain de mie,4 tranches de jambon blanc,4 oeufs,4 tranches de fromage type toastinette,50 g de beurre,2 c.à.s d'huile,Sel,Poivre blanc",
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 258, ingredientsName = "de pain de mie", ingredientsReplacementId = null, quantity = 8.0, unit = "tranches", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 360, ingredientsName = "de jambon blanc", ingredientsReplacementId = null, quantity = 4.0, unit = "tranches", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 28, ingredientsName = "oeufs", ingredientsReplacementId = null, quantity = 4.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 19, ingredientsName = "de fromage par type toastinette", ingredientsReplacementId = null, quantity = 4.0, unit = "tranches", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 50.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 2.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 278, ingredientsName = "poivre blanc", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))


            //recipe 32
            //recipeIngredients = "1 chou-fleur,8 carottes,1 citron,6 petits oignons blancs,100 g de petits pois écossés,3 c.à.s de feuilles de coriandre hachées,1 boite de lait de coco,1 c.à.s d'huile d'olive,1 c.à.c de curcuma,1 c.à.c de gingembre en poudre,Sel,Poivre blanc",
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 70, ingredientsName = "chou-fleur", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 57, ingredientsName = "carottes", ingredientsReplacementId = null, quantity = 8.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 74, ingredientsName = "citron", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 117, ingredientsName = "petits oignons blancs", ingredientsReplacementId = 83, quantity = 6.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 128, ingredientsName = "de petits pois écossés", ingredientsReplacementId = null, quantity = 100.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 409, ingredientsName = "de feuilles de coriandre hachées", ingredientsReplacementId = null, quantity = 3.0, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 230, ingredientsName = "de lait de coco", ingredientsReplacementId = null, quantity = 1.0, unit = "boite", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 1.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 515, ingredientsName = "de curcuma", ingredientsReplacementId = null, quantity = 0.0, unit = "cuillère à café", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 212, ingredientsName = "de gingembre en poudre", ingredientsReplacementId = null, quantity = 1.0, unit = "cuillère à café", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 278, ingredientsName = "poivre blanc", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 33
            //recipeIngredients = "200 g de riz grain long,150 g de petits pois (frais ou surgelés),2 oignons,1 poivron vert,1 poivron rouge,3 piments en bocal,1 c.à.s d'olives vertes,50 cl de bouillon de volaille,1 c.à.c de safran en poudre,3 c.à.s d'huile d'olive,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 286, ingredientsName = "de riz grain long", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 128, ingredientsName = "de petits pois (frais ou surgelés)", ingredientsReplacementId = null, quantity = 150.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 117, ingredientsName = "oignons", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 132, ingredientsName = "poivron vert", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 132, ingredientsName = "poivron rouge", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 276, ingredientsName = "piments en bocal", ingredientsReplacementId = null, quantity = 3.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 253, ingredientsName = "d'olives vertes", ingredientsReplacementId = null, quantity = 1.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 168, ingredientsName = "de bouillon de volaille", ingredientsReplacementId = null, quantity = 50.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 289, ingredientsName = "de safran en poudre", ingredientsReplacementId = null, quantity = 1.0, unit = "cuillère à café", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 3.0, unit = "cuillère à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            //recipe 34
            //recipeIngredients = "500 g de filets de dorade,500 g d'oseille,Riz,6 champignons,500 g de chou-fleur surgelés,1 aubergine,1 poivron rouge,20 cl de crème fraiche semi-épaisse,10 cl de vin blanc,50 g de beurre,4 c.à.s d'huile d'olive,Sel,Poivre,Ail",
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 327, ingredientsName = "de filets de dorade", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 120, ingredientsName = "d'oseille", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 286, ingredientsName = "riz", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 63, ingredientsName = "champignons", ingredientsReplacementId = null, quantity = 6.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 70, ingredientsName = "de chou-fleur surgelés", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 48, ingredientsName = "aubergine", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 132, ingredientsName = "poivron rouge", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 343, ingredientsName = "de crème fraiche semi-épaisse", ingredientsReplacementId = null, quantity = 20.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 312, ingredientsName = "de vin blanc", ingredientsReplacementId = null, quantity = 10.0, unit = "cl", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = "de beurre", ingredientsReplacementId = null, quantity = 50.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 223, ingredientsName = "d'huile d'olive", ingredientsReplacementId = 226, quantity = 4.0, unit = "cuillères à soupe", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 278, ingredientsName = "poivre", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 155, ingredientsName = "ail", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 35
            //recipeIngredients = "500 g de viande hachée surgelée,2 oignons,1 gousse d'ail,Huile d'olive,1 carotte,Sauce bolognaise toute prête,Sauce Béchamel,Pâtes lasagnes,Emmental râpé,Persil",
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 382, ingredientsName = "de viande hachée surgelée", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 117, ingredientsName = "oignons", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 155, ingredientsName = "gousse d'ail", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 223, ingredientsName = "Huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 57, ingredientsName = "carotte", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 294, ingredientsName = "de sauce bolognaise toute prête", ingredientsReplacementId = null, quantity = 1.0, unit = "pot", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 293, ingredientsName = "sauce béchamel", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 266, ingredientsName = "de pâtes lasagnes", ingredientsReplacementId = null, quantity = 1.0, unit = "paquet", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 346, ingredientsName = "d'emmental râpé", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 127, ingredientsName = "persil", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 36
            //recipeIngredients = "500 g de viande hachée surgelée,2 oignons,1 gousse d'ail,Huile d'olive,1 carotte,Sauce bolognaise toute prête,500 g de Spaghettis,Emmental râpé,Persil",
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 382, ingredientsName = "de viande hachée surgelée", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 117, ingredientsName = "oignons", ingredientsReplacementId = 83, quantity = 2.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 155, ingredientsName = "gousse d'ail", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 223, ingredientsName = "Huile d'olive", ingredientsReplacementId = 226, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 57, ingredientsName = "carotte", ingredientsReplacementId = null, quantity = 1.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 294, ingredientsName = "de sauce bolognaise toute prête", ingredientsReplacementId = null, quantity = 1.0, unit = "pot", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 267, ingredientsName = "de spaghettis", ingredientsReplacementId = null, quantity = 500.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 346, ingredientsName = "d'emmental râpé", ingredientsReplacementId = null, quantity = 200.0, unit = "g", recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 127, ingredientsName = "persil", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 298, ingredientsName = "sel", ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 37

            //recipe 38

            //recipe 39

            //recipe 40
        }

    }
}
