package com.example.sps_todo_list.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sps_todo_list.ui.pages.AddTodoScreen
import com.example.sps_todo_list.ui.pages.LoadTodoListScreen
import com.example.sps_todo_list.ui.theme.SpstodolistTheme
import com.example.sps_todo_list.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SpstodolistTheme {
                NavHost(navController = navController, startDestination = Routes.TODO_LIST){
                    composable(Routes.TODO_LIST){
                        LoadTodoListScreen(
                            navController
                        )
                    }
                    composable(Routes.ADD_TODO){
                        AddTodoScreen (
                            navController
                                )

                    }
                }

            }
        }
    }



}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpstodolistTheme {

        Scaffold(topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow),
                title = { Text(text = "kishore") })
        },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(Icons.Filled.Add, "")
                }
            },

            content = {
                paddingValues ->  Text(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), text = "ksdjcsdc")
                //loadTodoListScreen(viewmodel.list.collectAsStateWithLifecycle().value)
            }
        )

    }
}