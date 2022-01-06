package com.example.shop

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val items: MutableList<Item>): RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {
    class ItemsViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsAdapter.ItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.radio_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val currItem = items[position]
        holder.itemView.apply {
            var item: TextView? = findViewById(R.id.tvDisplayItem)
            item?.text=currItem.name
            var add: Button? = findViewById(R.id.btAdd)
            add?.setOnClickListener(){
                Log.d("tag","abc")
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}