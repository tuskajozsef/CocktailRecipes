package tuskajozsef.cocktailrecipes.ui.details

import androidx.annotation.WorkerThread
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

class DetailRepository @Inject constructor(
    private val cocktailService: CocktailService
) {
    @WorkerThread
    fun getCocktailDetails() = flow {
        var cocktail: Cocktail? = null;
        cocktailService.getRandomCocktail().enqueue(object : Callback<CocktailResponse> {
            override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                print(t.message!!)
            }

            override fun onResponse(
                call: Call<CocktailResponse>,
                response: Response<CocktailResponse>
            ) {
                val cocktailsResponse = response.body()
                cocktail = cocktailsResponse!!.drinks[0];
            }
        })
        emit(cocktail)
    }.flowOn(Dispatchers.IO)
}