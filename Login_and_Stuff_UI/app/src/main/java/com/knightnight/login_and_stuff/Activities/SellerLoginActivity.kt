package com.knightnight.login_and_stuff.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.knightnight.login_and_stuff.R
import com.knightnight.login_and_stuff.databinding.ActivityRegisterBinding
import com.knightnight.login_and_stuff.databinding.ActivitySellerLoginBinding

class SellerLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySellerLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {
            Check()
        }
        binding.gotoCustomer.setOnClickListener {
            gotoCus()
        }
    }
    fun Check()
    {
        val mail=binding.editTextTextPersonName.text.toString()
        val pwd=binding.editTextTextPassword.text.toString()
        if(mail=="admin"&&pwd=="1234")
        {
            val intent = Intent(this, SellerProductsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_left)
        }

        else
            Toast.makeText(this,"Incorrect Credentials! Try Again...",Toast.LENGTH_LONG).show()

    }
    fun gotoCus()
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_left)
    }
}