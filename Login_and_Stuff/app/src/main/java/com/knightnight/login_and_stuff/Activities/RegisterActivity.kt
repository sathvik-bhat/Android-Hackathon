package com.knightnight.login_and_stuff.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.knightnight.login_and_stuff.R
import com.knightnight.login_and_stuff.SQL.DatabaseHelper
import com.knightnight.login_and_stuff.databinding.ActivityMainBinding
import com.knightnight.login_and_stuff.databinding.ActivityRegisterBinding
import com.knightnight.login_and_stuff.model.User

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registerBtn.setOnClickListener{
            addToTable()
        }
        binding.gotoLogin.setOnClickListener {
            goback()
        }
    }
    fun goback(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
    fun addToTable(){

        val database = DatabaseHelper(this)

        val name = binding.regName.text.toString()
        val email = binding.regMail.text.toString()
        val pwd = binding.regPwd.text.toString()
        var new_user :User = User(-1,name,email,pwd)

        database.addUser(new_user)
        Toast.makeText(this,name+" is now registered",Toast.LENGTH_LONG).show()
        database.close()

    }
}