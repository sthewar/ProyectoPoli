package com.example.poliherramientas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Obtiene el nombre enviado desde MainActivity
        val name = intent.getStringExtra("EXTRA_NAME")

        // Encuentra el TextView y actualiza su texto con el nombre recibido
        val textView: TextView = findViewById(R.id.textViewResult)
        textView.text = getString(R.string.lorem_ipsum_text, name)
    }
}
