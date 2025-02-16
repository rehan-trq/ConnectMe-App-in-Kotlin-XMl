package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var textViewTerms: TextView
    private lateinit var buttonRegister: Button
    private lateinit var textViewLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize UI elements
        editTextName = findViewById<EditText>(R.id.edittextName)
        editTextUsername = findViewById<EditText>(R.id.edittextUsername)
        editTextPhoneNumber = findViewById<EditText>(R.id.edittextPhoneNumber)
        editTextEmail = findViewById<EditText>(R.id.edittextEmail)
        editTextPassword = findViewById<EditText>(R.id.edittextPassword)
        textViewTerms = findViewById<TextView>(R.id.textViewTerms)
        buttonRegister = findViewById<Button>(R.id.buttonRegister)
        textViewLogin = findViewById<TextView>(R.id.textViewLogin)

        // Handle Register button click
        buttonRegister.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val username = editTextUsername.text.toString().trim()
            val phone = editTextPhoneNumber.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (name.isEmpty() || username.isEmpty() || phone.isEmpty() ||
                email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }

            else {
                // TODO: Implement actual registration logic
                Toast.makeText(this, "Registering user...", Toast.LENGTH_SHORT).show()
            }
        }

        // "Already have an account? Login"
        textViewLogin.setOnClickListener {
            // Navigate to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
