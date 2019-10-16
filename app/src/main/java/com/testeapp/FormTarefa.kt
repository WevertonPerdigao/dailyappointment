package com.testeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.testeapp.adapter.TodoAdapter
import com.testeapp.models.Todo
import kotlinx.android.synthetic.main.activity_form_tarefa.*

class FormTarefa : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_tarefa)

        save.setOnClickListener({
            val description = task_description.text.toString()

            val intent=Intent()

            intent.putExtra("todo",description)

            setResult(Activity.RESULT_OK,intent)

            finish()
        })

    }


}
