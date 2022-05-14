package tuskajozsef.cocktailrecipes.ui.main

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import tuskajozsef.cocktailrecipes.model.Cocktail
import tuskajozsef.cocktailrecipes.network.CocktailService
import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import javax.inject.Inject
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.flowOn

class MainRepository @Inject constructor(
    private val cocktailService: CocktailService,
    private val cocktailDao: CocktailDao
) {
    @WorkerThread
    fun getAllCocktails() = flow {
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
}
