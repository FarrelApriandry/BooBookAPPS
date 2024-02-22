package com.example.dntylancar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val loginLink = findViewById<TextView>(R.id.login2)
        loginLink.setOnClickListener(){
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }
}