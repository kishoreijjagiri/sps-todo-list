package com.example.sps_todo_list.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sps_todo_list.data.entity.TodoEntity
import com.example.sps_todo_list.ui.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodoScreen(
    onNavigate: NavHostController,
    viewModel: TodoViewModel = hiltViewModel()
) {

    val textState = remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize()) {

        TextField(
            value = textState.value,
            onValueChange = {
                // Update the state when the value changes
                textState.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Enter your Notes") },
            singleLine = true
        )

        Button(onClick = {
            viewModel.saveTodo(TodoEntity(textState.value.text))
            onNavigate.popBackStack()
        }
        ) {
            Text("Add TODO")
        }

    }

}