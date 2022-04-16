package tuskajozsef.cocktailrecipes.ui.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tuskajozsef.cocktailrecipes.model.Cocktail
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {

    val cocktailDetails : Cocktail = TODO()
}