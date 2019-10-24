package com.andersonk.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.andersonk.androidcourse.fragments.HelloFragment
import com.andersonk.androidcourse.fragments.StackFragment
import com.andersonk.androidcourse.fragments.TesteFragment

import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private val mainNavController: NavController? by lazy {
        findNavController(R.id.fragment)
        // fragment do menu
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //nav do menu
        mainNavController?.let { nav.setupWithNavController(it) }

    }


}
