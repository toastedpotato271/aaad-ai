package com.example.wk4_aaad

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Initialize UI components
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnBack = findViewById(R.id.btnBack)

        // Submit button click listener
        btnSubmit.setOnClickListener {
            if (validateInputs()) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                // You can proceed with user registration logic (e.g., saving data to database)
            }
        }

        // Back button click listener
        btnBack.setOnClickListener {
            finish() // Close the current activity and return to the previous screen
        }
    }

    private fun validateInputs(): Boolean {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()

        // Check for empty fields
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showToast("All fields are required!")
            return false
        }

        // Validate email format
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Enter a valid email address!")
            return false
        }

        // Validate phone number format (should contain only digits and be at least 10 characters)
        if (!phone.matches(Regex("^[0-9]{11,13}$"))) {
            showToast("Enter a valid phone number (11-13 digits)!")
            return false
        }

        // Validate password length
        if (password.length < 6) {
            showToast("Password must be at least 6 characters!")
            return false
        }

        // Check if passwords match
        if (password != confirmPassword) {
            showToast("Passwords do not match!")
            return false
        }

        return true // All validations passed
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
