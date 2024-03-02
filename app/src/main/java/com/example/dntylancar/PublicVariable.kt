package com.example.dntylancar

import android.app.Dialog
import android.view.View

class PublicVariable private constructor(){

    companion object{

        private var instance: PublicVariable? = null
        fun getInstance(): PublicVariable {
            return instance ?: synchronized(this) {
                instance ?: PublicVariable().also { instance = it }
            }
        }

    }

    var link: String? = null
    var isLogin: Boolean = false
    var bottoMsg: Dialog? = null
}