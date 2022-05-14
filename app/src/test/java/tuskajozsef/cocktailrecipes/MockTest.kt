package tuskajozsef.cocktailrecipes

import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import tuskajozsef.cocktailrecipes.model.Cocktail
import tuskajozsef.cocktailrecipes.network.CocktailService
import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import javax.inject.Inject

class MockTest {

    @Test
    fun mockDB() {
        val cocktailsDaoMock = mock(CocktailDao::class.java)
        `when`(cocktailsDaoMock.getAllCocktails()).thenReturn(listOf())

        assertEquals(cocktailsDaoMock!!.getAllCocktails(), emptyList<Cocktail>())
    }

    @Test
    fun mockNetwork() {
        val cocktailService = mock(CocktailService::class.java)
        val cocktail = cocktailService.getRandomCocktail()
    }
}