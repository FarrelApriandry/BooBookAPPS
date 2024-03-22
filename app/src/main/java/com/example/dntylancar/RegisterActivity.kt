import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dntylancar.LoginActivity
import com.example.dntylancar.R
import com.example.dntylancar.api.ApiServiceBuilder
import com.example.dntylancar.models.RegisterRequest
import com.example.dntylancar.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val namaInput = findViewById<EditText>(R.id.textInputEditText_nama)
        val nikInput = findViewById<EditText>(R.id.textInputEditText_NIK)
        val emailInput = findViewById<EditText>(R.id.textInputEditText_email)
        val passwordInput = findViewById<EditText>(R.id.textInputEditText_pass)
        val registerButton = findViewById<Button>(R.id.button_register)

        registerButton.setOnClickListener {
            val nama = namaInput.text.toString().trim()
            val nik: Int = try {
                nikInput.text.toString().toInt()
            } catch (e: NumberFormatException) {
                0
            }
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            registerUser(nama, nik, email, password)
        }

        val loginLink = findViewById<TextView>(R.id.login2)
        loginLink.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }

    private fun registerUser(nama: String, nik: Int, email: String, password: String) {
        val service = ApiServiceBuilder.createService()
        service.register(RegisterRequest(nama, nik, email, password)).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful && response.body()?.success == true) {
                    Toast.makeText(this@RegisterActivity, "Register successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@RegisterActivity, "Register failed: ${response.body()?.message}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
