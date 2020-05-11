package com.inved.freezdge

import com.inved.freezdge.utils.Domain
import org.junit.Assert.assertEquals
import org.junit.Test

class DomainTest {

    var domain = Domain()

    @Test
    fun uppercaseFistCharacter() {
        val myString = "alexandra"
        assertEquals("Alexandra", domain.uppercaseFirstCaracter(myString))
    }

    @Test
    fun randomStringLenght() {
        val myLenght = 20
        assertEquals(myLenght, domain.createRandomString().length)
    }

    @Test
    fun should_retrieveListFromString() {
        val stringGiven = "Alexandra,Bérenger,Rapha"
        val expectedList:List<String> = listOf("Alexandra", "Bérenger", "Rapha")
        assertEquals(expectedList, domain.retrieveListFromString(stringGiven))
    }

    @Test
    fun should_calculMatchingProportion_100() {
        val myIngredientsInFridge = 20.0
        val myIngredientsInRecipes = 20.0
        val expectedPourcent = 100
        assertEquals(expectedPourcent, domain.proportionCalcul(myIngredientsInFridge,myIngredientsInRecipes))
    }

    @Test
    fun should_calculMatchingProportion_evenOver100_100() {
        val myIngredientsInFridge = 25.0
        val myIngredientsInRecipes = 20.0
        val expectedPourcent = 100
        assertEquals(expectedPourcent, domain.proportionCalcul(myIngredientsInFridge,myIngredientsInRecipes))
    }

    @Test
    fun should_calculMatchingProportion_90() {
        val myIngredientsInFridge = 18.0
        val myIngredientsInRecipes = 20.0
        val expectedPourcent = 90
        assertEquals(expectedPourcent, domain.proportionCalcul(myIngredientsInFridge,myIngredientsInRecipes))
    }

}