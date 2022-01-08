package com.knightnight.login_and_stuff.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.knightnight.login_and_stuff.R
import com.knightnight.login_and_stuff.databinding.ActivitySellerLoginBinding
import com.knightnight.login_and_stuff.databinding.ActivitySellerProductsBinding

class SellerProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySellerProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regProduct.setOnClickListener {
           //yaha shubhanshu karega kaam
        }
        binding.enterNew.setOnClickListener {
        }
           doit()
        }
    fun doit()
    {
        binding.productPrice.setText("")
        binding.productName.setText("")
    }
}