package com.example.poliherramientas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.poliherramientas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // El listener debe estar dentro de onCreate.
        binding.button.setOnClickListener {
            val name = binding.editTextText.text.toString()
            if (name.isNotBlank()) {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_NAME", name)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}