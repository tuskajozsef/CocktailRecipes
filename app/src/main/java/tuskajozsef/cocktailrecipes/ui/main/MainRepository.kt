package tuskajozsef.cocktailrecipes.ui.main

import tuskajozsef.cocktailrecipes.network.CocktailService
import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val cocktailService: CocktailService,
    private val cocktailDao: CocktailDao
)
