package com.e.hiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.e.hiro.utlis.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private var isLogged: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        if (isLogged) {
            mainFlow()
        } else {
            //nao renderiza
            bottomNavigationView.visibility = View.GONE
            loginFlow()
        }

    }

    private fun mainFlow() {


        val navGraphIds = listOf(R.navigation.home_graph, R.navigation.settings_graph)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.settings_graph,
            intent = intent
        )
    }

    private fun loginFlow() {
        val finalHost = NavHostFragment.create(R.navigation.login_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.host, finalHost)
            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
            .commit()
    }
}
