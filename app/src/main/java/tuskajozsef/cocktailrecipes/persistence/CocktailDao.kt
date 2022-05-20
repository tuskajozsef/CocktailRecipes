package tuskajozsef.cocktailrecipes.persistence

import tuskajozsef.cocktailrecipes.model.Cocktail
import androidx.room.*;

@Dao
interface CocktailDao {
    @Query("SELECT * FROM cocktails")
    suspend fun getAllCocktails(): List<Cocktail>

    @Insert
    suspend fun insertCocktail(cocktail: Cocktail) : Long

    @Query("DELETE FROM cocktails")
    suspend fun deleteCocktails()

    @Update
    suspend fun updateCocktail(cocktail: Cocktail)
}