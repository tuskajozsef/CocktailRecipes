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
                ingredient1.text = cocktail.strIngredient1 + ' ' + cocktail.strMeasure1
                ingredient2.text = cocktail.strIngredient2 + ' ' + cocktail.strMeasure2
                ingredient3.text = cocktail.strIngredient3 + ' ' + cocktail.strMeasure3
                ingredient4.text = cocktail.strIngredient4 + ' ' + cocktail.strMeasure4
                ingredient5.text = cocktail.strIngredient5 + ' ' + cocktail.strMeasure5
                ingredient6.text = cocktail.strIngredient6 + ' ' + cocktail.strMeasure6
                ingredient7.text = cocktail.strIngredient7 + ' ' + cocktail.strMeasure7
            } }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }
}