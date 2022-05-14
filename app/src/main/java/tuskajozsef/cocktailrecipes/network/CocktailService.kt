package tuskajozsef.cocktailrecipes.network

import com.skydoves.sandwich.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tuskajozsef.cocktailrecipes.model.CocktailResponse

interface CocktailService {
    @GET("api/json/v1/1/search.php")
    suspend fun getCocktailDetails(@Query("s") cocktailName: String): ApiResponse<CocktailResponse>;

    @GET("api/json/v1/1/filter.php")
    suspend fun getCocktailsByIngredient(@Query("i") ingredient: String): ApiResponse<CocktailResponse>;

    // it is used to create a list of cocktails, since the casual list is paid
    @GET("api/json/v1/1/random.php")
    suspend fun getRandomCocktail(): ApiResponse<CocktailResponse>;

}