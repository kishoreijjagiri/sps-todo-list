package com.example.sps_todo_list.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
    val notes: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}