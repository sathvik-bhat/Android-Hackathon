package com.knightnight.login_and_stuff.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.knightnight.login_and_stuff.R

class CartActivity : AppCompatActivity() {
    private lateinit var cartitemsAdapter: CartItemsAdapter
    private lateinit var cartitemsrv : RecyclerView
    var names: ArrayList<String>? = arrayListOf()
    var costs: ArrayList<Int>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        names = intent.getStringArrayListExtra("names")
        costs = intent.getIntegerArrayListExtra("costs")

        cartitemsAdapter = CartItemsAdapter(names, costs)
        cartitemsrv = findViewById(R.id.rvCartItems)
        cartitemsrv.adapter= cartitemsAdapter
        cartitemsrv.layoutManager= LinearLayoutManager(this)

        val clear: Button = findViewById(R.id.btClearCart)
        clear.setOnClickListener {
            cartitemsAdapter.clearCart()
            names= arrayListOf<String>()
            costs= arrayListOf<Int>()
//            val returnIntent = Intent()
//            returnIntent.putExtra("names", names)
//            returnIntent.putExtra("names", costs)
//            Log.d("tag69", ""+names!!.size)
//            setResult(Activity.RESULT_OK, returnIntent)
//            finish()
        }
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        val returnIntent = Intent()
        returnIntent.putExtra("names", names)
        returnIntent.putExtra("names", costs)
        Log.d("tag69", ""+names!!.size)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}