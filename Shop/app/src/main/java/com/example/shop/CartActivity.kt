package com.example.shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    private lateinit var cartitemsAdapter: CartItemsAdapter
    private lateinit var cartitemsrv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val names: ArrayList< String>? = intent.getStringArrayListExtra("names")
        val costs: ArrayList<Int>? = intent.getIntegerArrayListExtra("costs") as ArrayList<Int>

        cartitemsAdapter = CartItemsAdapter(names, costs)
        cartitemsrv = findViewById(R.id.rvCartItems)
        cartitemsrv.adapter= cartitemsAdapter
        cartitemsrv.layoutManager= LinearLayoutManager(this)
    }
}