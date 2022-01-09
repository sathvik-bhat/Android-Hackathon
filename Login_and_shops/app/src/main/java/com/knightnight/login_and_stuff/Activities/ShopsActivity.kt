package com.knightnight.login_and_stuff.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.knightnight.login_and_stuff.R

class ShopsActivity : AppCompatActivity() {
    private lateinit var shopsAdapter: ShopsAdapter
    private lateinit var shopsrv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)

        shopsAdapter = ShopsAdapter(mutableListOf(Shop("abc"), Shop("asdf"), Shop("rngrug")))
        shopsrv = findViewById(R.id.rvShops)
        shopsrv.adapter= shopsAdapter
        shopsrv.layoutManager=LinearLayoutManager(this)
//        val intent = Intent(this, ShopA::class.java)
    }
}