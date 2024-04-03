package com.example.sps_todo_list.utils


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TodoValidatoreTest{

    @Test
    fun checkEmptystring(){
        val result =TodoValidatore.validateTodo("")
        assertThat(result).isFalse()
    }

    @Test
    fun checkValidString(){
        val result=TodoValidatore.validateTodo("kishore")
        assertThat(result).isTrue()
    }
}