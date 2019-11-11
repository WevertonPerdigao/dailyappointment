package com.e.hiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.e.hiro.features.UserSessionViewModel
import com.e.hiro.utlis.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var finalHost: NavHostFragment
    private val viewModel: UserSessionViewModel by viewModels()

    private lateinit var bottomNavigationView: BottomNavigationView
    private var isLogged: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.authenticationState.observe(this, Observer { authenticationState ->
            when (authenticationState) {
                UserSessionViewModel.AuthenticationState.AUTHENTICATED -> {
                    supportFragmentManager.beginTransaction().remove(finalHost).commitNow()
                    mainFlow()
                }
                UserSessionViewModel.AuthenticationState.UNAUTHENTICATED -> {
                    loginFlow()
                }
            }
        })

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
        bottomNavigationView.visibility = View.VISIBLE

        val navGraphIds = listOf(R.navigation.home_graph, R.navigation.settings_graph,R.navigation.publish_graph)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.host,
            intent = intent
        )
    }

    private fun loginFlow() {
        bottomNavigationView.visibility = View.GONE

        if (!::finalHost.isInitialized) {
            finalHost = NavHostFragment.create(R.navigation.login_graph)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.host, finalHost)
            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
            .commit()
    }

}
