package tuskajozsef.cocktailrecipes.ui.main.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tuskajozsef.cocktailrecipes.R
import tuskajozsef.cocktailrecipes.model.Cocktail
import tuskajozsef.cocktailrecipes.ui.details.Details

class RecyclerViewAdapter(private var dataSet: Array<Cocktail>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        var cocktail: Cocktail? = null

        init {
            textView = view.findViewById(R.id.cocktailName)
            imageView = view.findViewById(R.id.cocktailImage)

            view.setOnClickListener{
                val intent = Intent(view.context, Details::class.java)
                intent.putExtra("name", cocktail!!.strDrink)
                imageView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_cocktail, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.cocktail = dataSet[position];
        viewHolder.textView.text = dataSet[position].strDrink
        Picasso.get().load(dataSet[position].strDrinkThumb).into(viewHolder.imageView);
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(cocktails: Array<Cocktail>){
        dataSet = cocktails;
        this.notifyDataSetChanged();
    }

}
