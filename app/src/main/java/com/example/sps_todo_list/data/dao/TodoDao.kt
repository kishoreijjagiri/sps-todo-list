package com.example.sps_todo_list.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.sps_todo_list.data.entity.TodoEntity

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

}