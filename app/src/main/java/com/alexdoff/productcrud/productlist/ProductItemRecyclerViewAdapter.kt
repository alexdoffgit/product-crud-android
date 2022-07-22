package com.alexdoff.productcrud.productlist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.alexdoff.productcrud.databinding.FragmentProductItemBinding
import com.alexdoff.productcrud.dataobject.Product
import com.alexdoff.productcrud.dataobject.Products

import com.alexdoff.productcrud.productlist.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ProductItemRecyclerViewAdapter(
    private val values: Products
) : RecyclerView.Adapter<ProductItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values.products[position]
        holder.idView.text = item.name
        holder.contentView.text = item.price
    }

    override fun getItemCount(): Int = values.products.size

    inner class ViewHolder(binding: FragmentProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.namaProduk
        val contentView: TextView = binding.hargaProduk

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}