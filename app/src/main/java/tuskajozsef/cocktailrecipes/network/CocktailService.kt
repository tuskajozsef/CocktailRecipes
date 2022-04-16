package tuskajozsef.cocktailrecipes.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tuskajozsef.cocktailrecipes.model.Cocktail

interface CocktailService {
    @GET("api/json/v1/1/search.php")
    fun getCocktailDetails(@Query("s") cocktailName: String): Call<Cocktail>;

    @GET("api/json/v1/1/filter.php")
    fun getCocktailsByIngredient(@Query("i") ingredient: String): Call<List<Cocktail>>;
}