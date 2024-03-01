package com.example.dntylancar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    var PV_isLogin = PublicVariable().isLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener() {
            PV_isLogin = true
            if (PV_isLogin == true) {
                println("is Login")
            } else {
                println("not logged in")
            }
        }

        val registerLink = findViewById<TextView>(R.id.RegisterLinkText)
        registerLink.setOnClickListener(){
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }


    }
}