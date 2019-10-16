package com.testeapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testeapp.DetailActivity
import com.testeapp.MainActivity
import com.testeapp.R
import com.testeapp.models.Todo
import kotlinx.android.synthetic.main.list_todo_item.view.*




class TodoAdapter(private val todoList: MutableList<Todo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_todo_item, parent, false)
        val viewHolder = TodoViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.bindData(todo)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }


    fun add(todo: Todo) {
        this.todoList.add(todo)
        notifyDataSetChanged()
    }

    class TodoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(todo: Todo) {

            //detalhe da lista
            view.setOnClickListener({
                val intent = Intent(view.context, DetailActivity::class.java)

                intent.putExtra(DetailActivity.DETAIL_ORIGEM, todo)

                // detailActivity.startActivityForResult(Intent(), 123)
                view.context.startActivity(intent)

            })

            view.description.text = todo.description
            view.status.isChecked = todo.status
            view.status.setOnClickListener({
                todo.status = !it.status.isChecked
            })
        }
    }
}