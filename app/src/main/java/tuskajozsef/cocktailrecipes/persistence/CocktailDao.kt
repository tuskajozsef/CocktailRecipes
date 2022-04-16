package tuskajozsef.cocktailrecipes.persistence

import tuskajozsef.cocktailrecipes.model.Cocktail
import androidx.room.*;

@Dao
interface CocktailDao {
    @Query("SELECT * FROM cocktails")
    fun getAllCities(): List<Cocktail>

    @Insert
    fun insertCity(cocktail: Cocktail) : Long

    @Delete
    fun deleteCity(cocktail: Cocktail)

    @Update
    fun updateCity(cocktail: Cocktail)
}