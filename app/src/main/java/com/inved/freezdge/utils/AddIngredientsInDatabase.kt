package com.inved.freezdge.utils

import com.inved.freezdge.ingredientslist.database.Ingredients
import io.objectbox.Box

class AddIngredientsInDatabase(private var ingredientsBox: Box<Ingredients>?) {

    init {
        addIngredients()

    }

    private fun addIngredients() {

        if (ingredientsBox?.isEmpty==true) {
            ingredientsBox?.put(
                Ingredients(
                    name = "Beurre",
                    nameEnglish = "Butter",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/butter-1449453_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Blancs d'oeuf",
                    nameEnglish = "Egg whites",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/blanc_oeufs.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Brie",
                    nameEnglish = "Brie cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/brie.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Camembert",
                    nameEnglish = "Camembert",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/camembert.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cheddar",
                    nameEnglish = "Cheddar cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cheddar-1398767_960_720.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chèvre en buche",
                    nameEnglish = "Goat cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chèvre_buche.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chèvre frais",
                    nameEnglish = "Fresh goat",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chèvre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Crème de soja",
                    nameEnglish = "Soya cream",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/crème_de_soja_autre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Crème fraiche",
                    nameEnglish = "Cream",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/crème_fraiche.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Crème liquide",
                    nameEnglish = "Cream",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/crème_liquide.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Curé nantais",
                    nameEnglish = "Cure cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/le-cure-nantais.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Emmental",
                    nameEnglish = "Emmental",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/emmental.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Faisselle",
                    nameEnglish = "Fiscella",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Faisselle.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Feta",
                    nameEnglish = "Feta cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/feta.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fromage à raclette",
                    nameEnglish = "Raclette cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/raclette.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fromage à tartiner",
                    nameEnglish = "Cheese spread",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/fromage-tartiner.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fromage blanc",
                    nameEnglish = "White cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Le-fromage-blanc.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Gouda",
                    nameEnglish = "Gouda",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Smoked-Gouda-Feat-500x500.png",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Gruyère",
                    nameEnglish = "Gruyère cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/gruyère.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lait",
                    nameEnglish = "Milk",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/milk-2474993_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lait de soja",
                    nameEnglish = "Soya milk",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lait_soja.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Margarine",
                    nameEnglish = "Margarine",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/margarine.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Mascarpone",
                    nameEnglish = "Mascarpone",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mascarpone.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Mimolette",
                    nameEnglish = "Mimolette",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mimoletteextravielle.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Mozzarella",
                    nameEnglish = "Mozzarella",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mozzarella.png",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Oeuf",
                    nameEnglish = "Egg",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/nest-1050964_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Oeuf de caille",
                    nameEnglish = "Quail egg",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/ouef de caille.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Parmesan",
                    nameEnglish = "Parmesan",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Parmesan-ou-gruyere-rape_exact240x240.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Petits suisses",
                    nameEnglish = "Little swiss",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Petits-suisses-glaces.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pont l'Evêque",
                    nameEnglish = "cheese",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/pont l'eveque fromage.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Ricotta",
                    nameEnglish = "Ricotta",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/ricotta-75.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Roquefort",
                    nameEnglish = "Roquefort",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Roquefort.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tofu",
                    nameEnglish = "Tofu",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tofusoyeux.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Yaourt de brebis",
                    nameEnglish = "Sheep yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/yaourt_brebis.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Yaourt de chèvre",
                    nameEnglish = "Goat yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/yahourt_chevre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Yaourt de soja",
                    nameEnglish = "Soy yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/yaourt_soja.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Yaourt nature",
                    nameEnglish = "Plain yoghurt",
                    typeIngredient = "Crèmerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/yaourt_nature.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )


            ingredientsBox?.put(
                Ingredients(
                    name = "Abricot",
                    nameEnglish = "Apricot",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/apricots-1522680_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Algue nori",
                    nameEnglish = "Nori seaweed",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/algue_nori.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Amandes",
                    nameEnglish = "Almond",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/amandes.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Ananas",
                    nameEnglish = "Pineapple",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/pineapple-636562_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Artichaut",
                    nameEnglish = "Artichoke",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/artichokes-3594246_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Asperges blanches",
                    nameEnglish = "White asparagus",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/asparagus-5038254_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Asperges vertes",
                    nameEnglish = "Green asparagus",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/asparagus-2178164_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Aubergine",
                    nameEnglish = "Eggplant",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/aubergine-89044_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Avocat",
                    nameEnglish = "Avocado",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/avocat.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Banane",
                    nameEnglish = "Banana",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/banana-2449019_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Banane plantain",
                    nameEnglish = "Plantain",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/banane_plantain.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Basilic",
                    nameEnglish = "Basil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/basilic.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Betterave",
                    nameEnglish = "Beet",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/betterave.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Blettes",
                    nameEnglish = "Swiss chard",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/blettes.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Brocoli",
                    nameEnglish = "Broccoli",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/broccoli-1238250_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Butternut",
                    nameEnglish = "Butternut",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/butternut-squash-109131_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Carotte",
                    nameEnglish = "Carrot",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/carrots-2387394_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Céléri branche",
                    nameEnglish = "Celery",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/celeri_branche.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Céléri rave",
                    nameEnglish = "Celery",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/celeri_rave.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cêpes",
                    nameEnglish = "Cep",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cep-4443920_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cerfeuil",
                    nameEnglish = "Chervil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cerfeuil.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cerises",
                    nameEnglish = "Cherry",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cherry-2554364_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Champignons",
                    nameEnglish = "Mushroom",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mushrooms-756406_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Châtaignes",
                    nameEnglish = "Chestnut",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chataignes.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chou chinois",
                    nameEnglish = "Chinese cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chou_chinois.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chou kale",
                    nameEnglish = "Kale",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chou_kale.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chou rouge",
                    nameEnglish = "Red cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chou_rouge.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chou vert",
                    nameEnglish = "Green cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chou_vert.png",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chou romanesco",
                    nameEnglish = "Romanesco cabbage",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chou_romanesco.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chou-fleur",
                    nameEnglish = "Cauliflower",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chou_fleur.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Choux de Bruxelles",
                    nameEnglish = "Brussels sprouts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/brussels-sprouts-22009_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Ciboulette",
                    nameEnglish = "Chives",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/ciboulette.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Citron",
                    nameEnglish = "Lemon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lemons-2039830_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Citrouille",
                    nameEnglish = "Pumpkin",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/citrouille.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Clémentine",
                    nameEnglish = "Clementine",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/clémentine.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Coco de Paimpol",
                    nameEnglish = "Coco beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/coco-de-Paimpol_flickr_4044122852_ea9f6d5fa3_b.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Concombre",
                    nameEnglish = "Cucumber",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cucumber-5089995_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Coriandre",
                    nameEnglish = "Coriander",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/coriandre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Courge",
                    nameEnglish = "Squash",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/courge.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Courgette",
                    nameEnglish = "Zucchini",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/courgette.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Datte",
                    nameEnglish = "Date",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/dates-1067265_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Echalote",
                    nameEnglish = "Shallot",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/echalotes.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Endive",
                    nameEnglish = "Endive",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/endives.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Epinards en branches",
                    nameEnglish = "Spinach",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/spinach-2216967_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Epinards hachés",
                    nameEnglish = "Spinach",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/epinars_hachés.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox?.put(
                Ingredients(
                    name = "Estragon",
                    nameEnglish = "Tarragon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tarragon-74234_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fanes de navet",
                    nameEnglish = "Turnip greens",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/fanes_navets.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fenouil",
                    nameEnglish = "Fennel",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/fennel-214680_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Feuilles de manioc",
                    nameEnglish = "Cassava leaves",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/saka_saka.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Figues fraiches",
                    nameEnglish = "Figs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/figues_fraiches.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Figues séchées",
                    nameEnglish = "Figs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/figue_sechees.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Flageolets",
                    nameEnglish = "Flageolet",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/flageolet1-1280x720.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fraises",
                    nameEnglish = "Strawberry",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/strawberry-5079237_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Framboises",
                    nameEnglish = "Raspberries",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/raspberries-2268901_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fruits de la passion",
                    nameEnglish = "Passion fruit",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/passion-fruit-3759351_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Haricots beurre",
                    nameEnglish = "Wax beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/haricots_beurre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Haricots blancs",
                    nameEnglish = "White beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/haricots_blancs.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Haricots rouges",
                    nameEnglish = "Kidney beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/haricots_rouges.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Haricots verts",
                    nameEnglish = "Green beans",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/haricots_vert.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Herbes de Provence",
                    nameEnglish = "Provencal herbs",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/herbes-provence1.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Kiwi",
                    nameEnglish = "Kiwi",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/kiwi.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Laitue",
                    nameEnglish = "Lettuce",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/laitue.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox?.put(
                Ingredients(
                    name = "Lentilles",
                    nameEnglish = "Lentil",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lentilles.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lentilles corail",
                    nameEnglish = "Coral lentils",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lentilles-corail.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Mache",
                    nameEnglish = "Lamb's lettuce",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mache.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Mais",
                    nameEnglish = "Corn",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/pop-corn-785074_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Mangue",
                    nameEnglish = "Mango",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mangue.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Melon",
                    nameEnglish = "Melon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/melon.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Menthe",
                    nameEnglish = "Mint",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/peppermint-2496361_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Navets",
                    nameEnglish = "Turnips",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/navet.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Nectarine",
                    nameEnglish = "Nectarine",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/nectarine.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Noisette",
                    nameEnglish = "Nuts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/noisette.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Noix",
                    nameEnglish = "Nuts",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/nuts-1213036_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Oignon",
                    nameEnglish = "Onion",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/onion-276590_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Orange",
                    nameEnglish = "Orange",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/orange-1995056_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Origan",
                    nameEnglish = "Oregano",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/oregano-2662890_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pamplemousse",
                    nameEnglish = "Grapefruit",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/pamplemousse.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Panais",
                    nameEnglish = "Parsnip",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/parsnip-20320_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Papaye",
                    nameEnglish = "Papaya",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/fruit-2123166_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pastèque",
                    nameEnglish = "Watermelon",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/watermelon-815072_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Patate douce",
                    nameEnglish = "Sweet potato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/sweetpotato-1975990_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pêche",
                    nameEnglish = "Peach",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/peach-2632182_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Persil",
                    nameEnglish = "Parsley",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/parsley-1665402_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Petits pois",
                    nameEnglish = "Green peas",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/petits_pois.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poireau",
                    nameEnglish = "Leeks",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/poireau.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poire",
                    nameEnglish = "Pear",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/poire.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pois chiches",
                    nameEnglish = "Chickpeas",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chickpea-316594_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poivron",
                    nameEnglish = "Peppers",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/poivron.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pomme",
                    nameEnglish = "Apple",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/apple.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pommes de terre",
                    nameEnglish = "potato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/potatoes-1585060_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Potiron",
                    nameEnglish = "Pumpkin",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/potiron.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pruneau",
                    nameEnglish = "Plums",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/pruneau.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Prune",
                    nameEnglish = "Plums",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/plums-1649602_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Radis",
                    nameEnglish = "Radish",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/radish-1537141_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Radis noir",
                    nameEnglish = "Black radish",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/radis_noir.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Raisin",
                    nameEnglish = "Grape",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/raisins.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Raisins secs",
                    nameEnglish = "Dried grapes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/raisins_secs.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Ratatouille",
                    nameEnglish = "Ratatouille",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/ratatouille.JPG",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Roquette",
                    nameEnglish = "Butter",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/roquette_670.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Rutabaga",
                    nameEnglish = "Rutabaga",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/rutabaga.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Salade",
                    nameEnglish = "Salad",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/salade.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Salsifi",
                    nameEnglish = "Salsify",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/salsifi.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tomate",
                    nameEnglish = "Tomato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tomatoes-320860_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tomates cerises",
                    nameEnglish = "Cherry tomato",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tomates_cerises.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tomates concassées",
                    nameEnglish = "Chopped tomatoes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tomates_concassees.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tomates séchées",
                    nameEnglish = "Dried tomatoes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tomates_sechees.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Topinambours",
                    nameEnglish = "Jerusalem artichokes",
                    typeIngredient = "Fruits & Légumes",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/jerusalem-artichoke-2192048_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )



            ingredientsBox?.put(
                Ingredients(
                    name = "4 épices",
                    nameEnglish = "Spices",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/4_epices.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Abricots secs",
                    nameEnglish = "Dried apricot",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/dried-apricots-3338362_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Agar agar",
                    nameEnglish = "Agar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/agar_agar.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Ail",
                    nameEnglish = "Garlic",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/garlic-1238337_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Amandes effilées",
                    nameEnglish = "Slivered almonds",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/amande-effilee.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Amandes en poudre",
                    nameEnglish = "Powdered almonds",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/amandes_poudre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Beurre de cacahuètes",
                    nameEnglish = "Peanut butter",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/beurre_cacahuète.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Bière",
                    nameEnglish = "Beer",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/beer-414914_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Biscottes",
                    nameEnglish = "Rusk",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Biscottes-facile-au-thermomix.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Biscuit",
                    nameEnglish = "Biscuit",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/biscuit.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Blé",
                    nameEnglish = "Wheat",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/blé.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Bonbons",
                    nameEnglish = "Candy",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/bonbons.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Bouillon de boeuf",
                    nameEnglish = "Beef broth",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/bouillon_boeuf.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Bouillon de légumes",
                    nameEnglish = "Vegetable broth",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/bouillon_legume.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Bouillon de volaille",
                    nameEnglish = "poultry broth",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/bouillon_volaille.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Boulgour",
                    nameEnglish = "Bulgur",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/boulgour.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Brioche",
                    nameEnglish = "Brioche",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/brioche.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cacahuètes",
                    nameEnglish = "Peanut",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cacahuetes.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Câpres",
                    nameEnglish = "Capers",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/capres.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Carambar",
                    nameEnglish = "Candy",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/carambar-caranougat.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chips",
                    nameEnglish = "Crisp",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chips.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chocolat blanc",
                    nameEnglish = "White chocolate",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chocolat_blanc.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chocolat en poudre",
                    nameEnglish = "Chocolate powder",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chocolat_poudre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chocolat en tablette",
                    nameEnglish = "Bar chocolate",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/chocolat_tablette.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cidre",
                    nameEnglish = "Cider",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cidre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Compote",
                    nameEnglish = "Compote",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/coco-de-Paimpol_flickr_4044122852_ea9f6d5fa3_b.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Concentré de tomates",
                    nameEnglish = "tomato",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/concentre-de-tomate.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Confiture",
                    nameEnglish = "Jam",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/confiture-de-fraises-thermomix-800x600.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cookies",
                    nameEnglish = "Cookies",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cookies.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Corn flakes",
                    nameEnglish = "Corn flakes",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/corn-flakes-sans-sucre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cornichons",
                    nameEnglish = "Gherkin",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cornichon.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Craquelins",
                    nameEnglish = "Crackers",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/craquelins.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Crêpes",
                    nameEnglish = "Pancakes",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/pancakes-4410605_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Croissant",
                    nameEnglish = "Croissant",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/croissant.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Crozet",
                    nameEnglish = "Crozets",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/crozets_macro_1.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cumin",
                    nameEnglish = "Cumin",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/cumin.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Curcuma",
                    nameEnglish = "Turmeric",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/curcuma.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Curry",
                    nameEnglish = "Curry",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/curry-13282_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Daim",
                    nameEnglish = "Daim",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/daim.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine",
                    nameEnglish = "Flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/flour-1581967_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine d'épeautre",
                    nameEnglish = "Spelt flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Farine-épeautre-1-1280x720.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine de blé noir",
                    nameEnglish = "Wheat flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/farine_ble_noir.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine de châtaigne",
                    nameEnglish = "Chestnut flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/farine_chataigne.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine de coco",
                    nameEnglish = "Coconut flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/farine-de-noix-de-coco-la-loge-beaute.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine de lupin",
                    nameEnglish = "Lupin flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/farine_lupin__012338000_0933_28012013.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine de pois chiche",
                    nameEnglish = "Chickpea flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/farines-pois-chiches.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Farine de riz",
                    nameEnglish = "Rice flour",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/farine_riz.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Flocons d'avoine",
                    nameEnglish = "Oat flakes",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/flocons_davoine.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Fruits secs",
                    nameEnglish = "Dry fruits",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/fruits secs.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Galettes de blé mexicaine",
                    nameEnglish = "Tortilla",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/galette_mexicaine.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Galettes de blé noir",
                    nameEnglish = "Buckwheat Crepe",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/galette_ble_noir.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Galettes de riz",
                    nameEnglish = "Rice cake",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Galette-de-riz-souffle.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Garam massala",
                    nameEnglish = "Garam massala",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/garam_massala_2.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Gari",
                    nameEnglish = "Gari",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Gari.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Gingembre en poudre",
                    nameEnglish = "ginger",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/gingembre en poudre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Gingembre frais",
                    nameEnglish = "ginger",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/ginger-5108742_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Graines de chia",
                    nameEnglish = "Chia seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/graine_chia.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Graines de fenouil",
                    nameEnglish = "Fennel seed",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/graines de fenouil.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Graines de pavot",
                    nameEnglish = "Poppy seed",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/graines_pavot.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Graines de sarrasin",
                    nameEnglish = "Buckwheat seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/graines_sarrasin.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Graines de sésame",
                    nameEnglish = "Sesame seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/graines_sesame.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Graines de tournesol",
                    nameEnglish = "Sunflower seeds",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/graines_tournesol.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Graines germées",
                    nameEnglish = "Germinated seed",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/graines_germées.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Guacamole",
                    nameEnglish = "Guacamole",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/guacamole-415358_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Harissa",
                    nameEnglish = "Harissa",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/harissa-4075853_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Huile d'olive",
                    nameEnglish = "Olive oil",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/olive_oil.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Huile de noix",
                    nameEnglish = "Nut oil",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/huile-de-noix-100-vierge.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Huile de sésame",
                    nameEnglish = "Sesame oil",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/huile-de-sesame.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Jus de fruits",
                    nameEnglish = "Fruit juice",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/jus_fruit.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Ketchup",
                    nameEnglish = "Ketchup",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/ketchup.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lait de coco",
                    nameEnglish = "Coconut milk",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lait_coco.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lasagnes",
                    nameEnglish = "Lasagne",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lasagnes.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Laurier",
                    nameEnglish = "Bay",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/laurier.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Levure",
                    nameEnglish = "Yeast",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/levure.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lillet blanc",
                    nameEnglish = "Lillet",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lillet_blanc.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lillet rosé",
                    nameEnglish = "Lillet",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lillet_rosé.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Maizena",
                    nameEnglish = "Corn",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Maizena.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Mayonnaise",
                    nameEnglish = "Mayonnaise",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mayonnaise.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Miel",
                    nameEnglish = "Honey",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/honey-1958464_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Miso",
                    nameEnglish = "Miso",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/miso.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Moutarde",
                    nameEnglish = "Mustard",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/mustard-415119_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Muesli",
                    nameEnglish = "Muesli",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/muesli-3154035_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Noix de cajou",
                    nameEnglish = "Cashew",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/noix_cajoux.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Noix de coco en poudre",
                    nameEnglish = "Powdered coconut",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/Poudre-de-noix-de-coco-©-Moving-Moment-shutterstock.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Nouilles chinoises",
                    nameEnglish = "Chinese noodles",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/nouilles_chinoises.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Nouilles de riz",
                    nameEnglish = "Rice noodles",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/nouilles_riz.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Nuoc mam",
                    nameEnglish = "Nuoc mam",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/nuoc-mam-psp-200ml.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Olive",
                    nameEnglish = "Olive",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/olive.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pain",
                    nameEnglish = "Bread",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pain.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pain au lait",
                    nameEnglish = "Milk bread",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pains-au-lait.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pain de mie",
                    nameEnglish = "Sandwich bread",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pain-de-mie.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pain épices",
                    nameEnglish = "Gingerbread",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pain-d'épices.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pâte à pizza",
                    nameEnglish = "Pizza dough",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pate à-pizza.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pâte à tartiner",
                    nameEnglish = "Spread",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/Pate-a-tartiner.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pâte brisée",
                    nameEnglish = "Short pastry",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pate brisée.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox?.put(
                Ingredients(
                    name = "Pâte feuilletée",
                    nameEnglish = "Pastry",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pate-feuilletee.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pâtes",
                    nameEnglish = "Pasta",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/pates.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pesto",
                    nameEnglish = "Pesto",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pesto.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pignons de pin",
                    nameEnglish = "Pine nuts",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pignons-de-pin.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Piment en poudre",
                    nameEnglish = "Chili powder",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/piment en poudre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Piment d'espelette",
                    nameEnglish = "Espelette",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/piment-d-espelette.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poivre",
                    nameEnglish = "Pepper",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/Poivre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Polenta",
                    nameEnglish = "Polenta",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/Polenta.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pop corn",
                    nameEnglish = "Popcorn",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/popcorn.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Proteines de soja",
                    nameEnglish = "Soy protein",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/proteine-de-soja.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Purée",
                    nameEnglish = "Mash",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/purée.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Quinoa",
                    nameEnglish = "Quinoa",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/quinoa.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Ras el hanout",
                    nameEnglish = "Ras-el-hanout",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/ras el hanout.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Raviolis",
                    nameEnglish = "Ravioli",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/raviolis.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Riz",
                    nameEnglish = "Rice",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/riz.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Riz rond",
                    nameEnglish = "Short grain rice",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/riz rond.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sauce aigre douce",
                    nameEnglish = "Sweet and sour sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sauce-aigre-douce.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sauce barbecue",
                    nameEnglish = "Barbecue sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sauce-barbecue.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sauce béarnaise",
                    nameEnglish = "Bearnaise sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sauce-bearnaise.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sauce bolognaise",
                    nameEnglish = "Bolognese sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sauce-bolognaise_ss.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sauce huitre",
                    nameEnglish = "Oyster sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sauce-huitre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sauce soja",
                    nameEnglish = "Soy sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sauce_soja.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sauce tomate",
                    nameEnglish = "Tomato sauce",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sauce_tomate.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sel",
                    nameEnglish = "Salt",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/salt-273105_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Semoule",
                    nameEnglish = "Semolina",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/SEMOULE.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Semoule de manioc",
                    nameEnglish = "Cassava semolina",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/semoule de manioc.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sirop d'agave",
                    nameEnglish = "Agave syrup",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sirop d'agave.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sirop d'érable",
                    nameEnglish = "Maple syrup",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sirop d'érable.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Soupe",
                    nameEnglish = "Soup",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/soupe.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Spéculoos",
                    nameEnglish = "Speculoos",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/spéculoos.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sucre",
                    nameEnglish = "Sugar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/sucre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sucre de coco",
                    nameEnglish = "Coconut sugar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/sucre-de-coco.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sucre glace",
                    nameEnglish = "Icing sugar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/sucre_glace.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tabasco",
                    nameEnglish = "Tabasco",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tabasco-1754420_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tempeh",
                    nameEnglish = "Tempeh",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/tempeh-4930032_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Thym",
                    nameEnglish = "Thyme",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/thym.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Vin blanc",
                    nameEnglish = "White wine",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/vin blanc.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Vin rosé",
                    nameEnglish = "Rose wine",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/vin-rose.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Vinaigre de cidre",
                    nameEnglish = "Vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/vinaigre de cidre.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Vinaigre balsamique",
                    nameEnglish = "Balsamic vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/vinaigre balsamique.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Vinaigre de riz",
                    nameEnglish = "Rice vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/vinaigre de riz.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Vinaigre xérès",
                    nameEnglish = "Sherry vinegar",
                    typeIngredient = "Epicerie",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/vinaigre de xeres.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )



            ingredientsBox?.put(
                Ingredients(
                    name = "Anchois",
                    nameEnglish = "Anchovy",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/anchois.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Bar",
                    nameEnglish = "bar",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/bar.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Capitaine",
                    nameEnglish = "Captain fish",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/capitaine.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Crevette",
                    nameEnglish = "Shrimp",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/crevettes.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Haddock",
                    nameEnglish = "Haddock",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/haddock.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Harengs fummés",
                    nameEnglish = "Smoked herring",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/harengs_fumés.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Huîtres de Cancale",
                    nameEnglish = "Cancale oysters",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/huitre_cancale.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Maquereaux",
                    nameEnglish = "Mackerel",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/maquereaux_flickr_3686169843_7fddc8b791_b.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Moules",
                    nameEnglish = "Moulds",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/moules.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poisson filet",
                    nameEnglish = "Fish fillet",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/filet_poisson.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poisson pané",
                    nameEnglish = "Breaded fish",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/poisson_pane.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poisson",
                    nameEnglish = "fish",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/poisson.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Sardines",
                    nameEnglish = "Sardines",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/sardines-1489626_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Saumon",
                    nameEnglish = "Salmon",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/salmon-1238248_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Saumon fumé",
                    nameEnglish = "Smoked salmon",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/smoked-salmon-71100_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Surimi",
                    nameEnglish = "Surimi",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/surimi.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Tarama",
                    nameEnglish = "Tamara",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/tarama.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Thon",
                    nameEnglish = "Tuna",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/thon.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Truite fumée",
                    nameEnglish = "Smoked trout",
                    typeIngredient = "Poisson",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/truite fumée.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )


            ingredientsBox?.put(
                Ingredients(
                    name = "Agneau",
                    nameEnglish = "Lamb",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lamb-cutlet-3276080_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Bacon",
                    nameEnglish = "Bacon",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/bacon-1323412_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Boeuf",
                    nameEnglish = "Beef",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/boeuf.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Boudin blanc",
                    nameEnglish = "White pudding",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/white-sausage-4733722_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Boudin noir",
                    nameEnglish = "Black pudding",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/boudin_noir.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Carpaccio de boeuf",
                    nameEnglish = "Carpaccio of beef",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/carpaccio-777848_640.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chipolatas",
                    nameEnglish = "Sausages",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/chipolatas.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Chorizo",
                    nameEnglish = "Chorizo",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/chorizo-salamanque.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Canard",
                    nameEnglish = "Duck",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/canard_cru.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Côtes de porc",
                    nameEnglish = "Pork ribs",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/cotes_de_porc.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Dinde",
                    nameEnglish = "Turkey",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/dinde.webp",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Foie gras",
                    nameEnglish = "Foie gras",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/foie_gras.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Jambon blanc",
                    nameEnglish = "Cooked ham",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/jambon_blanc.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Jambon cru",
                    nameEnglish = "Raw ham",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/jambon_cru.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "jambon de dinde",
                    nameEnglish = "Turkey ham",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/jambon_dinde.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Jarret de porc",
                    nameEnglish = "Knuckle of pork",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/jarret_porc.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lard",
                    nameEnglish = "Lard",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/lard.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Lardons",
                    nameEnglish = "Bacon",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/lardons.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Magret de canard",
                    nameEnglish = "Breast of duck",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/magret_canard.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Merguez",
                    nameEnglish = "Merguez",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/merguez.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Pâté",
                    nameEnglish = "Terrine",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/pâté.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Poulet entier",
                    nameEnglish = "Whole chicken",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/poulet_entier.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Cuisses de poulet",
                    nameEnglish = "Chicken thighs",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/cuisse-de-poulet.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Filet de poulet",
                    nameEnglish = "Chicken breast",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/filets-de-poulet-plein-air-sous-vide.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Rillettes",
                    nameEnglish = "Rillettes",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/rillettes.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Saucisses de Strasbourg",
                    nameEnglish = "Strasbourg sausages",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/saucisse-de-strasbourg.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Saucisson fumé",
                    nameEnglish = "Sausage",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/saucisson_fume.jpeg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox?.put(
                Ingredients(
                    name = "Saucisson sec",
                    nameEnglish = "Dry sausage",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/saucisson.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )

            ingredientsBox?.put(
                Ingredients(
                    name = "Steak de soja",
                    nameEnglish = "Steak of soya",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/steak_soja.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Steak haché",
                    nameEnglish = "Hamburger",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/steak-hache-viande-bovine.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Viande cuite",
                    nameEnglish = "Cooked meat",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingrédients2/Viande-cuite.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
            ingredientsBox?.put(
                Ingredients(
                    name = "Viande hachée",
                    nameEnglish = "Beef",
                    typeIngredient = "Viande",
                    photoUrl = "gs://freezdge.appspot.com/ingredients/viande_hachee.jpg",
                    selectedIngredient = false, grocerySelectedIngredient = false
                )
            )
        }
    }

}