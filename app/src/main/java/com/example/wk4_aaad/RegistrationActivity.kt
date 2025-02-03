// RegistrationActivity.kt
package com.example.wk4_aaad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Example registration fields (adjust the fields as needed)
        val etName: EditText = findViewById(R.id.etName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPhone: EditText = findViewById(R.id.etPhone)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etConfirmPassword: EditText = findViewById(R.id.etConfirmPassword)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // For this example, we simply display a message.
            Toast.makeText(this, "Registration details submitted", Toast.LENGTH_SHORT).show()
        }
    }
}
