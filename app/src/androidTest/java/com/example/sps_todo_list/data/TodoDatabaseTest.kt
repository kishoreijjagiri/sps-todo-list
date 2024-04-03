package com.example.sps_todo_list.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sps_todo_list.data.dao.TodoDao
import com.example.sps_todo_list.data.entity.TodoEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class TodoDatabaseTest{

    private lateinit var db :TodoDatabase
    private lateinit var dao: TodoDao

    @Before
    fun setup(){
        val context =ApplicationProvider.getApplicationContext<android.content.Context>()
        db=Room.inMemoryDatabaseBuilder(context,TodoDatabase::class.java).build()
        dao=db.dao
    }

    @Test
    fun db_writesandReadTest(){
        val todoEntity = TodoEntity("Test")
        runBlocking {
            dao.insertTodo(todoEntity)
            val todolist=dao.getTodo()
            Truth.assertThat(todolist.contains(todoEntity)).isTrue()
        }

    }

    @After
    fun closeDb(){
        db.close()
    }

}