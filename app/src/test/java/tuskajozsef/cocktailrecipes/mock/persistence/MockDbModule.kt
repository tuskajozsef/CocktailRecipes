package tuskajozsef.cocktailrecipes.mock.persistence

import dagger.Module
import dagger.Provides
import dagger.hilt.android.scopes.ViewModelScoped
import tuskajozsef.cocktailrecipes.mock.network.MockService
import tuskajozsef.cocktailrecipes.network.CocktailService
import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import tuskajozsef.cocktailrecipes.ui.main.MainRepository
import javax.inject.Singleton

@Module
class MockDbModule {

    @Provides
    @Singleton
    fun provideCocktailDao(): CocktailDao = MockCocktailDao()
}