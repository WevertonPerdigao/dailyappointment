package com.e.hiro.features.publish


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.e.hiro.R
import com.e.hiro.features.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_publish.*

/**
 * A simple [Fragment] subclass.
 */
class PublishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publish, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_dialog.setOnClickListener({
            it.findNavController().navigate(PublishFragmentDirections.navToConfirmation())
        })
    }

}
