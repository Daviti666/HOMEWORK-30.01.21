package com.example.homework300121

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
        val email = sharedPreferences.getString("email","")
        val firstName = sharedPreferences.getString("firstName","")
        val lastName = sharedPreferences.getString("lastName","")
        val age:Int = sharedPreferences.getInt("age",0)
        val address = sharedPreferences.getString("address","")
        emailET.setText(email)
        firstNameET.setText(firstName)
        lastNameET.setText(lastName)
        ageET.setText(age.toString())
        addressET.setText(address)
    }
    fun save(view: View){
        val email = emailET.text.toString()
        val firstName = firstNameET.text.toString()
        val lastName = lastNameET.text.toString()
        val age = ageET.text.toString().toInt()
        val address = addressET.text.toString()
        if(email.isNotEmpty() and firstName.isNotEmpty() and lastName.isNotEmpty() and
                age.toString().isNotEmpty() and address.isNotEmpty()) {
            val editor = sharedPreferences.edit()
            editor.putString("email",email)
            editor.putString("firstName",firstName)
            editor.putString("lastName",lastName)
            editor.putInt("age",age)
            editor.putString("address",address)
            editor.apply()
        }
    }
}