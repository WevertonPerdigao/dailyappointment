package com.testeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.testeapp.models.Todo
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    companion object{
        val DETAIL_ORIGEM="Detail Origem"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        intent.extras?.let {
            val objtodo = intent.getParcelableExtra<Todo>(DETAIL_ORIGEM)



             desc_detail.text=objtodo.description
//            desc_detail.



        }
    }
}
