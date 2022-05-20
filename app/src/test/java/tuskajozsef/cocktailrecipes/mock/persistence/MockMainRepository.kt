package tuskajozsef.cocktailrecipes.mock.persistence

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tuskajozsef.cocktailrecipes.mock.network.MockService
import tuskajozsef.cocktailrecipes.model.Cocktail
import javax.inject.Inject

class MockMainRepository @Inject constructor(
    private val cocktailService: MockService,
    private val cocktailDao: MockCocktailDao
) {
    @WorkerThread
    fun getAllCocktails(reset: Boolean) = flow {
        if (reset) {
            cocktailDao.deleteCocktails()
        }

        val cocktails: MutableList<Cocktail> = cocktailDao.getAllCocktails().toMutableList()
        if (cocktails.isEmpty()) {
            //since a full list can only be requested by paid subscription, I request 10 random and put it in to a list
            for (i in 1..10) {
                cocktailService.getRandomCocktail().suspendOnSuccess {
                    cocktailDao.insertCocktail(data.drinks[0])
                    cocktails.add(data.drinks[0]);
                }
            }
            emit(cocktails)
        } else {
            emit(cocktails)
        }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun getCocktailsByIngredient(ingredient: String) = flow {
        cocktailService.getCocktailsByIngredient(ingredient).suspendOnSuccess {
            emit(data.drinks)
        }
    }.flowOn(Dispatchers.IO)
}