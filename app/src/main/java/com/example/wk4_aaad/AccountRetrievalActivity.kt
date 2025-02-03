// AccountRetrievalActivity.kt
package com.example.wk4_aaad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AccountRetrievalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_retrieval)

        val etEmail: EditText = findViewById(R.id.etEmail)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // Here you would normally verify the email and start a retrieval process.
            // For this example, simply display a Toast message.
            val email = etEmail.text.toString()
            if (email.isNotEmpty()) {
                Toast.makeText(this, "Submitted email: $email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a valid email.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
