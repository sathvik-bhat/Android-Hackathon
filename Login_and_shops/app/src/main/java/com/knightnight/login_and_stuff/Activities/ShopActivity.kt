package com.knightnight.login_and_stuff.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.knightnight.login_and_stuff.R

class ShopActivity : AppCompatActivity() {
    private lateinit var itemsAdapter: ItemsAdapter
    private lateinit var itemsrv : RecyclerView
//    var cartNames: ArrayList<String>? = arrayListOf()
//    var cartCosts: ArrayList<Int>? = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoplayout)


        val name = intent.getStringExtra("name")

        var text : TextView = findViewById(R.id.textView)
        text.text=name



        itemsAdapter = ItemsAdapter(arrayListOf(Item("abc",10), Item("def",20), Item("xyz",30)))
        itemsrv = findViewById(R.id.recyclerView)
        itemsrv.adapter= itemsAdapter
        itemsrv.layoutManager= LinearLayoutManager(this)

        var btCart: Button? = findViewById(R.id.btCart)
        btCart?.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
//            var itemNames: ArrayList<String>  = arrayListOf<String>()
//            var itemCosts: ArrayList<Int> = arrayListOf<Int>()
//            for(i in 0 until cartNames!!.size){
//                itemNames.add(cartNames!!.get(i))
//            }
//            for(i in 0 until cartCosts!!.size){
//                itemCosts.add(cartCosts!!.get(i))
//            }
            intent.putExtra("names", itemsAdapter.cartNames)
            intent.putExtra("costs", itemsAdapter.cartCosts)
            startActivityForResult(this, intent, 69, Bundle())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("s", "")
        super.onActivityResult(requestCode, resultCode, data)
        if(data!= null)
        {
            Log.d("r", "")
            if (resultCode == Activity.RESULT_OK) {
                itemsAdapter.cartNames = data?.getStringArrayListExtra("names")
                itemsAdapter.cartCosts = data?.getIntegerArrayListExtra("costs")
                if(itemsAdapter.cartNames==null) itemsAdapter.cartNames = arrayListOf<String>()
                if(itemsAdapter.cartCosts==null) itemsAdapter.cartCosts = arrayListOf<Int>()
                Log.d("recieved", ""+ itemsAdapter.cartNames!!.size)
            }
        }
    }
}