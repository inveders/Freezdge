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
                    nameEnglish = "Butter",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blancs d'oeuf",
                    nameEnglish = "Egg whites",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brie",
                    nameEnglish = "Brie cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Camembert",
                    nameEnglish = "Camembert",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cheddar",
                    nameEnglish = "Cheddar cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chèvre en buche",
                    nameEnglish = "Goat cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chèvre frais",
                    nameEnglish = "Fresh goat",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème de soja",
                    nameEnglish = "Soya cream",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème fraiche",
                    nameEnglish = "Cream",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème liquide",
                    nameEnglish = "Cream",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curé nantais",
                    nameEnglish = "Cure cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Emmental",
                    nameEnglish = "Emmental",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Faisselle",
                    nameEnglish = "Fiscella",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Feta",
                    nameEnglish = "Feta cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage à raclette",
                    nameEnglish = "Raclette cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage à tartiner",
                    nameEnglish = "Cheese spread",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage blanc",
                    nameEnglish = "White cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gouda",
                    nameEnglish = "Gouda",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gruyère",
                    nameEnglish = "Gruyère cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait",
                    nameEnglish = "Milk",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait de soja",
                    nameEnglish = "Soya milk",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Margarine",
                    nameEnglish = "Margarine",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mascarpone",
                    nameEnglish = "Mascarpone",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mimolette",
                    nameEnglish = "Mimolette",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mozzarella",
                    nameEnglish = "Mozzarella",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oeufs",
                    nameEnglish = "Eggs",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oeufs de caille",
                    nameEnglish = "Quail eggs",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Parmesan",
                    nameEnglish = "Parmesan",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Petits suisses",
                    nameEnglish = "Little swiss",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pont l'Evêque",
                    nameEnglish = "cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ricotta",
                    nameEnglish = "Ricotta",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Roquefort",
                    nameEnglish = "Roquefort",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tofu",
                    nameEnglish = "Tofu",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de brebis",
                    nameEnglish = "Sheep yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de chèvre",
                    nameEnglish = "Goat yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de soja",
                    nameEnglish = "Soy yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt nature",
                    nameEnglish = "Plain yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )


            ingredientsBox.put(
                Ingredients(
                    name = "Abricots",
                    nameEnglish = "Aoricots",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Algue nori",
                    nameEnglish = "Nori seaweed",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes",
                    nameEnglish = "Almond",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ananas",
                    nameEnglish = "Pineapple",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Artichauts",
                    nameEnglish = "Artichoke",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Asperges blanches",
                    nameEnglish = "White asparagus",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Asperges vertes",
                    nameEnglish = "Green asparagus",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Aubergines",
                    nameEnglish = "Eggplant",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Avocat",
                    nameEnglish = "Avocado",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Banane",
                    nameEnglish = "Banana",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Banane plantain",
                    nameEnglish = "Plantain",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Basilic",
                    nameEnglish = "Basil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Betterave crue",
                    nameEnglish = "Raw beet",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Betterave cuite",
                    nameEnglish = "Cooked beets",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blettes",
                    nameEnglish = "Swiss chard",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brocolis",
                    nameEnglish = "Broccoli",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Butternut",
                    nameEnglish = "Butternut",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carottes",
                    nameEnglish = "Carrot",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Céléri branche",
                    nameEnglish = "Celery",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Céléri rave",
                    nameEnglish = "Celery",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cêpes",
                    nameEnglish = "Cep",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cerfeuil",
                    nameEnglish = "Chervil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cerises",
                    nameEnglish = "Cherry",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Champignons",
                    nameEnglish = "Mushroom",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Châtaignes",
                    nameEnglish = "Chestnut",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou chinois",
                    nameEnglish = "Chinese cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou kale",
                    nameEnglish = "Kale",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou rouge",
                    nameEnglish = "Red cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou vert",
                    nameEnglish = "Green cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou romanesco",
                    nameEnglish = "Romanesco cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou-fleur",
                    nameEnglish = "Cauliflower",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Choux de Bruxelles",
                    nameEnglish = "Brussels sprouts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ciboulette",
                    nameEnglish = "Chives",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Citron",
                    nameEnglish = "Lemon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Citrouille",
                    nameEnglish = "Pumpkin",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Clémentine",
                    nameEnglish = "Clementine",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Coco de Paimpol",
                    nameEnglish = "Coco beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Concombre",
                    nameEnglish = "Cucumber",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Coriandre",
                    nameEnglish = "Coriander",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Courges",
                    nameEnglish = "Squash",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Courgettes",
                    nameEnglish = "Zucchini",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Dattes",
                    nameEnglish = "Date",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Echalotes",
                    nameEnglish = "Shallot",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Endives",
                    nameEnglish = "Endive",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epinards en branches",
                    nameEnglish = "Spinach",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epinards hachés",
                    nameEnglish = "Spinach",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epluchures de fruits",
                    nameEnglish = "Fruits",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epluchures de légumes",
                    nameEnglish = "Vegetables",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Estragon",
                    nameEnglish = "Tarragon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fanes de navet",
                    nameEnglish = "Turnip greens",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fenouil",
                    nameEnglish = "Fennel",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Feuilles de manioc",
                    nameEnglish = "Cassava leaves",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Figues fraiches",
                    nameEnglish = "Figs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Figues séchées",
                    nameEnglish = "Figs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Flageolets",
                    nameEnglish = "Flageolet",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fraises",
                    nameEnglish = "Strawberry",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Framboises",
                    nameEnglish = "Raspberries",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fruits de la passion",
                    nameEnglish = "Passion fruit",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots beurre",
                    nameEnglish = "Wax beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots blancs",
                    nameEnglish = "White beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots rouges",
                    nameEnglish = "Kidney beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots verts",
                    nameEnglish = "Green beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Herbes de Provence",
                    nameEnglish = "Provencal herbs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Herbes sèches",
                    nameEnglish = "Dried herbs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Kiwi",
                    nameEnglish = "Kiwi",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Laitue",
                    nameEnglish = "Lettuce",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Légumes cuits",
                    nameEnglish = "Cooked vegetables",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lentilles",
                    nameEnglish = "Lentil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lentilles corail",
                    nameEnglish = "Coral lentils",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mache",
                    nameEnglish = "Lamb's lettuce",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mais",
                    nameEnglish = "Corn",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mangue",
                    nameEnglish = "Mango",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Melon",
                    nameEnglish = "Melon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Menthe",
                    nameEnglish = "Mint",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Navets",
                    nameEnglish = "Turnips",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nectarines",
                    nameEnglish = "Nectarine",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noisettes",
                    nameEnglish = "Nuts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix",
                    nameEnglish = "Nuts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oignon",
                    nameEnglish = "Onion",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Orange",
                    nameEnglish = "Orange",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Origan",
                    nameEnglish = "Oregano",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pamplemousse",
                    nameEnglish = "Grapefruit",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Panais",
                    nameEnglish = "Parsnip",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Papaye",
                    nameEnglish = "Papaya",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pastèque",
                    nameEnglish = "Watermelon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Patate douce",
                    nameEnglish = "Sweet potato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pêches",
                    nameEnglish = "Peach",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Persil",
                    nameEnglish = "Parsley",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Petits pois",
                    nameEnglish = "Green peas",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poireaux",
                    nameEnglish = "Leeks",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poires",
                    nameEnglish = "Pear",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pois chiches",
                    nameEnglish = "Chickpeas",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poivrons",
                    nameEnglish = "Peppers",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pommes",
                    nameEnglish = "Apple",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pommes de terre",
                    nameEnglish = "potato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Potiron",
                    nameEnglish = "Pumpkin",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pruneaux",
                    nameEnglish = "Plums",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Prunes",
                    nameEnglish = "Plums",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Radis",
                    nameEnglish = "Radish",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Radis noir",
                    nameEnglish = "Black radish",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raisin",
                    nameEnglish = "Grape",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raisins secs",
                    nameEnglish = "Dried grapes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ratatouille",
                    nameEnglish = "Ratatouille",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Roquette",
                    nameEnglish = "Butter",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Rutabaga",
                    nameEnglish = "Rutabaga",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Salade verte",
                    nameEnglish = "Green salad",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Salsifi",
                    nameEnglish = "Salsify",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates",
                    nameEnglish = "Tomato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates cerises",
                    nameEnglish = "Cherry tomato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates concassées",
                    nameEnglish = "Chopped tomatoes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates grappes",
                    nameEnglish = "trusses of tomatoes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates séchées",
                    nameEnglish = "Dried tomatoes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Topinambours",
                    nameEnglish = "Jerusalem artichokes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )



            ingredientsBox.put(
                Ingredients(
                    name = "4 épices",
                    nameEnglish = "Spices",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Abricots secs",
                    nameEnglish = "Dried apricot",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Agar agar",
                    nameEnglish = "Agar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ail en semoule",
                    nameEnglish = "Garlic",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes effilées",
                    nameEnglish = "Slivered almonds",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes en poudre",
                    nameEnglish = "Powdered almonds",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Beurre de cacahuètes",
                    nameEnglish = "Peanut butter",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bière",
                    nameEnglish = "Beer",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Biscottes",
                    nameEnglish = "Rusk",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Biscuits sucrés",
                    nameEnglish = "Biscuits",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blé",
                    nameEnglish = "Wheat",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bonbons",
                    nameEnglish = "Candy",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bouillon de boeuf",
                    nameEnglish = "Beef broth",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bouillon de légumes",
                    nameEnglish = "Vegetable broth",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boulgour",
                    nameEnglish = "Bulgur",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brioche",
                    nameEnglish = "Brioche",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cacahuètes",
                    nameEnglish = "Peanut",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Câpres",
                    nameEnglish = "Capers",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carambar",
                    nameEnglish = "Candy",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chips",
                    nameEnglish = "Chips",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat blanc",
                    nameEnglish = "White chocolate",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat en poudre",
                    nameEnglish = "Chocolate powder",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat en tablette",
                    nameEnglish = "Bar chocolate",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cidre",
                    nameEnglish = "Cider",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Compote",
                    nameEnglish = "Compote",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Concentré de tomates",
                    nameEnglish = "tomato",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Confiture",
                    nameEnglish = "Jam",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cookies",
                    nameEnglish = "Cookies",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Corn flakes",
                    nameEnglish = "Corn flakes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cornichons",
                    nameEnglish = "Gherkin",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Craquelins",
                    nameEnglish = "Crackers",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crêpes",
                    nameEnglish = "Pancakes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Croissants",
                    nameEnglish = "Croissants",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crozets",
                    nameEnglish = "Crozets",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cumin",
                    nameEnglish = "Cumin",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curcuma",
                    nameEnglish = "Turmeric",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curry",
                    nameEnglish = "Curry",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Daim",
                    nameEnglish = "Daim",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine",
                    nameEnglish = "Flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine d'épeautre",
                    nameEnglish = "Spelt flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de blé noir",
                    nameEnglish = "Wheat flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de châtaigne",
                    nameEnglish = "Chestnut flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de coco",
                    nameEnglish = "Coconut flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de lupin",
                    nameEnglish = "Lupin flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de pois chiche",
                    nameEnglish = "Chickpea flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de riz",
                    nameEnglish = "Rice flour",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Flocons d'avoine",
                    nameEnglish = "Oat flakes",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fruits secs",
                    nameEnglish = "Dry fruits",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de blé mexicaine",
                    nameEnglish = "Tortilla",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de blé noir",
                    nameEnglish = "Buckwheat Crepe",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de riz",
                    nameEnglish = "Rice cake",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Garam massala",
                    nameEnglish = "Garam massala",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gari",
                    nameEnglish = "Gari",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gingembre en poudre",
                    nameEnglish = "ginger",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gingembre frais",
                    nameEnglish = "ginger",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de chia",
                    nameEnglish = "Chia seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de fenouil",
                    nameEnglish = "Fennel seed",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de pavot",
                    nameEnglish = "Poppy seed",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de sarrasin",
                    nameEnglish = "Buckwheat seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de sésame",
                    nameEnglish = "Sesame seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de tournesol",
                    nameEnglish = "Sunflower seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines germées",
                    nameEnglish = "Germinated seed",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Guacamole",
                    nameEnglish = "Guacamole",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Harissa",
                    nameEnglish = "Harissa",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile",
                    nameEnglish = "Oil",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile d'olive",
                    nameEnglish = "Olive oil",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile de noix",
                    nameEnglish = "Nut oil",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile de sésame",
                    nameEnglish = "Sesame oil",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jus de fruits",
                    nameEnglish = "Fruit juice",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ketchup",
                    nameEnglish = "Ketchup",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait de coco",
                    nameEnglish = "Coconut milk",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lasagnes",
                    nameEnglish = "Lasagne",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Laurier",
                    nameEnglish = "Bay",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Levure",
                    nameEnglish = "Yeast",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lillet blanc",
                    nameEnglish = "Lillet",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lillet rosé",
                    nameEnglish = "Lillet",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Maizena",
                    nameEnglish = "Corn",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mayonnaise",
                    nameEnglish = "Mayonnaise",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Miel",
                    nameEnglish = "Honey",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Miso",
                    nameEnglish = "Miso",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Moutarde",
                    nameEnglish = "Mustard",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Muesli",
                    nameEnglish = "Muesli",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix de cajou",
                    nameEnglish = "Cashew",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix de coco en poudre",
                    nameEnglish = "Powdered coconut",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nouilles chinoises",
                    nameEnglish = "Chinese noodles",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nouilles de riz",
                    nameEnglish = "Rice noodles",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nuoc mam",
                    nameEnglish = "Nuoc mam",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Olives",
                    nameEnglish = "Olives",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain",
                    nameEnglish = "Bread",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain au lait",
                    nameEnglish = "Milk bread",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain de mie",
                    nameEnglish = "Sandwich bread",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain épices",
                    nameEnglish = "Gingerbread",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte à pizza",
                    nameEnglish = "Pizza dough",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte à tartiner",
                    nameEnglish = "Spread",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte brisée",
                    nameEnglish = "Short pastry",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox.put(
                Ingredients(
                    name = "Pâte feuilletée",
                    nameEnglish = "Pastry",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâtes",
                    nameEnglish = "Pasta",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pesto",
                    nameEnglish = "Pesto",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pignons de pin",
                    nameEnglish = "Pine nuts",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Piment en poudre",
                    nameEnglish = "Chili powder",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Piment d'espelette",
                    nameEnglish = "Espelette",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poivre",
                    nameEnglish = "Pepper",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Polenta",
                    nameEnglish = "Polenta",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pop corn",
                    nameEnglish = "Popcorn",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Proteines de soja",
                    nameEnglish = "Soy protein",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Purée",
                    nameEnglish = "Mash",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Quinoa",
                    nameEnglish = "Quinoa",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ras el hanout",
                    nameEnglish = "Ras-el-hanout",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raviolis",
                    nameEnglish = "Ravioli",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Riz",
                    nameEnglish = "Rice",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Riz rond",
                    nameEnglish = "Short grain rice",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce aigre douce",
                    nameEnglish = "Sweet and sour sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce barbecue",
                    nameEnglish = "Barbecue sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce béarnaise",
                    nameEnglish = "Bearnaise sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce bolognaise",
                    nameEnglish = "Bolognese sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce huitre",
                    nameEnglish = "Oyster sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce soja",
                    nameEnglish = "Soy sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce tomate",
                    nameEnglish = "Tomato sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sel",
                    nameEnglish = "Salt",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Semoule",
                    nameEnglish = "Semolina",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Semoule de manioc",
                    nameEnglish = "Cassava semolina",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sirop d'agave",
                    nameEnglish = "Agave syrup",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sirop d'érable",
                    nameEnglish = "Maple syrup",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Soupe",
                    nameEnglish = "Soup",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Spéculoos",
                    nameEnglish = "Speculoos",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre",
                    nameEnglish = "Sugar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre de coco",
                    nameEnglish = "Coconut sugar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre glace",
                    nameEnglish = "Icing sugar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tabasco",
                    nameEnglish = "Tabasco",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tahiné",
                    nameEnglish = "Tehena",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tempeh",
                    nameEnglish = "Tempeh",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Thym",
                    nameEnglish = "Thyme",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vin blanc",
                    nameEnglish = "White wine",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vin rosé",
                    nameEnglish = "Rose wine",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre",
                    nameEnglish = "Vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre balsamique",
                    nameEnglish = "Balsamic vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre de riz",
                    nameEnglish = "Rice vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre xérès",
                    nameEnglish = "Sherry vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )



            ingredientsBox.put(
                Ingredients(
                    name = "Anchois",
                    nameEnglish = "Anchovy",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Capitaine du Brésil",
                    nameEnglish = "Fish of brazil",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crevette",
                    nameEnglish = "Shrimp",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haddock",
                    nameEnglish = "Haddock",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Harengs fummés",
                    nameEnglish = "Smoked herring",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huîtres de Cancale",
                    nameEnglish = "Cancale oysters",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Maquereaux",
                    nameEnglish = "Mackerel",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Moules",
                    nameEnglish = "Moulds",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poisson filet",
                    nameEnglish = "Fish fillet",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poisson pané",
                    nameEnglish = "Breaded fish",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Restes de poisson cuit",
                    nameEnglish = "Cooked fish",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sardines",
                    nameEnglish = "Sardines",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saumon",
                    nameEnglish = "Salmon",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saumon fumé",
                    nameEnglish = "Smoked salmon",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Surimi",
                    nameEnglish = "Surimi",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tarama",
                    nameEnglish = "Tamara",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Thon",
                    nameEnglish = "Tuna",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Truite fumée",
                    nameEnglish = "Smoked trout",
                    typeIngredient = "Poisson",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )


            ingredientsBox.put(
                Ingredients(
                    name = "Agneau",
                    nameEnglish = "Lamb",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bacon",
                    nameEnglish = "Bacon",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boeuf",
                    nameEnglish = "Beef",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boudin blanc",
                    nameEnglish = "White pudding",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boudin noir",
                    nameEnglish = "Black pudding",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carpaccio de boeuf",
                    nameEnglish = "Carpaccio of beef",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chipolatas",
                    nameEnglish = "Sausages",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chorizo",
                    nameEnglish = "Chorizo",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Confit de canard",
                    nameEnglish = "Duck confit",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Côtes de porc",
                    nameEnglish = "Pork ribs",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Dinde (filet)",
                    nameEnglish = "Turkey filet",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Foie gras",
                    nameEnglish = "Foie gras",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jambon blanc",
                    nameEnglish = "Cooked ham",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jambon cru",
                    nameEnglish = "Raw ham",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "jambon de dinde",
                    nameEnglish = "Turkey ham",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jarret de porc",
                    nameEnglish = "Knuckle of pork",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lard",
                    nameEnglish = "Lard",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lardons",
                    nameEnglish = "Bacon",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Magrets de canard",
                    nameEnglish = "Breast of duck",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Merguez",
                    nameEnglish = "Merguez",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâté",
                    nameEnglish = "Terrine",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet entier",
                    nameEnglish = "Whole chicken",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet (cuisse)",
                    nameEnglish = "Chicken leg",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet (filet)",
                    nameEnglish = "Chicken breast",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Rillettes",
                    nameEnglish = "Rillettes",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saucisses de Strasbourg",
                    nameEnglish = "Strasbourg sausages",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saucisson",
                    nameEnglish = "Sausage",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox.put(
                Ingredients(
                    name = "Saucisson sec",
                    nameEnglish = "Dry sausage",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox.put(
                Ingredients(
                    name = "Steaks de soja",
                    nameEnglish = "Steaks of soya",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Steaks hachés",
                    nameEnglish = "Hamburger",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Viande cuite",
                    nameEnglish = "Cooked meat",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Viande hachée",
                    nameEnglish = "Beef",
                    typeIngredient = "Viande",
                    photoUrl = photoUrl,
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
        }
    }

}