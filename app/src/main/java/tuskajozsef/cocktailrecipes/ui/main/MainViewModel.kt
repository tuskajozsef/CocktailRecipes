package tuskajozsef.cocktailrecipes.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import tuskajozsef.cocktailrecipes.model.Cocktail
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    var cocktailList: MutableList<Cocktail> = ArrayList();

    fun onCreate() {
        mainRepository.getAllCocktails()
            .onEach { list -> cocktailList = list; Log.d("oneach", list.size.toString()) }
            .launchIn(CoroutineScope(Dispatchers.IO));
    }
}