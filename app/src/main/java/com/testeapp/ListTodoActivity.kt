package com.testeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.testeapp.adapter.TodoAdapter
import com.testeapp.models.Todo
import kotlinx.android.synthetic.main.activity_list_todo.*

class ListTodoActivity : AppCompatActivity() {

    val INDENTTIFY_REQUEST = 2132

    val todoAdapter = TodoAdapter(mutableListOf<Todo>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_todo)


        val viewManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(this, viewManager.getOrientation())


        todo_list.layoutManager = viewManager
        todo_list.addItemDecoration(divider)

        todo_list.adapter = todoAdapter


        new_tarefa.setOnClickListener({
            val intent = Intent(applicationContext, FormTarefa::class.java)
            startActivityForResult(intent, INDENTTIFY_REQUEST)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == INDENTTIFY_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.let {
                val description = it.getStringExtra("todo")
                val todo = Todo(null, description, false)
                todoAdapter.add(todo)
            }

        }
    }
}
