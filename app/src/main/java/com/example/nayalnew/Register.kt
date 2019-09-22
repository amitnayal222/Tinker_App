package com.example.nayalnew

import android.content.Intent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.service.autofill.UserData
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        register.setOnClickListener {
            if (first_name.text.isEmpty()) {
                Toast.makeText(this, "Please Enter your First Name", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (last_name.text.isEmpty()) {
                Toast.makeText(this, "Please Enter your Last Name", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (number.text.isEmpty()) {
                Toast.makeText(this, "Please Enter your mobile number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (email.text.isEmpty())
            {
                Toast.makeText(this, "Please enter your email ID", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (password.text.isEmpty())
            {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
//            val pref = getSharedPreferences("USER", Context.MODE_PRIVATE)
//            pref.edit().apply(){
//                    putString("FIRST_NAME", first_name.text.toString())
//                    putString("LAST_NAME", last_name.text.toString())
//                    putInt("NUMBER", number.text.toString().toInt())
//                    commit()
//                }
            val user = User(
                first_name.text.toString(),
                last_name.text.toString(),
                number.text.toString().toInt(),
                email.text.toString(),
                password.text.toString())

            val context = this
            val db = DatabaseHelper(context)
            val  result = db.insertData(user)
            if (result == (-1).toLong())
                Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                finish()
//            val intent3 = Intent(this, WelcomeActivity::class.java)
//            startActivity(intent3)


        }


    }
}
