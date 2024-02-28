package com.example.dntylancar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerLink = findViewById<TextView>(R.id.RegisterLinkText)
        registerLink.setOnClickListener(){
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }


    }
}