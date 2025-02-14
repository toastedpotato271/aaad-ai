// AccountRetrievalActivity.kt
package com.example.wk4_aaad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AccountRetrievalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_retrieval)

        val etEmail: EditText = findViewById(R.id.etEmail)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val btnBack: ImageView = findViewById(R.id.btnBack)

        btnSubmit.setOnClickListener {

            // Set Click Listener
            startActivity(Intent(this, WelcomeActivity::class.java))

            // Here you would normally verify the email and start a retrieval process.
            // For this example, simply display a Toast message.
            val email = etEmail.text.toString()
            if (email.isNotEmpty()) {
                Toast.makeText(this, "$email retrieved successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a valid email.", Toast.LENGTH_SHORT).show()
            }
        }

        // Click Listener for btnBack
        btnBack.setOnClickListener {
            finish()
        }
    }
}
