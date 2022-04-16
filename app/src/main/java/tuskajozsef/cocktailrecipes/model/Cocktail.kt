package tuskajozsef.cocktailrecipes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class Cocktail(
    @PrimaryKey(autoGenerate = true) var Id : Long?,
    var name: String,
    var image: String)

