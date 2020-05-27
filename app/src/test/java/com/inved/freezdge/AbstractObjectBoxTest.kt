package com.inved.freezdge

import android.os.Build
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
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.File

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
abstract class AbstractObjectBoxTest {

    private val testDirectory = File("objectbox-example/test-db")
    private var store: BoxStore?=null
    var ingredientsBox: Box<Ingredients>?=null
    lateinit var ingredientsRepository: IngredientsRepository
    private var recipesBox: Box<Recipes>?=null
    lateinit var recipesRepository: RecipesRepository
    private var favouritesRecipesBox: Box<FavouritesRecipes>?=null
    lateinit var favouritesRecipesRepository: FavouritesRecipesRepository

    @Before
    fun setUp() {
        // delete database files before each test to start with a clean database
        BoxStore.deleteAllFiles(testDirectory)
        store = MyObjectBox.builder()
            // add directory flag to change where ObjectBox puts its database files
            .directory(testDirectory)
            // optional: add debug flags for more detailed ObjectBox log output
            .debugFlags(DebugFlags.LOG_QUERIES or DebugFlags.LOG_QUERY_PARAMETERS)
            .build()
        ingredientsBox= store?.boxFor(Ingredients::class.java)
        recipesBox=store?.boxFor(Recipes::class.java)
        favouritesRecipesBox=store?.boxFor(FavouritesRecipes::class.java)
        ingredientsRepository = IngredientsRepository(ingredientsBox)
        recipesRepository = RecipesRepository(recipesBox)
        favouritesRecipesRepository = FavouritesRecipesRepository(favouritesRecipesBox)
        ingredientsRepository.insertIngredients()
        recipesRepository.insertRecipesInDatabase()

    }

    @After
    fun tearDown() {
        if(store!=null){
            store?.boxFor(Ingredients::class.java)?.removeAll()
            store?.boxFor(FavouritesRecipes::class.java)?.removeAll()
            store?.boxFor(Recipes::class.java)?.removeAll()
            store?.close()
        }
        BoxStore.deleteAllFiles(testDirectory)
    }

}