package com.inved.freezdge

import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.repository.IngredientsRepository
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.repository.RecipesRepository
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.DebugFlags
import org.junit.After
import org.junit.Before
import java.io.File

abstract class AbstractObjectBoxTest {

    private val TEST_DIRECTORY = File("objectbox-example/test-db")
    private var store: BoxStore?=null
    lateinit var ingredientsBox: Box<Ingredients>
    lateinit var ingredientsRepository: IngredientsRepository
    lateinit var recipessBox: Box<Recipes>
    lateinit var recipesRepository: RecipesRepository
    lateinit var favouritesRecipesBox: Box<FavouritesRecipes>
    lateinit var favouritesRecipesRepository: FavouritesRecipesRepository

    @Before
    fun setUp() {
        // delete database files before each test to start with a clean database
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
        store = MyObjectBox.builder()
            // add directory flag to change where ObjectBox puts its database files
            .directory(TEST_DIRECTORY)
            // optional: add debug flags for more detailed ObjectBox log output
            .debugFlags(DebugFlags.LOG_QUERIES or DebugFlags.LOG_QUERY_PARAMETERS)
            .build()
        ingredientsBox= store!!.boxFor(Ingredients::class.java)
        recipessBox=store!!.boxFor(Recipes::class.java)
        favouritesRecipesBox=store!!.boxFor(FavouritesRecipes::class.java)
        ingredientsRepository = IngredientsRepository(ingredientsBox)
        recipesRepository = RecipesRepository(recipessBox)
        favouritesRecipesRepository = FavouritesRecipesRepository(favouritesRecipesBox)
        ingredientsRepository.insertIngredients()
        recipesRepository.insertRecipesInDatabase()

    }

    @After
    fun tearDown() {
        if(store!=null){
            store!!.boxFor(Ingredients::class.java).removeAll()
            store!!.boxFor(FavouritesRecipes::class.java).removeAll()
            store!!.boxFor(Recipes::class.java).removeAll()
            store!!.close()
        }
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
    }

}