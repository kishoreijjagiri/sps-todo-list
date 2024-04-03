package com.example.sps_todo_list.utils

object TodoValidatore {

    fun validateTodo(todo:String):Boolean{
        if(todo.isEmpty())
        {
            return false
        }
        return  true
    }
}