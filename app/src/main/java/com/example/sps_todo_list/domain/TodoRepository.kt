package com.example.sps_todo_list.domain

import com.example.sps_todo_list.data.entity.TodoEntity

interface TodoRepository {
    suspend fun saveTodo(todo: TodoEntity)

    suspend fun getAllTodos():List<TodoEntity>

    suspend fun getTodos(word :String):List<TodoEntity>
}