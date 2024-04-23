package com.example.sentidosparaelalma.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sentidosparaelalma.MainActivity
import com.example.sentidosparaelalma.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    // Utiliza View Binding para una mejor práctica y para evitar findViewById.
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            if (validateCredentials(username, password)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Error de autenticación", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // Supongamos que los datos correctos son cualquier username y password no vacíos
        return username.isNotEmpty() && password.isNotEmpty()
    }
}
