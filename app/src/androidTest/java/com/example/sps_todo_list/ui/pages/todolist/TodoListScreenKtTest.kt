package com.example.sps_todo_list.ui.pages.todolist

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.sps_todo_list.ui.MainActivity
import com.example.sps_todo_list.ui.theme.SpstodolistTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TodoListScreenKtTest{

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testnotesAdded(){
        composeTestRule.onNodeWithContentDescription("Add").performClick()
        composeTestRule.onNodeWithText("Add TODO").assertExists()
        composeTestRule.onNodeWithTag("notes_tag").performTextInput("my first note")
        composeTestRule.onNodeWithText("my first note").assertExists()
    }

    @Test
    fun testnotestNotAdded(){
        composeTestRule.onNodeWithContentDescription("Add").performClick()
        composeTestRule.onNodeWithText("Add TODO").assertExists()
        composeTestRule.onNodeWithTag("notes_tag").performTextInput("my second note")
        composeTestRule.onNodeWithText("my first note").assertDoesNotExist()
    }

}