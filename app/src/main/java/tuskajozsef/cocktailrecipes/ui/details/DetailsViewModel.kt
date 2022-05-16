package tuskajozsef.cocktailrecipes.ui.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import tuskajozsef.cocktailrecipes.model.Cocktail
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
   private val detailRepository: DetailsRepository
) : ViewModel() {

    fun cocktailDetails(name: String): Flow<Cocktail> = detailRepository.getCocktailDetails(name)
}