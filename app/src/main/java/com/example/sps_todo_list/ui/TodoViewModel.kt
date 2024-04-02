package com.example.sps_todo_list.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sps_todo_list.data.entity.TodoEntity
import com.example.sps_todo_list.domain.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    fun saveTodo(todoEntity: TodoEntity) {
        viewModelScope.launch {
            repository.saveTodo(todoEntity)

            var list =repository.getAllTodos()

            Log.v("kishore",list.toString())
        }

    }
}