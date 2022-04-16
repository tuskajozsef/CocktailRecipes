package tuskajozsef.cocktailrecipes.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tuskajozsef.cocktailrecipes.model.Cocktail
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
) : ViewModel() {

    val cocktailList: List<Cocktail> = TODO()
}