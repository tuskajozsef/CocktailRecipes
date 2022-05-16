package tuskajozsef.cocktailrecipes.ui.details

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tuskajozsef.cocktailrecipes.model.Cocktail
import tuskajozsef.cocktailrecipes.model.CocktailResponse
import tuskajozsef.cocktailrecipes.network.CocktailService
import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val cocktailService: CocktailService
) {
    @WorkerThread
    fun getCocktailDetails(name: String) = flow {
        cocktailService.getCocktailDetails(name).suspendOnSuccess {
            emit(data.drinks[0])
        }
    }.flowOn(Dispatchers.IO)
}