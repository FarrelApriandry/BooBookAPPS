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
import android.accounts.AccountManagerCallback
import android.accounts.AccountManagerFuture
import android.util.Log

class GuestLoginActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_login)

        val btnBack = findViewById<ImageButton>(R.id.btn_backHome)

        btnBack.setOnClickListener() {
                run {
                onBackPressed()
            }
        }

        val showPopUpButton = findViewById<ImageButton>(R.id.btn_login_boins)
        val showPopUpButton2 = findViewById<Button>(R.id.btn_login_boins2)
        val showPopUpButton3 = findViewById<Button>(R.id.btn_login_boins3)
        val showPopUpButton4 = findViewById<Button>(R.id.btn_login_boins4)
        val showPopUpButton5 = findViewById<Button>(R.id.btn_login_boins5)
        val showPopUpButton6 = findViewById<Button>(R.id.btn_login_boins6)
        val showPopUpButton7 = findViewById<Button>(R.id.btn_login_boins7)
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        mediaPlayer = MediaPlayer.create(this, R.raw.sfx_btn_click)

        showPopUpButton.setOnClickListener(){
            playSound()
            showCustomDialog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton2.setOnClickListener(){
            playSound()
            showCustomDialog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton3.setOnClickListener(){
            playSound()
            showCustomDialog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton4.setOnClickListener(){
            playSound()
            showCustomDialog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton5.setOnClickListener(){
            playSound()
            showCustomDialog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton6.setOnClickListener(){
            playSound()
            showCustomDialog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }
        showPopUpButton7.setOnClickListener(){
            playSound()
            showCustomDialog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(10)
            }
        }

    }

    private fun playSound() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    override fun onStop() {
        super.onStop()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.release()
        }
    }

    fun openGoogleAccountPicker() {
        val accountManager = AccountManager.get(this)
        val intent = AccountManager.newChooseAccountIntent(null, null,
            arrayOf("com.google"), false, null, null, null, null)
        startActivityForResult(intent, REQUEST_CODE_GOOGLE_ACCOUNT_PICKER)
    }

    companion object {
        const val REQUEST_CODE_GOOGLE_ACCOUNT_PICKER = 100
    }

    private fun showCustomDialog() {
        val dialog = BottomSheetDialog(this)
        val root = findViewById<ConstraintLayout>(R.id.popUpLogin)
        val view = layoutInflater.inflate(R.layout.activity_pop_up_login_action, root )
        val btnCLose = view.findViewById<Button>(R.id.btn_close_card)
        val btnLogEmail = view.findViewById<ImageButton>(R.id.btn_auth_log_email)
        val btnLogGoogle =  view.findViewById<ImageButton>(R.id.btn_auth_log_google)
        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()

        btnLogGoogle.setOnClickListener() {
            openGoogleAccountPicker()
        }

        btnCLose.setOnClickListener {
            dialog.dismiss()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_GOOGLE_ACCOUNT_PICKER) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    val account = data.getParcelableExtra<Account>(AccountManager.KEY_ACCOUNT_NAME)
                    Log.d("GoogleAccountPicker", "Account selected: $account")
                }
                // Account selected, do something with it Log.d("GoogleAccountPicker", "Account selected: $account") } } } super.onActivityResult(requestCode, resultCode, intent)
            }
        }
    }
}