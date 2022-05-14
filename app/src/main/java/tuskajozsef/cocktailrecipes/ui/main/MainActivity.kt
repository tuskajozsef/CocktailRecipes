package tuskajozsef.cocktailrecipes.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import tuskajozsef.cocktailrecipes.R
import androidx.activity.viewModels
import tuskajozsef.cocktailrecipes.model.Cocktail


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    internal val viewModel: MainViewModel by viewModels()
    val cocktails: MutableList<Cocktail> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        Log.d("FASZ", viewModel.cocktailList.size.toString())
        setContentView(R.layout.activity_main)

    }
}