package tuskajozsef.cocktailrecipes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import tuskajozsef.cocktailrecipes.network.CocktailService
import tuskajozsef.cocktailrecipes.persistence.CocktailDao
import tuskajozsef.cocktailrecipes.ui.details.DetailRepository
import tuskajozsef.cocktailrecipes.ui.main.MainRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        cocktailService: CocktailService,
        cocktailDao: CocktailDao
    ): MainRepository {
        return MainRepository(cocktailService, cocktailDao)
    }

    @Provides
    @ViewModelScoped
    fun provideDetailsRepository(cocktailService: CocktailService): DetailRepository {
        return DetailRepository(cocktailService)
    }
}