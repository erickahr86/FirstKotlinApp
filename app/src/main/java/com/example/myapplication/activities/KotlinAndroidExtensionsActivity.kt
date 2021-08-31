package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityKotlinAndroidExtensionsBinding

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Modificar la forma de inflar el setContentView para empezar a usar View Binding
        val binding = ActivityKotlinAndroidExtensionsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Método Tradicional
        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this, "Click by ID", Toast.LENGTH_SHORT).show() }

        // Usando View Binding
        binding.buttonByKAT.setOnClickListener {
            Toast.makeText(
                this,
                "Click by KAT",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}