package com.example.dntylancar

import RegisterActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.dntylancar.api.ApiServiceBuilder
import com.example.dntylancar.databinding.FragmentPopUpLoginBerhasilBinding
import com.example.dntylancar.databinding.FragmentPopUpLoginGagalBinding
import com.example.dntylancar.models.LoginRequest
import com.example.dntylancar.models.LoginResponse
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Timer
import kotlin.concurrent.schedule




class LoginActivity : AppCompatActivity() {

    private lateinit var passInput: EditText
    private lateinit var emailInput: EditText
    val publicVariable = PublicVariable.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        passInput = findViewById(R.id.inputTxt_password)
        emailInput = findViewById(R.id.inputTxt_email)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val registerLink = findViewById<TextView>(R.id.RegisterLinkText)

        btn_login.setOnClickListener {
            loginUser(emailInput.text.toString().trim(), passInput.text.toString().trim())
        }

        registerLink.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

    }
    private fun loginUser(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            val service = ApiServiceBuilder.createService()
            service.login(LoginRequest(email, password)).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful && response.body()?.success == true) {
                        publicVariable.isLogin = true
                        popUpFragmentLogin(true)

                    } else {
                        publicVariable.isLogin = false
                        popUpFragmentLogin(false)

                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    publicVariable.isLogin = false
                    popUpFragmentLogin(false)
                }
            })
        }
    }

    private fun popUpFragmentLogin(isSuccess: Boolean) {
        if (isSuccess) {
            popUpFragmentLoginSuccess()
        } else {
            popUpFragmentLoginFailed()
        }
    }

    private fun resetLoginInputs() {
        emailInput.setText("")
        passInput.setText("")
    }

    private fun popUpFragmentLoginFailed() {
        val sheetLoginFailed = BottomSheetDialog(this, R.style.customBottomSheetDialogTheme)
        val bindingSheetLoginFailed = FragmentPopUpLoginGagalBinding.inflate(layoutInflater)

        sheetLoginFailed.apply {
            setContentView(bindingSheetLoginFailed.root)
            val mainConstraint = bindingSheetLoginFailed.mainConstraint
            val h = mainConstraint.maxHeight
            val bottomSheetBehavior =
                BottomSheetBehavior.from(bindingSheetLoginFailed.root.parent as View)
            bottomSheetBehavior.peekHeight = h
            bindingSheetLoginFailed.btnKembali.setOnClickListener {
                dismiss()
                resetLoginInputs()
            }
            show()
        }
    }




    private fun popUpFragmentLoginSuccess() {
        val sheetLoginSuccess = BottomSheetDialog(this, R.style.customBottomSheetDialogTheme)
        val bindingSheetLoginSuccess = FragmentPopUpLoginBerhasilBinding.inflate(layoutInflater)

        sheetLoginSuccess.apply {
            if (publicVariable.isLogin == true) {

                setContentView(bindingSheetLoginSuccess.root)
                val mainConstraint = bindingSheetLoginSuccess.mainConstraint
                val h = mainConstraint.maxHeight
                val bottomSheetBehavior =
                    BottomSheetBehavior.from(bindingSheetLoginSuccess.root.parent as View)
                bottomSheetBehavior.peekHeight = h
                publicVariable.bottoMsg = sheetLoginSuccess
                show()
                Timer().schedule(3000) {
                    (publicVariable.bottoMsg)?.dismiss()
                    publicVariable.bottoMsg = null
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
            }
        }
    }
}
