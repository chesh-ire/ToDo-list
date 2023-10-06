package com.example.filetransfer


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val etTodoTitle = findViewById<EditText>(R.id.rvTodo)
        val rvTodo = findViewById<RecyclerView>(R.id.rvTodo)

        //val rvTodo= findViewById<EditText>(R.id.rvTodo)

        rvTodo.adapter = todoAdapter
        //val rvTodoItems=findViewById<EditText>(R.id.rvTodo)
        rvTodo.layoutManager = LinearLayoutManager(this)

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