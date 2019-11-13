package com.example.tools.features.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.tools.MainActivity
import com.example.tools.R
import com.example.tools.di.ViewModelFactory
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
   @Inject
    lateinit var loginRepository: LoginRepository


    private val viewModel: LoginViewModule by viewModels { viewModelFactory }

    // Fields that need to be injected by the login graph


    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Obtaining the login graph from LoginActivity and instantiate
        // the @Inject fields with objects from the graph
        (activity as MainActivity).loginComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.jockes.observe(viewLifecycleOwner) {
            Log.d("", "")
        }
    }

}