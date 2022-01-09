package com.knightnight.login_and_stuff.Activities

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.knightnight.login_and_stuff.R

class ItemsAdapter(private val items: MutableList<Item>): RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {
    class ItemsViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView)

    var cartNames: ArrayList<String>? = arrayListOf<String>()
    var cartCosts: ArrayList<Int>? = arrayListOf()

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
            var cost: TextView? = findViewById(R.id.tvShopItemCost)
            cost?.text= "" + currItem.cost
            var add: Button? = findViewById(R.id.btAdd)
            add?.setOnClickListener(){
                cartNames!!.add(currItem.name)
                cartCosts!!.add(currItem.cost)
                Log.d("tag","" + cartNames!!.size)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}