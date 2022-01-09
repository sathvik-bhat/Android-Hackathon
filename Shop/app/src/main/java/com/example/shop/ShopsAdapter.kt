package com.example.shop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class ShopsAdapter(private val shops: MutableList<Shop>) : RecyclerView.Adapter<ShopsAdapter.ShopsViewHolder>() {

    class ShopsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    fun addShop(shop: Shop) {
        shops.add(shop)
        notifyItemInserted(shops.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopsViewHolder {
        return ShopsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.radio_shop_item, parent,false))
    }

    override fun onBindViewHolder(holder: ShopsViewHolder, position: Int) {
        val currShop = shops[position]
        holder.itemView.apply {
            var shop: TextView = findViewById(R.id.tvDisplayShop)
            shop.text = currShop.name
            var enter: Button = findViewById(R.id.btEnter)
            enter.setOnClickListener(){
                Log.d("demo", currShop.name)
                val intent = Intent(context, ShopActivity::class.java)
                intent.putExtra("name", currShop.name)
//                intent.putExtra("name", shops)
                startActivity(context, intent, Bundle())
            }
        }
    }

    override fun getItemCount(): Int {
        return shops.size
    }

}