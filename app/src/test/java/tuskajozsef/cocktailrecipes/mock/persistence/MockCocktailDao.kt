package tuskajozsef.cocktailrecipes.mock.persistence

import tuskajozsef.cocktailrecipes.model.Cocktail
import tuskajozsef.cocktailrecipes.persistence.CocktailDao

class MockCocktailDao : CocktailDao {
    private val cocktails = mutableListOf<Cocktail>()

    override suspend fun getAllCocktails(): List<Cocktail> {
        return cocktails;
    }

    override suspend fun insertCocktail(cocktail: Cocktail): Long {
        val added = cocktails.add(cocktail);
        return if (added) 1 else 0
    }

    override suspend fun deleteCocktails() {
        cocktails.clear()
    }

    override suspend fun updateCocktail(cocktail: Cocktail) {
        val index = cocktails.indexOf(cocktail);
        cocktails[index] = cocktail
    }
}