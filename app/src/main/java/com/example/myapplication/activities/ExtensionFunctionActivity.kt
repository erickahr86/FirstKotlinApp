package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityExtensionFunctionBinding
import com.example.myapplication.others.goToActivity
import com.example.myapplication.others.loadByURL
import com.example.myapplication.others.snackBar
import com.example.myapplication.others.toast

class ExtensionFunctionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExtensionFunctionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExtensionFunctionBinding.inflate( layoutInflater )
        setContentView( binding.root )

        binding.buttonToast       .setOnClickListener { toast("Hello") }
        binding.buttonSnackBar    .setOnClickListener {
            snackBar(
                "Hello from SnackBar!",
                action      = "Done",
                actionEvent = { toast("Cool!") }) }
        binding.buttonLoadByUrl   .setOnClickListener { binding.imageLoadedByUrl.loadByURL("http://images.foody.vn/res/g14/138986/prof/s576x330/foody-mobile-a2-jpg-261-635682356468932282.jpg") }
        binding.buttonGoToActivity.setOnClickListener { goToActivity<MainActivity>{ putExtra("id", 1) } }

    }
}