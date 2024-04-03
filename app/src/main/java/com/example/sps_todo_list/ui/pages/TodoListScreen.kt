package com.example.sps_todo_list.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sps_todo_list.ui.TodoViewModel
import com.example.sps_todo_list.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadTodoListScreen(
    onNavigate: NavHostController,
    viewModel: TodoViewModel = hiltViewModel()
) {

    //this calls when page load
    LaunchedEffect(Unit) {
        viewModel.getTodoList()
    }
    //list will update in initial load and search operation also
    val list = viewModel.list.collectAsState().value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNavigate.navigate(Routes.ADD_TODO)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        content = { paddingValues ->
                val textState = remember { mutableStateOf(TextFieldValue()) }
            Column {

                TextField(
                    value = viewModel.searchQuery.value,
                    onValueChange = viewModel::onSearch,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    label = { Text("Search your Notes") },
                    singleLine = true
                )


                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)) {
                    items(list.size) {
                        Text(text = list[it].notes,
                            Modifier
                                .fillMaxWidth()
                                .padding(5.dp))
                    }
                }
            }


        }

    )
}