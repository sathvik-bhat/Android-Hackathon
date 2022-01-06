package com.example.shop

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShopA : AppCompatActivity() {
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

    }
}