package com.andersonk.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.andersonk.androidcourse.fragments.HelloFragment
import com.andersonk.androidcourse.fragments.StackFragment
import com.andersonk.androidcourse.fragments.TesteFragment

import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val stackFragment = StackFragment()
        val helloFragment = HelloFragment()
        val testeFragment = TesteFragment()


        nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_stack -> {
                    replaceFragment(stackFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_hello -> {
                    replaceFragment(helloFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_teste -> {
                    replaceFragment(testeFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }

        }

    }


    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment, fragment::javaClass.toString()).commit()

    }


}
