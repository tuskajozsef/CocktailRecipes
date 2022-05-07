package tuskajozsef.cocktailrecipes.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tuskajozsef.cocktailrecipes.model.CocktailResponse

interface CocktailService {
    @GET("api/json/v1/1/search.php")
    fun getCocktailDetails(@Query("s") cocktailName: String): Call<CocktailResponse>;

    @GET("api/json/v1/1/filter.php")
    fun getCocktailsByIngredient(@Query("i") ingredient: String): Call<CocktailResponse>;

    // used to create a list of cocktails, since the casual list is paid
    @GET("api/json/v1/1/random.php")
    fun getRandomCocktail(): Call<CocktailResponse>;

}