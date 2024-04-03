package com.example.sps_todo_list.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sps_todo_list.data.entity.TodoEntity
import com.example.sps_todo_list.domain.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    private val _list: MutableStateFlow<List<TodoEntity>> = MutableStateFlow(emptyList())
    val list = _list.asStateFlow()

    fun saveTodo(todoEntity: TodoEntity) {
        viewModelScope.launch {
            repository.saveTodo(todoEntity)
        }

    }

    fun getTodoList() {
        viewModelScope.launch {
            _list.value = repository.getAllTodos()

        }

    }

    fun naviagation() {

    }
}