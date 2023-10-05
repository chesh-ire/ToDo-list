package com.example.filetransfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button




import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())


        rvTodo.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        button2.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}