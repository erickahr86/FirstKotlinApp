package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.app.preferences
import com.example.myapplication.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView( binding.root )

        binding.buttonSave.setOnClickListener { setValuesSharedPrefences(); cleanEditTexts(); getValuesSharedPrefences(); }

        getValuesSharedPrefences()
    }

    private fun getValuesSharedPrefences()
    {
        if ( preferences.name.isNotEmpty() && preferences.age >= 0)
        {
            binding.textViewSharedpreferences.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
            return
        }

        binding.textViewSharedpreferences.text = "Welcome, please save your name and age."
    }

    private fun setValuesSharedPrefences()
    {
        if ( binding.textViewName.text.toString().isNotEmpty() && binding.textViewAge.text.toString().isNotEmpty())
        {
            preferences.name = binding.textViewName.text.toString()
            preferences.age  = binding.textViewAge.text.toString().toInt()

            Toast.makeText(this, "Values have been saved successfully!", Toast.LENGTH_LONG).show()
            return
        }

        Toast.makeText(this, "Fill the name and the age before saving", Toast.LENGTH_LONG).show()
    }

    private fun cleanEditTexts()
    {
        binding.textViewName.setText( "" )
        binding.textViewAge.text.clear()
    }
}