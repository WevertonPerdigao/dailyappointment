package com.e.hiro.features.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager

import com.e.hiro.R
import com.e.hiro.features.home.adapter.ProductAdpter
import kotlinx.android.synthetic.main.content_produtos.*
import kotlinx.android.synthetic.main.produto_item.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var productAdpter: ProductAdpter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdpter = ProductAdpter()

        val layoutManager = LinearLayoutManager(activity)

        recycler_produtos.layoutManager = layoutManager
        recycler_produtos.adapter = productAdpter

        getData()
    }

    private fun getData() {


        val produtos: MutableList<Produto> = mutableListOf()


        produtos.add(Produto(1, "Produto 1", 2, "URL"))
        produtos.add(Produto(1, "Produto 2", 2, "URL"))
        produtos.add(Produto(1, "Produto 3", 2, "URL"))
        produtos.add(Produto(1, "Produto 4", 2, "URL"))
        produtos.add(Produto(1, "Produto 5", 2, "URL"))
        produtos.add(Produto(1, "Produto 6", 2, "URL"))
        produtos.add(Produto(1, "Produto 7", 2, "URL"))
        produtos.add(Produto(1, "Produto 8", 2, "URL"))
        produtos.add(Produto(1, "Produto 9", 2, "URL"))

        productAdpter.setProdutos(produtos)


    }

}
