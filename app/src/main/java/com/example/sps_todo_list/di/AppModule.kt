package com.example.sps_todo_list.di

import android.app.Application
import androidx.room.Room
import com.example.sps_todo_list.data.TodoDatabase
import com.example.sps_todo_list.domain.TodoRepository
import com.example.sps_todo_list.domain.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDataBase(app: Application): TodoDatabase {
        return Room.databaseBuilder(app, TodoDatabase::class.java, "TODoDB").build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }
}