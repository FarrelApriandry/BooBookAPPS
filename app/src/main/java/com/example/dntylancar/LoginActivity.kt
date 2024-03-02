package com.example.dntylancar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.dntylancar.databinding.FragmentPopUpLoginBerhasilBinding
import com.example.dntylancar.databinding.FragmentPopUpLoginGagalBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.delay
import java.util.Timer
import kotlin.concurrent.schedule

class LoginActivity : AppCompatActivity() {

    val publicVariable = PublicVariable.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val passInput = findViewById<EditText>(R.id.inputTxt_password)
        val emailInput = findViewById<EditText>(R.id.inputTxt_email)

        val btn_login = findViewById<Button>(R.id.btn_login)

        btn_login.setOnClickListener() {

            val txtInput: String = emailInput.text.toString() + passInput.text.toString()

            if (txtInput.trim().length<1) {
                publicVariable.isLogin = false
                popUpFragmentLoginSuccess()
            } else {
                publicVariable.isLogin = true
                popUpFragmentLoginSuccess()
            }

            if (publicVariable.isLogin == true) {
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

    private fun popUpFragmentLoginSuccess() {
        val sheetLoginSuccess = BottomSheetDialog(this, R.style.customBottomSheetDialogTheme)
        val bindingSheetLoginSuccess = FragmentPopUpLoginBerhasilBinding.inflate(layoutInflater)
        val bindingSheetLoginFailed = FragmentPopUpLoginGagalBinding.inflate(layoutInflater)

        sheetLoginSuccess.apply {
            if (publicVariable.isLogin == true) {

                setContentView(bindingSheetLoginSuccess.root)
                val mainConstraint = bindingSheetLoginSuccess.mainConstraint
                val h = mainConstraint.maxHeight
                val bottomSheetBehavior = BottomSheetBehavior.from(bindingSheetLoginSuccess.root.parent as View)
                bottomSheetBehavior.peekHeight = h
                publicVariable.bottoMsg = sheetLoginSuccess
                show()
                Timer().schedule(3000) {
                    (publicVariable.bottoMsg)?.dismiss()
                    publicVariable.bottoMsg = null
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
            } else {
                setContentView(bindingSheetLoginFailed.root)
                val mainConstraint = bindingSheetLoginFailed.mainConstraint
                val h = mainConstraint.maxHeight
                val bottomSheetBehavior = BottomSheetBehavior.from(bindingSheetLoginFailed.root.parent as View)
                bottomSheetBehavior.peekHeight = h
                publicVariable.bottoMsg = sheetLoginSuccess
                show()
                bindingSheetLoginFailed.btnKembali.setOnClickListener() {
                    run {
                        onBackPressed()
                    }
                }
            }
        }
    }
}