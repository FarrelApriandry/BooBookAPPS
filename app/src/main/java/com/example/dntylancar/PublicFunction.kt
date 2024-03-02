package com.example.dntylancar

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dntylancar.databinding.FragmentPopUpReportBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult

object PublicFunction {

    private lateinit var mediaPlayer: MediaPlayer

    fun initializeMediaPlayer(activity: Activity) {
        mediaPlayer = MediaPlayer.create(activity, R.raw.sfx_btn_click)
    }

    fun playSound() {
        if (::mediaPlayer.isInitialized && !mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    fun releaseMediaPlayer() {
        if (::mediaPlayer.isInitialized && mediaPlayer.isPlaying) {
            mediaPlayer.release()
        }
    }

    fun onStop(activity: Activity) {
        releaseMediaPlayer()
    }

    fun btnBack(activity: Activity) {
        run {
            activity.onBackPressed()
        }

    }

    fun PopUpFragmentLogin(context: Context, layoutInflater: LayoutInflater) {
        val dialog = BottomSheetDialog(context)
        val view = layoutInflater.inflate(R.layout.fragment_pop_up_login_action, null)
        val btnClose = view.findViewById<Button>(R.id.btn_close_card)
        val btnLogEmail = view.findViewById<ImageButton>(R.id.btn_auth_log_email)
        val btnLogGoogle = view.findViewById<ImageButton>(R.id.btn_auth_log_google)

        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()

        btnLogGoogle.setOnClickListener {
            openGoogleAccountPicker(context as Activity)
            dialog.dismiss()
        }

        btnLogEmail.setOnClickListener {
            context.startActivity(Intent(context, LoginActivity::class.java))
            dialog.dismiss()
        }

        btnClose.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun openGoogleAccountPicker(activity: Activity) {
        val intent = AccountManager.newChooseAccountIntent(null, null,
            arrayOf("com.google"), null, null, null, null)
        activity.startActivityForResult(intent, REQUEST_CODE_GOOGLE_ACCOUNT_PICKER)
    }

    const val REQUEST_CODE_GOOGLE_ACCOUNT_PICKER = 100

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_GOOGLE_ACCOUNT_PICKER) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    val account = data.getParcelableExtra<Account>(AccountManager.KEY_ACCOUNT_NAME)
                    Log.d("GoogleAccountPicker", "Account selected: $account")
                }
            }
        }
    }
}

