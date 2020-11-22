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
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 1, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 2
            //  recipeIngredients = "1 boule congélée de saka saka de 500g,2 oignons,1 courgette,1 aubergine,1 poivron,1 poisson chinchard ou colin,200ml d'huile,250g de beurre de cacahuète,Huile de Palme"
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 2, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 3
            // recipeIngredients = "500g de poisson salé coupé en morceaux,2 gros oignons,1 poivron rouge,1 poivron jaune,1 poivron vert,huile de tournesol",
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 3, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))


            //recipe 4
            recipeIngredients = "1 rouelle de porc,2 bananes plantains,1 oignon,1 oignon vert,2 gousses d'ail",
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 4, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 5
            recipeIngredients = "250g de poisson salé coupés en petits morceaux dessalé,500g d'haricots blancs en boite,1 boite de 250g de purée de tomate,Huile,1 oignon",
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 5, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 6
            recipeIngredients = "Pain complet de seigle,Avocat,Saumon frais,Huile d'olive,Citron",
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 6, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 7
            recipeIngredients = "4 pavés de saumon,2 citrons vert,Huile d'olive,150 g de quinoa,2 échalottes,1 botte de brocolis,50 g d'amande effilées,Sauce soja,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 7, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 8
            recipeIngredients = "4 cuisses de poulet de préférence élevé en plein air,Jus de citron,Moutarde,2 gros oignons,2 gousses d’ail,Huile de votre choix,Sel fin,Poivre blanc,Poivre noir,1 feuille de laurier",
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 8, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 9
            recipeIngredients = "1 bar entier,1 oignon jaune,1 grosse tomate,1 gousse d’ail,1 citron,Sel,Poivre blanc,Poivre noir,½ Gingembre en poudre,Moutarde,Huile d’olive",
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 9, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 10
            recipeIngredients = "500g de pâtes fusilli,800g de viande hachée,500g de julienne de légumes surgelés,Huile,Sel,Poivre,Basilic séché,1 cube de bouillon,1 oignon,1 bocal de sauce cuisinée aux légumes (400g environ)",
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 10, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 11
            recipeIngredients = "1 pâte brisée,380g de brocolis (sans pied),300g d’épinards,200g de feta,70g de tomates séchées,4 oeufs,250g de fromage grec,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 11, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))


            //recipe 12
            recipeIngredients = "300g de farine de blé avec de la levure incorporée,Levure chimique,Sucre glace,275 ml de lait,2 oeufs,Huile,Milk-Shake à la framboise en poudre",
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 12, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 13
            recipeIngredients = "1 oeuf,Extrait d'amandes,Extrait de vanille,225g de farine,Bicarbonate de sodium,Sel,150g de beurre doux,Sucre brun,Pépites de chocolat ",
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 13, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 14
            recipeIngredients = "Pâte d'épices,Poulet rôti découpé,Petits pois en boite,Vermicelles instantanées,Oignons coupés,Jus de citron vert,Aneth,Boeuf séché,Kimchi,Ciboule,Paprika,Epinards surgelés,Champignons en conserves,Protéines de soja texturées,Jus de citron,1 oeuf",
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 14, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 15
            recipeIngredients = "3 oeufs,Champignons frais,Persil déshydraté,Ail en semoule,Galette de blé,Concentré de tomates séchées,Huile,Olives noires",
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 15, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 16
            recipeIngredients = "1 boite de pommes de terres en conserves,Tomates séchées,Sel,Vinaigre balsamique,4 morceaux de Cabillaud,Marmelade,Purée d'ail,Aneth,Chapelure,Flocons de piment",
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 16, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            
            //recipe 17
            recipeIngredients = "2 têtes d'ail,3 oignons,Vinaigre balsamique,Sauce soja,Nuoc mam,Sucre roux en poudre,2 petits bocaux de pâte de piment",
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 17, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 18
            recipeIngredients = "4 tranches de jambon,1 petit reblochon,45 cl de lait entier,60 g de beurre,2 jaunes d'oeufs,450 g de coquillettes,40 g de farine,3 pincées de noix de muscade,Huile d'olive,Sel,Poivre du moulin",
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 18, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 19
            recipeIngredients = "16 tranches de pain de mie frais,100 g de crème fraîche,Muscade ou cumin en poudre,100 g de jambon blanc en tranche fine ou jambon de dinde,1 trait d’huile d’olive,200 g d’emmental râpé ou parmesan râpé ou gruyère râpé,1 œuf,100 g de beurre,1 botte de ciboulette,15 g de beurre",
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 19, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 20
            recipeIngredients = "4 oeufs,225 g de roquefort,40 cl de lait,115 g de farine,1 bouquet de ciboulette,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 20, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 21
            recipeIngredients = "1 oeuf,15 cl de lait écrémé,125 g de farine 15 cl d'eau gazeuse,Sel,1 tranche épaisse de jambon cuit fumé (150g),200 g de comté,20 cl de crème fraiche liquide,10 cl de lait,10 g de beurre,1.5 c.a.s de farine,Muscade,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 21, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 22
            recipeIngredients = "3 rouleaux de pâte à pizza,3 mozzarellas,200 g de tomates séchées,2 gousses d'ail,1 boite de tomates pelées,3 c.à.s d'huile d'olive,2 c.à.s d'origan,1 pincée de piment en poudre,Sel",
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 22, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 23
            recipeIngredients = "200 g de boulgour,2 blancs de poulet,3 tomates,2 oignons moyens,1 citron jaune,1 petit bouquet de menthe fraiche,1 petit bouquet de persil plat,2 c.à.s d'huile d'olive,Sel,Poivre du moulin.",
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 23, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 24
            recipeIngredients = "500 g de tagliatelles,150 g de lardons,1 jaune d'oeuf,200 g de crème fraiche épaisse,100 g de parmesan râpé,1 c.à.s d'huile,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 24, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 25
            recipeIngredients = "2 râbles de lapin,20 cl de vin blanc,5 c.à.s d'huile d'olive,2 feuilles de laurier,Sel,Poivre,1 salade (romaine),6 tomates cerises,1 c.à.s de jus de citron,50 g de copeaux de parmesan,100 g de petits croutons,1 c.à.s de vinaigre de vin",
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 25, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 26
            recipeIngredients = "500 g de riz,500g de calamars en rondelles,2 blancs de poulet,18 crevettes roses décortiquées,1 poivron rouge,2 oignons,2 gousses d'ail,8 cl d'huile d'olive,2 c.à.s de concentré de tomate,1 c.à.c de paprika,1 dose de safran en poudre,Persil plat,Sel",
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 26, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 27
            recipeIngredients = "500 g de viande de boeuf haché,500 g de courgettes,1 oignon,2 gousses d'ail,6 brins de thym,80 g de gruyère allégé râpé,2 c.à.s d'huile d'olive,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 27, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 28
            recipeIngredients = "6 feuilles de laitue,2 boites de thon entier au naturel de 140 g,6 tortillas souples de blé,3 c.à.s de mayonnaise allégée,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 28, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 29
            recipeIngredients = "800 g d'épaule de veau,4 aubergines,250 g de champignons de paris,2 gousses d'ail,1 bouquet de ciboule,50 g de beurre,1 c.à.s d'huile d'olive,1 c.à.s de concentré de tomate,20 cl de vin blanc sec,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 29, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 30
            recipeIngredients = "350 g d'allumettes de jambon,1 branche de romarin,20 g de beurre,300 g de riz,380 g de sauce-tomate en boîte,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 30, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 31
            recipeIngredients = "8 tranches de pain de mie,4 tranches de jambon blanc,4 oeufs,4 tranches de fromage type toastinette,50 g de beurre,2 c.à.s d'huile,Sel,Poivre blanc",
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 31, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))


            //recipe 32
            recipeIngredients = "1 chou-fleur,8 carottes,1 citron,6 petits oignons blancs,100 g de petits pois écossés,3 c.à.s de feuilles de coriandre hachées,1 boite de lait de coco,1 c.à.s d'huile d'olive,1 c.à.c de curcuma,1 c.à.c de gingembre en poudre,Sel,Poivre blanc",
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 32, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 33
            recipeIngredients = "200 g de riz grain long,150 g de petits pois (frais ou surgelés),2 oignons,1 poivron vert,1 poivron rouge,3 piments en bocal,1 c.à.s d'olives vertes,50 cl de bouillon de volaille,1 c.à.c de safran en poudre,3 c.à.s d'huile d'olive,Sel,Poivre",
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 33, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 34
            recipeIngredients = "500 g de filets de dorade,500 g d'oseille,Riz,6 champignons,500 g de chou-fleur surgelés,1 aubergine,1 poivron rouge,20 cl de crème fraiche semi-épaisse,10 cl de vin blanc,50 g de beurre,4 c.à.s d'huile d'olive,Sel,Poivre,Ail",
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 34, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 35
            recipeIngredients = "500 g de viande hachée surgelée,2 oignons,1 gousse d'ail,Huile d'olive,1 carotte,Sauce bolognaise toute prête,Sauce Béchamel,Pâtes lasagnes,Emmental râpé,Persil",
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 35, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 36
            recipeIngredients = "500 g de viande hachée surgelée,2 oignons,1 gousse d'ail,Huile d'olive,1 carotte,Sauce bolognaise toute prête,500 g de Spaghettis,Emmental râpé,Persil",
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))
            ingredientsListBox?.put(IngredientsList(recipeId = 36, ingredientsId = 1, ingredientsName = null, ingredientsReplacementId = null, quantity = 0.0, unit = null, recipeMirror = null))

            //recipe 37

            //recipe 38

            //recipe 39

            //recipe 40
        }

    }
}
