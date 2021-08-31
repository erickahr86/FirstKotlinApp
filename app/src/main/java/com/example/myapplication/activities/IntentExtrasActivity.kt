package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.activities.models.Student
import com.example.myapplication.databinding.ActivityIntentExtrasBinding
import com.example.myapplication.others.ToolbarActivity

class IntentExtrasActivity : ToolbarActivity() {

    private lateinit var binding: ActivityIntentExtrasBinding
    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentExtrasBinding.inflate( layoutInflater )
        setContentView( binding.root )

        toolbar = findViewById(R.id.toolbar)
        toolbarToLoad( toolbar )
        enableHomeDisplay( true )

//        setSupportActionBar( toolbar )
//        supportActionBar!!.setDisplayHomeAsUpEnabled( true )

        binding.buttonBack.setOnClickListener { startActivity( Intent( this, IntentsActivity::class.java )) }

        getIntentExtrasFromPreviosActivity()

        val student = intent.getParcelableExtra<Student>("student")
        student?.let{
            binding.textViewName     .text      = student.name
            binding.textViewLastName .text      = student.lastName
            binding.textViewAge      .text      = "${student.age}"
            binding.checkBoxDeveloper.isChecked = student.isDeveloper
        }
    }

    private fun getIntentExtrasFromPreviosActivity(){

        val name      = intent.getStringExtra  ("name"     )
        val lastName  = intent.getStringExtra  ("lastName" )
        val age       = intent.getIntExtra     ("age"      , -1    )
        val developer = intent.getBooleanExtra ("developer", false )

        if ( name != null && lastName != null && age >= 0 )
        {
            binding.textViewName     .text      = name
            binding.textViewLastName .text      = lastName
            binding.textViewAge      .text      = age.toString()
            binding.checkBoxDeveloper.isChecked = developer

            return
        }

        binding.checkBoxDeveloper.visibility = View.INVISIBLE
    }
}