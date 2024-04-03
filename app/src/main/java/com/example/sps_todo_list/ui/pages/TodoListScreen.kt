package com.example.sps_todo_list.ui.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sps_todo_list.ui.TodoViewModel
import com.example.sps_todo_list.utils.Routes
import com.example.sps_todo_list.utils.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadTodoListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TodoViewModel = hiltViewModel()
) {
    viewModel.getTodoList()
    val list = viewModel.list.collectAsStateWithLifecycle().value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNavigate(UiEvent.Navigate(Routes.ADD_TODO))
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        content = { paddingValues ->

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)) {
                items(list.size) {
                    Text(text = list.get(it).notes)
                }
            }

        }

    )
}