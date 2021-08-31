package com.example.myapplication.activities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityPermissionsBinding

class PermissionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPermissionsBinding

    private val requestCameraPermission = 100
    private val requestCameraPicture    = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        To use this feature, uncomment permission usage in Manifest
//        binding.buttonPicture.setOnClickListener { getPictureFromCameraAskingPremissions() }

        binding.buttonPicture.setOnClickListener { getPictureFromCamera() }

    }

    private fun getPictureFromCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if ( intent.resolveActivity(packageManager) != null )
        {
            startActivityForResult(intent, requestCameraPicture)
            return
        }

        Toast.makeText(this, "No app to complete this action!", Toast.LENGTH_SHORT).show()
    }

    private fun getPictureFromCameraAskingPremissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                requestCameraPermission
            )
            return
        }

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, requestCameraPicture)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            requestCameraPermission -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestCameraPicture)
                    return
                }

                Toast.makeText(
                    this,
                    "You can't take a picture if you don't allow it",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            requestCameraPicture -> {
                if (resultCode == Activity.RESULT_OK) {
                    val extras = data!!.extras
                    val imageBitmap = extras?.get("data") as Bitmap

                    binding.imageViewPicture.setImageBitmap(imageBitmap)
                    return
                }

                Toast.makeText(this, "Picture has failed", Toast.LENGTH_SHORT).show()
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}