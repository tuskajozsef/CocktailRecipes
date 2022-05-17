package tuskajozsef.cocktailrecipes

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import tuskajozsef.cocktailrecipes.mock.network.MockService
import tuskajozsef.cocktailrecipes.mock.persistence.MockCocktailDao

class Test {
    private lateinit var mockDao: MockCocktailDao
    private lateinit var mockService: MockService

    @Before
    fun setup() {
        mockDao = MockCocktailDao()
        mockService = MockService()
    }

    @Test
    fun testCocktailAddMock() {
        GlobalScope.launch {
            val list = mockDao.getAllCocktails()
            assert(list.size == 1)
        }
    }
}