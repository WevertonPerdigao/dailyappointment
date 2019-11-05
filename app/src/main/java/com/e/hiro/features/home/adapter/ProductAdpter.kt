package com.e.hiro.features.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.hiro.R
import com.e.hiro.features.home.Produto
import kotlinx.android.synthetic.main.produto_item.view.*

class ProductAdpter() : RecyclerView.Adapter<ProductAdpter.ProductHolder>() {

    val produtos = mutableListOf<Produto>()


//    fun bindData(question:Question){
//        view.owner_img.load
//    }


    fun setProdutos(produtos: MutableList<Produto>) {
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.produto_item, parent, false)
        return ProductHolder(view)

    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = produtos[position]
        holder.setProduct(product)
    }

    class ProductHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setProduct(produto: Produto) {

            view.name_project.text=produto.name.toString()
        }

    }


}