package tuskajozsef.cocktailrecipes.ui.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import tuskajozsef.cocktailrecipes.R

@AndroidEntryPoint
class Details : ComponentActivity() {
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val name = intent.extras!!.get("name").toString()
        viewModel.cocktailDetails(name)
            .onEach { cocktail -> withContext(Dispatchers.Main){
                Picasso.get().load(cocktail.strDrinkThumb).into(cocktailImage);
                cocktailName.text = cocktail.strDrink;
                ingredient1.text = getIngredientText(cocktail.strMeasure1, cocktail.strIngredient1)
                ingredient2.text = getIngredientText(cocktail.strMeasure2, cocktail.strIngredient2)
                ingredient3.text = getIngredientText(cocktail.strMeasure3, cocktail.strIngredient3)
                ingredient4.text = getIngredientText(cocktail.strMeasure4, cocktail.strIngredient4)
                ingredient5.text = getIngredientText(cocktail.strMeasure5, cocktail.strIngredient5)
                ingredient6.text = getIngredientText(cocktail.strMeasure6, cocktail.strIngredient6)
                ingredient7.text = getIngredientText(cocktail.strMeasure7, cocktail.strIngredient7)
            } }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    private fun getIngredientText(measure: String?, ingredient: String?): String{
        return if(measure == null){
            "";
        } else{
            "$measure $ingredient"
        }

    }
}