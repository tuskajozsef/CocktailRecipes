package tuskajozsef.cocktailrecipes.ui.details

import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val cocktailDao: CocktailDao
) {}