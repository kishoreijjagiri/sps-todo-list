package com.example.sps_todo_list.domain

import com.example.sps_todo_list.data.dao.TodoDao
import com.example.sps_todo_list.data.entity.TodoEntity
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(var todoDao: TodoDao) : TodoRepository {
    override suspend fun saveTodo(todo: TodoEntity) {
        todoDao.insertTodo(todo)
    }

    override suspend fun getAllTodos(): List<TodoEntity> {
        return todoDao.getTodo()
    }

    override suspend fun getTodos(word: String): List<TodoEntity> {
        return todoDao.getTodos(word)
    }

}