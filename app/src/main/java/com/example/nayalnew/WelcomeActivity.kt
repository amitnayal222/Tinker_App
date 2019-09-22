package com.example.nayalnew

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val pref = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val name = pref.getString("NAME", "")
        username.text = "Welcome Back, " + name
        sign_out.setOnClickListener {

            pref.edit().apply(){
                putBoolean("IS_LOGIN", false)
                putString("NAME", null)
                commit()
            }
            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
