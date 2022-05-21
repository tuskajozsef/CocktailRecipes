package tuskajozsef.cocktailrecipes.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import tuskajozsef.cocktailrecipes.R
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
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

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val viewModel: MainViewModel by viewModels()
    var cocktails: MutableList<Cocktail> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        firebaseAnalytics = Firebase.analytics

        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        val adapter = RecyclerViewAdapter(cocktails.toTypedArray());
        recyclerView.layoutManager = LinearLayoutManager(baseContext);
        recyclerView.adapter = adapter;

        viewModel.cocktailList(false)
            .onEach { list -> withContext(Dispatchers.Main){
                adapter.updateDataSet(list.toTypedArray())
            } }
            .launchIn(CoroutineScope(Dispatchers.IO))

        searchButton.setOnClickListener{
            //throw RuntimeException("Test Crash") // Force a crash

            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                param(FirebaseAnalytics.Param.ITEM_ID, "id")
                param(FirebaseAnalytics.Param.ITEM_NAME, "button click")
                param(FirebaseAnalytics.Param.CONTENT_TYPE, "button")
            }

            val ingredient = searchCocktailIngredient.text?.toString()

            if(ingredient != null)
                viewModel.cocktailsByIngredient(ingredient)
                    .onEach { list -> withContext(Dispatchers.Main){
                        adapter.updateDataSet(list.toTypedArray())
                    } }
                    .launchIn(CoroutineScope(Dispatchers.IO))
        }

        refreshButton.setOnClickListener{
            viewModel.cocktailList(true)
                .onEach { list -> withContext(Dispatchers.Main){
                    adapter.updateDataSet(list.toTypedArray())
                } }
                .launchIn(CoroutineScope(Dispatchers.IO))
        }
    }
}