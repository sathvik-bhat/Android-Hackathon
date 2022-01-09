package com.knightnight.login_and_stuff.Activities

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.knightnight.login_and_stuff.R

class CartItemsAdapter(private var names: ArrayList<String>?, private var costs: ArrayList<Int>?):
RecyclerView.Adapter<CartItemsAdapter.CartItemsViewHolder>()
{
    class CartItemsViewHolder(Itemview: View) : RecyclerView.ViewHolder(Itemview)

    fun removeItem(position: Int){
        names?.removeAt(position)
        costs?.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clearCart(){
        names= arrayListOf()
        costs= arrayListOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsViewHolder {
        return CartItemsAdapter.CartItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.radio_cart_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CartItemsViewHolder, position: Int) {
        var currName: String = names!!.get(position)
        var currCost: Int = costs!!.get(position)
        holder.itemView.apply {
            var item: TextView? = findViewById(R.id.tvCartItem)
            item?.text=currName
            var cost: TextView? = findViewById(R.id.tvCartItemCost)
            cost?.text= "" + currCost
            var remove: Button? = findViewById(R.id.btRemove)
            remove?.setOnClickListener(){
//                cart.add(currItem)
                Log.d("tag","" + names!!.size)
                removeItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return names!!.size
    }
}