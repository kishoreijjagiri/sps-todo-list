package com.example.sps_todo_list.ui.pages.todolist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sps_todo_list.ui.pages.TodoViewModel
import com.example.sps_todo_list.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadTodoListScreen(
    onNavigate: NavHostController,
    viewModel: TodoViewModel,
) {


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
            Column(Modifier.fillMaxSize()) {

                if (list.isNotEmpty() || viewModel.searchQuery.value.isNotEmpty()) {
                    TextField(
                        value = viewModel.searchQuery.value,
                        onValueChange = viewModel::onSearch,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        label = { Text("Search your Notes") },
                        singleLine = true
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues = paddingValues)
                            .padding(10.dp)
                    ) {
                        items(list.size) {
                            Text(
                                text = list[it].notes,
                                Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            )
                        }
                    }
                } else {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Press the + button to add a TODO item",
                            textAlign = TextAlign.Center
                        )
                    }

                }
                if (viewModel.openDialog.value) {
                    AlertDialog(
                        onDismissRequest = {
                            viewModel.openDialog.value = false
                        },
                        title = {
                            Text(text = "Error")
                        },
                        text = {
                            Text("you entered text as ERROR it will not save")
                        },
                        confirmButton = {
                            Button(

                                onClick = {
                                    viewModel.openDialog.value = false

                                }) {
                                Text("Confirm Button")
                            }
                        },
                    )
                }

            }


        }

    )
}