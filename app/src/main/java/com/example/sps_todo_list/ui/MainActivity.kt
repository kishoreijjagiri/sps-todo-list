package com.example.sps_todo_list.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sps_todo_list.ui.pages.addtodo.AddTodoScreen
import com.example.sps_todo_list.ui.pages.todolist.LoadTodoListScreen
import com.example.sps_todo_list.ui.pages.TodoViewModel
import com.example.sps_todo_list.ui.theme.SpstodolistTheme
import com.example.sps_todo_list.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            //shared viewmodel
            val viewModel: TodoViewModel = hiltViewModel()
            SpstodolistTheme {
                NavHost(navController = navController, startDestination = Routes.TODO_LIST){
                    composable(Routes.TODO_LIST){
                        LoadTodoListScreen(
                            navController,viewModel
                        )
                    }
                    composable(Routes.ADD_TODO){
                        AddTodoScreen (
                            navController,viewModel
                                )

                    }
                }

            }
        }
    }



}
