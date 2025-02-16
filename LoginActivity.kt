package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.editTextUsername)
        val etPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)
        val tvForgotPassword = findViewById<TextView>(R.id.textViewForgotPassword)
        val ivGoogle = findViewById<ImageView>(R.id.buttonGoogle)
        val ivApple = findViewById<ImageView>(R.id.buttonApple)
        val ivFacebook = findViewById<ImageView>(R.id.buttonFacebook)
        val tvRegister = findViewById<TextView>(R.id.textViewRegister)


        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }




        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        }

        ivGoogle.setOnClickListener {
            Toast.makeText(this, "Google Login clicked", Toast.LENGTH_SHORT).show()
        }

        ivApple.setOnClickListener {
            Toast.makeText(this, "Apple Login clicked", Toast.LENGTH_SHORT).show()
        }

        ivFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook Login clicked", Toast.LENGTH_SHORT).show()
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}