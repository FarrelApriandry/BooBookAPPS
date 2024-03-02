package com.example.dntylancar

import android.accounts.Account
import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.content.Intent
import android.widget.ImageButton
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.accounts.AccountManager
import android.util.Log
import android.view.View

class GuestLoginActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_login)

        val btnBack = findViewById<ImageButton>(R.id.btn_backHome)

        btnBack.setOnClickListener() {
            PublicFunction.btnBack(this)
        }

        PublicFunction.initializeMediaPlayer(this)

        val showPopUpButton = findViewById<ImageButton>(R.id.btn_login_boins)
        val showPopUpButton2 = findViewById<Button>(R.id.btn_login_boins2)
        val showPopUpButton3 = findViewById<Button>(R.id.btn_login_boins3)
        val showPopUpButton4 = findViewById<Button>(R.id.btn_login_boins4)
        val showPopUpButton5 = findViewById<Button>(R.id.btn_login_boins5)
        val showPopUpButton6 = findViewById<Button>(R.id.btn_login_boins6)
        val showPopUpButton7 = findViewById<Button>(R.id.btn_login_boins7)
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        showPopUpButton.setOnClickListener(){
            PublicFunction.playSound()
            PublicFunction.PopUpFragmentLogin(this, layoutInflater)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton2.setOnClickListener(){
            PublicFunction.playSound()
            PublicFunction.PopUpFragmentLogin(this, layoutInflater)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton3.setOnClickListener(){
            PublicFunction.playSound()
            PublicFunction.PopUpFragmentLogin(this, layoutInflater)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton4.setOnClickListener(){
            PublicFunction.playSound()
            PublicFunction.PopUpFragmentLogin(this, layoutInflater)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton5.setOnClickListener(){
            PublicFunction.playSound()
            PublicFunction.PopUpFragmentLogin(this, layoutInflater)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton6.setOnClickListener(){
            PublicFunction.playSound()
            PublicFunction.PopUpFragmentLogin(this, layoutInflater)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton7.setOnClickListener(){
            PublicFunction.playSound()
            PublicFunction.PopUpFragmentLogin(this, layoutInflater)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        PublicFunction.onStop(this)
    }
}