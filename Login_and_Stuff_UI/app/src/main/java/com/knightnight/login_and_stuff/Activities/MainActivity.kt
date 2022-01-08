package com.knightnight.login_and_stuff.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.knightnight.login_and_stuff.R
import com.knightnight.login_and_stuff.SQL.DatabaseHelper
import com.knightnight.login_and_stuff.databinding.ActivityMainBinding
import com.knightnight.login_and_stuff.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener{
            checkUser()
        }

        binding.gotoReg.setOnClickListener{
            openReg()
        }
    }
    fun checkUser()
    {
        val database = DatabaseHelper(this)

        val email = binding.editTextTextPersonName.text.toString()
        val pwd = binding.editTextTextPassword.text.toString()
        if(email==""&&pwd=="")
            Toast.makeText(this,"Enter the Credentials!", Toast.LENGTH_LONG).show()
        else
        {
            val ans : Boolean = database.CheckUserfull(email,pwd)
            if(!ans)
                Toast.makeText(this,"Incorrect Credentials! Please try again", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"Welcome Customer!!",Toast.LENGTH_LONG).show()
            database.close()
        }

    }
    fun openReg(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_out_bottom,R.anim.slide_in_bottom)
    }
}

