package tuskajozsef.cocktailrecipes

import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.junit.After
import org.junit.Before
import org.junit.Test
import tuskajozsef.cocktailrecipes.mock.network.MockService
import tuskajozsef.cocktailrecipes.mock.persistence.MockCocktailDao
import tuskajozsef.cocktailrecipes.mock.persistence.MockMainRepository
import tuskajozsef.cocktailrecipes.model.Cocktail

class Test {
    private lateinit var mockDao: MockCocktailDao
    private lateinit var mockService: MockService
    private lateinit var mockMainRepository: MockMainRepository

    @Before
    fun setup() {
        mockDao = MockCocktailDao()
        mockService = MockService()
        mockMainRepository = MockMainRepository(mockService, mockDao)
    }

    @After
    fun clearDatabase() {
        GlobalScope.launch {
            mockDao.deleteCocktails()
        }
    }

    @Test
    fun testEmptyDatabase() {
        var list = listOf<Cocktail>()
        GlobalScope.launch {
            list = mockDao.getAllCocktails()
        }
        assert(list.isEmpty())
    }

    @Test
    fun testGetCocktails() {
        mockMainRepository.getAllCocktails(false)
            .onEach { cocktails ->
                withContext(Dispatchers.Main) {
                    assert(cocktails.size == 10)
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    @Test
    fun testGetCocktailDetails() {
        GlobalScope.launch {
            mockService.getCocktailDetails("Mai Tai")
                .suspendOnSuccess {
                    withContext(Dispatchers.Main) {
                         assert(data.drinks.size == 1)
                        assert(data.drinks[0].strDrink == "Mai Tai")
                    }
                }
        }
    }

    @Test
    fun testCocktailDelete() {
        var list = mutableListOf<Cocktail>()

        GlobalScope.launch {
            mockMainRepository.getAllCocktails(false)
                .onEach { cocktails ->
                    withContext(Dispatchers.Main) {
                        assert(cocktails.size == 10)
                        list.addAll(cocktails)
                    }
                }

            mockDao.deleteCocktails()
            assert(list.size == 0)
        }
    }
}