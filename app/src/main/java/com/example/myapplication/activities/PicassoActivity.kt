package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityPicassoBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class PicassoActivity : AppCompatActivity() {

    private var binding: ActivityPicassoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPicassoBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.buttonLoader.setOnClickListener { loadImages() }

        Picasso.get().isLoggingEnabled = true

        Picasso.get().load("http://images.foody.vn/res/g14/138986/prof/s576x330/foody-mobile-a2-jpg-261-635682356468932282.jpg").fetch()
    }

    private fun loadImages(){
        Picasso.get()
            .load("http://images.foody.vn/res/g14/138986/prof/s576x330/foody-mobile-a2-jpg-261-635682356468932282.jpg")
            .fit()
            .into(binding!!.imageViewTop)

//        Picasso.get()
//            .load("https://www.instituteofphotography.in/wp-content/uploads/2015/05/dummy-profile-pic-300x300.jpg")
//            .fit()
//            .into(binding!!.imageViewBottom)

        Picasso.get()
            .load("https://www.instituteofphotography.in/wp-content/uploads/2015/05/dummy-profile-pic-300x300.jpg")
            .fetch(object : Callback {
                override fun onSuccess() {
                    binding!!.imageViewBottom.alpha = 0f
                    Picasso.get()
                        .load("https://www.instituteofphotography.in/wp-content/uploads/2015/05/dummy-profile-pic-300x300.jpg")
                        .fit()
                        .into(binding!!.imageViewBottom)
                    binding!!.imageViewBottom.animate().setDuration(1300).alpha(1f)
                }

                override fun onError(e: Exception?) {

                }

            })

        binding!!.buttonLoader.setText("Hola!")
    }

}