package tuskajozsef.cocktailrecipes.mock.persistence

import dagger.Module
import dagger.Provides
import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import javax.inject.Singleton

@Module
class MockDbModule {

    @Provides
    @Singleton
    fun provideCocktailDao(): CocktailDao = MockCocktailDao()
}