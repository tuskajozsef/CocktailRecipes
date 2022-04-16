package tuskajozsef.cocktailrecipes.persistence

import tuskajozsef.cocktailrecipes.model.Cocktail
import androidx.room.*;

@Dao
interface CocktailDao {
    @Query("SELECT * FROM cocktails")
    fun getAllCocktails(): List<Cocktail>

    @Insert
    fun insertCocktail(cocktail: Cocktail) : Long

    @Delete
    fun deleteCocktail(cocktail: Cocktail)

    @Update
    fun updateCocktail(cocktail: Cocktail)
}