package tuskajozsef.cocktailrecipes.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import tuskajozsef.cocktailrecipes.R
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import tuskajozsef.cocktailrecipes.model.Cocktail
import tuskajozsef.cocktailrecipes.ui.main.adapter.RecyclerViewAdapter

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    var cocktails: MutableList<Cocktail> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        val adapter = RecyclerViewAdapter(cocktails.toTypedArray());
        recyclerView.layoutManager = LinearLayoutManager(baseContext);
        recyclerView.adapter = adapter;

        viewModel.cocktailList
            .onEach { list -> withContext(Dispatchers.Main){
                adapter.updateDataSet(list.toTypedArray())
            } }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }
}