package com.example.nayalnew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pref = getSharedPreferences("USER", Context.MODE_PRIVATE)
        if (pref.getBoolean("IS_LOGIN", false)){
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
//            Log.v("MainActivity", "Yes")
        }

//        Log.v("MainActivity", "No")
        login.setOnClickListener {
            if (username.text.isEmpty()){
                Toast.makeText(this, "Please enter your username", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (password.text.isEmpty()){
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, WelcomeActivity::class.java)
            pref.edit().apply(){
                putBoolean("IS_LOGIN", true)
                putString("NAME", username.text.toString())
                commit()
            }
            startActivity(intent)
            finish()

        }
        register_here.setOnClickListener{
            val intent2 = Intent(this,Register::class.java)
            startActivity(intent2)
        }


    }
}
