package com.example.wk4_aaad

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnBack: Button

    // Hardcoded username & password (for testing)
    private val validEmail = "user@androidkotlin.com"
    private val validPassword = "password12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Views
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnBack= findViewById(R.id.btnBack)

        // Set Click Listener
        btnLogin.setOnClickListener {
            loginUser()
        }
        btnBack.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }

    private fun loginUser() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Input validation
        when {
            TextUtils.isEmpty(email) -> {
                showToast("Email is required!")
                return
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                showToast("Enter a valid email!")
                return
            }
            TextUtils.isEmpty(password) -> {
                showToast("Password is required!")
                return
            }
            email == validEmail && password == validPassword -> {
                // Successful login
                showToast("Login Successful!")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            else -> {
                // Incorrect login
                showToast("Invalid Email or Password!")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}