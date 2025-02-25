package com.example.r_android_template.di

import android.content.Context
import com.example.r_android_template.data.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRepository(
        @ApplicationContext context: Context
    ) : Repository = Repository(context)
}