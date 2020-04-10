package com.inved.freezdge.utils

import com.inved.freezdge.ingredientslist.database.Ingredients
import io.objectbox.Box

class AddIngredientsInDatabase(var ingredientsBox: Box<Ingredients>) {

    init {
        addIngredients()

    }

    private fun addIngredients() {

        val photoUrl =
            "https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/publications/food-beverage-nutrition/foodnavigator.com/news/market-trends/sugar-replaces-price-as-consumers-top-food-worry/8520146-2-eng-GB/Sugar-replaces-price-as-consumers-top-food-worry_wrbm_large.jpg"

        if (ingredientsBox.isEmpty) {
            ingredientsBox.put(
                Ingredients(
                    name = "Beurre",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blancs d'oeuf",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brie",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Camembert",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cheddar",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chèvre en buche",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chèvre frais",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème de soja",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème fraiche",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème liquide",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curé nantais",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Emmental",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Faisselle",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Feta",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage à raclette",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage à tartiner",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage blanc",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gouda",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gruyère",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait de soja",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Margarine",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mascarpone",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mimolette",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mozzarella",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oeufs",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oeufs de caille",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Parmesan",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Petits suisses",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pont l'Evêque",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ricotta",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Roquefort",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tofu",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de brebis",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de chèvre",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de soja",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt nature",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )


            ingredientsBox.put(
                Ingredients(
                    name = "Abricots",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Algue nori",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ananas",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Artichauts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Asperges blanches",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Asperges vertes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Aubergines",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Avocat",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Banane",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Banane plantain",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Basilic frais",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Betterave crue",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Betterave cuite",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blettes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brocolis",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Butternut",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carottes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Céléri branche",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Céléri rave",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cêpes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cerfeuil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cerises",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Champignons de Paris",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Châtaignes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou chinois",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou kale",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou rouge",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou vert",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou(x) romanesco",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou-fleur",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Choux de Bruxelles",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ciboulette",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Citron",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Citrouille",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Clémentine",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Coco de Paimpol",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Concombre",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Coriandre fraiche",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Courges",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Courgettes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Dattes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Echalotes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Endives",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epinards en branches",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epinards hachés",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epluchures de fruits",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epluchures de légumes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Estragon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fanes de légume",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fenouil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Feuilles de manioc",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Figues fraiches",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Figues séchées",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Flageolets",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fraises",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Framboises",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fruits de la passion",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots beurre",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots blancs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots rouges",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots verts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Herbes de Provence",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Herbes sèches",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Kiwi",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Laitue",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Légumes cuits",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lentilles",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lentilles corail",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mache",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mais",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mangue",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Melon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Menthe",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Navets",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nectarines",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noisettes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oignon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Orange",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Origan",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pamplemousse",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Panais",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Papaye",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pastèque",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Patate douce",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pêches",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Persil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Petits pois",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poireaux",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poires",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pois chiches",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poivrons",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pommes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pommes de terre",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Potiron",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pruneaux",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Prunes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Radis",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Radis noir",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raisin",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raisins secs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ratatouille",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Roquette",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Rutabaga",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Salade verte",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Salsifi",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates cerises",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates concassées",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomate grappes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates séchées",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Topinambours",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )



            ingredientsBox.put(
                Ingredients(
                    name = "4 épices",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Abricots secs",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Agar agar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ail en semoule",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes effilées",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes en poudre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Beurre de cacahuètes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bière",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Biscottes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Biscuits sucrés",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blé",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bonbons",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bouillon de boeuf",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bouillon de légumes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boulgour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brioche",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cacahuètes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Câpres",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carambar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chips",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat blanc",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat en poudre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat en tablette",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cidre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Compote",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Concentré de tomates",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Confiture",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cookies",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Corn flakes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cornichons",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Craquelins",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crêpes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Croissants",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crozets",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cumin",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curcuma",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curry",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Daim",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine d'épeautre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de blé noir",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de châtaigne",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de coco",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de lupin",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de pois chiche",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de riz",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Flocons d'avoine",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fruits secs",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de blé mexicaine",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de blé noir",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de riz",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Garam massala",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gari",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gingembre en poudre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gingembre frais",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de chia",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de fenouil",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de pavot",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de sarrasin",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de sésame",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de tournesol",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines germées",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Guacamole",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Harissa",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile d'olive",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile de noix",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile de sésame",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jus de fruits",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ketchup",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait de coco",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lasagnes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Laurier",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Levure",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lillet blanc",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lillet rosé",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Maizena",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mayonnaise",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Miel",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Miso",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Moutarde",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Muesli",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix de cajou",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix de coco en poudre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nouilles chinoises",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nouilles de riz",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nuoc mam",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Olives",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain au lait",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain de mie",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain épices",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte à pizza",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte à tartiner",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte brisée",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox.put(
                Ingredients(
                    name = "Pâte feuilletée",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâtes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pesto",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pignons de pin",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Piment en poudre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Piment d'espelette",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poivre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Polenta",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pop corn",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Proteines de soja",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Purée",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Quinoa",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ras el hanout",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raviolis",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Riz",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Riz rond",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce aigre douce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce barbecue",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce béarnaise",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce bolognaise",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce huitre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce soja",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce tomate",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sel",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Semoule",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Semoule de manioc",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sirop d'agave",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sirop d'érable",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Soupe",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Spéculoos",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre de coco",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre glace",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tabasco",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tahiné",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tempeh",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Thym",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vin blanc",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vin rosé",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre balsamique",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre de riz",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre xérès",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )



            ingredientsBox.put(
                Ingredients(
                    name = "Anchois",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Capitaine du Brésil",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crevette",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haddock",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Harengs fummés",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huîtres de Cancale",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Maquereaux",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Moules",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poisson filet",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poisson pané",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Restes de poisson cuit",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sardines",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saumon",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saumon fumé",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Surimi",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tarama",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Thon",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Truite fumée",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )


            ingredientsBox.put(
                Ingredients(
                    name = "Agneau",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bacon",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boeuf",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boudin blanc",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boudin noir",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carpaccio de boeuf",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chipolatas",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chorizo",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Confit de canard",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Côtes de porc",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Dinde (filet)",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Foie gras",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jambon blanc",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jambon cru",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "jambon de dinde",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jarret de porc",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lard",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lardons",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Magrets de canard",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Merguez",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâté",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet entier",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet (cuisse)",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet (filet)",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Rillettes",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saucisses de Strasbourg",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saucisson",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Steaks de soja",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Steaks hachés",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Viande cuite",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Viande hachée",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
        }
    }

}