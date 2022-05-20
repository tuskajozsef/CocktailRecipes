package tuskajozsef.cocktailrecipes.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import tuskajozsef.cocktailrecipes.model.Cocktail
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var mainRepository: MainRepository
) : ViewModel() {

    fun cocktailList(reset: Boolean): Flow<MutableList<Cocktail>> = mainRepository.getAllCocktails(reset);
    fun cocktailsByIngredient(ingredient: String): Flow<List<Cocktail>> = mainRepository.getCocktailsByIngredient(ingredient)
}