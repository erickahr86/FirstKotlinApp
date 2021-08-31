package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.activities.models.Student
import com.example.myapplication.databinding.ActivityIntentsBinding

class IntentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentsBinding
    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar( toolbar )

        binding.buttonWithExtras  .setOnClickListener { goIntentExtras() }
        binding.buttonWithFlags   .setOnClickListener { goIntentFlags () }
        binding.buttonIntentObject.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name"     , "Erick")
        intent.putExtra("lastName" , "Herrera")
        intent.putExtra("age"      , 35)
        intent.putExtra("developer", true)

        startActivity(intent)
    }

    private fun goIntentFlags() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
    }

    private fun goIntentObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Cristopher", "Herrera", 15, true)

        intent.putExtra("student", student )
        startActivity(intent)
    }
}