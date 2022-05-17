package tuskajozsef.cocktailrecipes.mock.network

import dagger.Module
import dagger.Provides
import tuskajozsef.cocktailrecipes.network.CocktailService
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideMockService(): CocktailService = MockService()
}