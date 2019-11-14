package com.example.tools.features.joke

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tools.MainActivity
import com.example.tools.R
import com.example.tools.di.JokeAdapter
import com.example.tools.di.ViewModelFactory
import com.example.tools.di.models.joke
import com.example.tools.services.ApiService
import kotlinx.android.synthetic.main.jokes_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Inject

class JockeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var jokeAdapter: JokeAdapter

    private val viewModel: JokeViewModule by viewModels { viewModelFactory }

    // Fields that need to be injected by the login graph


    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Obtaining the login graph from LoginActivity and instantiate
        // the @Inject fields with objects from the graph
        (activity as MainActivity).jokesComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.jokes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jokeAdapter = JokeAdapter()


        val layoutManager = LinearLayoutManager(activity)

        recycler_jokes.layoutManager = layoutManager
        recycler_jokes.adapter = jokeAdapter

        viewModel.jockes.observe(viewLifecycleOwner) {
            Log.d("lista", "")
            jokeAdapter.setJokes(it)

        }

    }


}