package com.example.shop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShopActivity : AppCompatActivity() {
    private lateinit var itemsAdapter: ItemsAdapter
    private lateinit var itemsrv : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoplayout)

        val name = intent.getStringExtra("name")

        var text : TextView = findViewById(R.id.textView)
        text.text=name



        itemsAdapter = ItemsAdapter(mutableListOf(Item("abc",10), Item("def",20), Item("xyz",30)))
        itemsrv = findViewById(R.id.recyclerView)
        itemsrv.adapter= itemsAdapter
        itemsrv.layoutManager= LinearLayoutManager(this)

        var btCart: Button? = findViewById(R.id.btCart)
        btCart?.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            var itemNames: ArrayList<String> = arrayListOf()
            var itemCosts: ArrayList<Int> = arrayListOf()
            for(item in itemsAdapter.cart){
                itemNames.add(item.name)
                itemCosts.add(item.cost)
            }
            intent.putExtra("names", itemNames)
            intent.putExtra("costs", itemCosts)
            ContextCompat.startActivity(this, intent, Bundle())
        }
    }
}