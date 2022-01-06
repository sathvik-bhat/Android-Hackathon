package com.example.shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var shopsAdapter: ShopsAdapter
    private lateinit var shopsrv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shopsAdapter = ShopsAdapter(mutableListOf(Shop("abc"), Shop("asdf"), Shop("rngrug")))
        shopsrv = findViewById(R.id.rvShops)
        shopsrv.adapter= shopsAdapter
        shopsrv.layoutManager=LinearLayoutManager(this)
//        val intent = Intent(this, ShopA::class.java)
    }
}