package com.example.sps_todo_list.ui.pages.addtodo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sps_todo_list.data.entity.TodoEntity
import com.example.sps_todo_list.ui.pages.todolist.TodoViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodoScreen(
    onNavigate: NavHostController,
    viewModel: TodoViewModel ,
) {
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {

        TextField(
            value = viewModel.notes.value,
            onValueChange = {
                // Update the state when the value changes
                viewModel.notes.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Enter your Notes") },
            singleLine = true
        )

        Button(
            onClick = {
                if(viewModel.notes.value.equals("Error")){
                    viewModel.openDialog.value=true
                    onNavigate.popBackStack()
                }else{
                    viewModel.saveTodo(TodoEntity(viewModel.notes.value))
                    viewModel.loading.value = true
                    scope.launch {
                        delay(3000)
                        viewModel.loading.value = false
                        onNavigate.popBackStack()
                    }
                }

            }, modifier = Modifier.padding(16.dp)
        ) {
            Text("Add TODO")
        }
        if (viewModel.loading.value) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }

        }


    }

}