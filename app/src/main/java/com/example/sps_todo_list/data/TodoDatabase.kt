package com.example.sps_todo_list.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sps_todo_list.data.dao.TodoDao
import com.example.sps_todo_list.data.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract val dao: TodoDao
}