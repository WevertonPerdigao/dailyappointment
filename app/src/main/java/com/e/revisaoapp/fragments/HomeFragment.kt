package com.e.revisaoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.e.revisaoapp.R
import com.e.revisaoapp.databinding.HomeFragmentBinding
import com.e.revisaoapp.models.User
import com.e.revisaoapp.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        val viewModel = HomeViewModel()

        binding.viewModel = viewModel
        val usuario = User("Weverton", "weverton.perdigao@itbam.org.br", "1234567")
        viewModel.usuario.set(usuario)


        return binding.root


    }

}

