package com.inved.freezdge.utils

import com.inved.freezdge.database.Ingredients
import io.objectbox.Box

class AddIngredientsInDatabase(var ingredientsBox:Box<Ingredients>) {

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
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blancs d'oeuf",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brie",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Camembert",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cheddar",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chèvre en buche",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chèvre frais",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème de soja",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème fraiche",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crème liquide",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curé nantais",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Emmental",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Faisselle",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Feta",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage à raclette",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage à tartiner",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fromage blanc",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gouda",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gruyère",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait de soja",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Margarine",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mascarpone",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mimolette",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mozzarella",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oeufs",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oeufs de caille",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Parmesan",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Petits suisses",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pont l'Evêque",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ricotta",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Roquefort",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tofu",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de brebis",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de chèvre",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt de soja",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Yaourt nature",
                    type = "Crèmerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )


            ingredientsBox.put(
                Ingredients(
                    name = "Abricots",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Algue nori",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ananas",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Artichauts",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Asperges blanches",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Asperges vertes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Aubergines",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Avocat",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Banane",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Banane plantain",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Basilic frais",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Betterave crue",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Betterave cuite",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blettes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brocolis",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Butternut",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carottes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Céléri branche",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Céléri rave",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cêpes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cerfeuil",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cerises",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Champignons de Paris",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Châtaignes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou chinois",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou kale",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou rouge",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou vert",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou(x) romanesco",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chou-fleur",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Choux de Bruxelles",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ciboulette",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Citron",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Citrouille",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Clémentine",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Coco de Paimpol",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Concombre",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Coriandre fraiche",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Courges",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Courgettes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Dattes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Echalotes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Endives",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epinards en branches",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epinards hachés",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epluchures de fruits",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Epluchures de légumes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Estragon",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fanes de légume",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fenouil",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Feuilles de manioc",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Figues fraiches",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Figues séchées",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Flageolets",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fraises",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Framboises",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fruits de la passion",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots beurre",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots blancs",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots rouges",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haricots verts",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Herbes de Provence",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Herbes sèches",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Kiwi",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Laitue",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Légumes cuits",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lentilles",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lentilles corail",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mache",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mais",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mangue",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Melon",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Menthe",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Navets",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nectarines",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noisettes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Oignon",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Orange",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Origan",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pamplemousse",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Panais",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Papaye",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pastèque",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Patate douce",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pêches",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Persil",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Petits pois",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poireaux",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poires",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pois chiches",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poivrons",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pommes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pommes de terre",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Potiron",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pruneaux",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Prunes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Radis",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Radis noir",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raisin",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raisins secs",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ratatouille",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Roquette",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Rutabaga",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Salade verte",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Salsifi",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates cerises",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates concassées",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomate grappes",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tomates séchées",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Topinambours",
                    type = "Fruits & Légumes",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )



            ingredientsBox.put(
                Ingredients(
                    name = "4 épices",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Abricots secs",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Agar agar",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ail en semoule",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes effilées",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Amandes en poudre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Beurre de cacahuètes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bière",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Biscottes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Biscuits sucrés",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Blé",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bonbons",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bouillon de boeuf",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bouillon de légumes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boulgour",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Brioche",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cacahuètes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Câpres",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carambar",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chips",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat blanc",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat en poudre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chocolat en tablette",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cidre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Compote",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Concentré de tomates",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Confiture",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cookies",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Corn flakes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cornichons",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Craquelins",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crêpes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Croissants",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crozets",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Cumin",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curcuma",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Curry",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Daim",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine d'épeautre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de blé noir",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de châtaigne",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de coco",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de lupin",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de pois chiche",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Farine de riz",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Flocons d'avoine",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Fruits secs",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de blé mexicaine",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de blé noir",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Galettes de riz",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Garam massala",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gari",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gingembre en poudre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Gingembre frais",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de chia",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de fenouil",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de pavot",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de sarrasin",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de sésame",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines de tournesol",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Graines germées",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Guacamole",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Harissa",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile d'olive",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile de noix",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huile de sésame",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jus de fruits",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ketchup",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lait de coco",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lasagnes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Laurier",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Levure",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lillet blanc",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lillet rosé",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Maizena",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Mayonnaise",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Miel",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Miso",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Moutarde",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Muesli",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix de cajou",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Noix de coco en poudre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nouilles chinoises",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nouilles de riz",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Nuoc mam",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Olives",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain au lait",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain de mie",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pain épices",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte à pizza",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte à tartiner",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâte brisée",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )

            ingredientsBox.put(
                Ingredients(
                    name = "Pâte feuilletée",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâtes",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pesto",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pignons de pin",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Piment en poudre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Piment d'espelette",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poivre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Polenta",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pop corn",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Proteines de soja",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Purée",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Quinoa",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Ras el hanout",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Raviolis",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Riz",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Riz rond",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce aigre douce",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce barbecue",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce béarnaise",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce bolognaise",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce huitre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce soja",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sauce tomate",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sel",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Semoule",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Semoule de manioc",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sirop d'agave",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sirop d'érable",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Soupe",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Spéculoos",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre de coco",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sucre glace",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tabasco",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tahiné",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tempeh",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Thym",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vin blanc",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vin rosé",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre balsamique",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre de riz",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Vinaigre xérès",
                    type = "Epicerie",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )



            ingredientsBox.put(
                Ingredients(
                    name = "Anchois",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Capitaine du Brésil",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Crevette",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Haddock",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Harengs fummés",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Huîtres de Cancale",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Maquereaux",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Moules",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poisson filet",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poisson pané",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Restes de poisson cuit",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Sardines",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saumon",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saumon fumé",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Surimi",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Tarama",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Thon",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Truite fumée",
                    type = "Poisson",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )


            ingredientsBox.put(
                Ingredients(
                    name = "Agneau",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Bacon",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boeuf",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boudin blanc",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Boudin noir",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Carpaccio de boeuf",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chipolatas",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Chorizo",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Confit de canard",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Côtes de porc",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Dinde (filet)",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Foie gras",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jambon blanc",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jambon cru",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "jambon de dinde",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Jarret de porc",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lard",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Lardons",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Magrets de canard",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Merguez",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Pâté",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet entier",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet (cuisse)",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Poulet (filet)",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Rillettes",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saucisses de Strasbourg",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Saucisson",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Steaks de soja",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Steaks hachés",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Viande cuite",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
            ingredientsBox.put(
                Ingredients(
                    name = "Viande hachée",
                    type = "Viande",
                    photoUrl = photoUrl,
                    isSelected = false
                )
            )
        }
    }

}