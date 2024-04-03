package com.example.sps_todo_list.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sps_todo_list.data.entity.TodoEntity
import com.example.sps_todo_list.domain.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    private val _list: MutableStateFlow<List<TodoEntity>> = MutableStateFlow(emptyList())
    val list = _list.asStateFlow()

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery
    private var searchJob: Job?=null

    fun saveTodo(todoEntity: TodoEntity) {
        viewModelScope.launch {
            repository.saveTodo(todoEntity)
        }
    }

    fun onSearch(word:String) {
        _searchQuery.value = word
        searchJob?.cancel()
        searchJob=viewModelScope.launch {
            delay(500)
            var temList = repository.getTodos(word).filter { s->s.notes.contains(word) }

            _list.value=temList
            Log.v("kishore",temList.toString())
        }
    }

    fun getTodoList() {
        viewModelScope.launch {
            _list.value = repository.getAllTodos()

        }

    }


}