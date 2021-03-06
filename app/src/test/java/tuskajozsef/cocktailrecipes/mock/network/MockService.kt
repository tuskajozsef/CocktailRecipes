package tuskajozsef.cocktailrecipes.mock.network

import android.util.JsonReader
import com.skydoves.sandwich.ApiResponse
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import tuskajozsef.cocktailrecipes.model.Cocktail
import tuskajozsef.cocktailrecipes.model.CocktailResponse
import tuskajozsef.cocktailrecipes.network.CocktailService

class MockService : CocktailService {
    override suspend fun getCocktailDetails(cocktailName: String): ApiResponse<CocktailResponse> {
        return ApiResponse.of {
            Response.success(mockCocktailResponse)
        }
    }

    override suspend fun getCocktailsByIngredient(ingredient: String): ApiResponse<CocktailResponse> {
        return ApiResponse.of {
            Response.success(mockCocktailResponse)
        }
    }

    override suspend fun getRandomCocktail(): ApiResponse<CocktailResponse> {
        return ApiResponse.of {
            Response.success(mockCocktailResponse)
        }
    }

    private val mockCocktailResponse = CocktailResponse(
        drinks = arrayListOf(
            Cocktail(
                idDrink = "11690",
                strDrink = "Mai Tai",
                strDrinkAlternate = null,
                strTags = "IBA,ContemporaryClassic",
                strVideo = null,
                strCategory = "Ordinary Drink",
                strIBA = "Contemporary Classics",
                strAlcoholic = "Alcoholic",
                strGlass = "Collins glass",
                strInstructions = "Shake all ingredients with ice. Strain into glass. Garnish and serve with straw.",
                strInstructionsES = null,
                strInstructionsDE = "Alle Zutaten mit Eis schütteln. In ein Glas abseihen. Garnieren und mit Trinkhalm servieren.",
                strInstructionsFR = null,
                strInstructionsIT = "Shakerare tutti gli ingredienti con ghiaccio.Filtrare nel bicchiere. ",
                strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/twyrrp1439907470.jpg",
                strIngredient1 = "Light rum",
                strIngredient2 = "Orgeat syrup",
                strIngredient3 = "Triple sec",
                strIngredient4 = "Sweet and sour",
                strIngredient5 = "Cherry",
                strIngredient6 = null,
                strIngredient7 = null,
                strIngredient8 = null,
                strIngredient9 = null,
                strIngredient10 = null,
                strIngredient11 = null,
                strIngredient12 = null,
                strIngredient13 = null,
                strIngredient14 = null,
                strIngredient15 = null,
                strMeasure1 = "1 oz ",
                strMeasure2 = "1/2 oz ",
                strMeasure3 = "1/2 oz ",
                strMeasure4 = "1 1/2 oz ",
                strMeasure5 = "1 ",
                strMeasure6 = null,
                strMeasure7 = null,
                strMeasure8 = null,
                strMeasure9 = null,
                strMeasure10 = null,
                strMeasure11 = null,
                strMeasure12 = null,
                strMeasure13 = null,
                strMeasure14 = null,
                strMeasure15 = null,
                strImageSource = "https://commons.wikimedia.org/wiki/File:Mai_Tai_(16304400706).jpg",
                strImageAttribution = "Johnny Silvercloud https://www.flickr.com/people/116193477@N08",
                strCreativeCommonsConfirmed = "Yes",
                dateModified = "2015-08-18 15:17:50"
            )
        )
    )
}

