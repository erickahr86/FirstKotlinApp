package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.activities.*
import com.example.myapplication.others.ToolbarActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : ToolbarActivity() {

    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbarToLoad( toolbar )


        val btnLifecycle          = findViewById<Button>( R.id.button_to_cycle)
        val btnClickEvents        = findViewById<Button>( R.id.button_to_click)
        val btnAndroidExt         = findViewById<Button>( R.id.button_to_android_extensions)
        val btnPicasso            = findViewById<Button>( R.id.button_to_picasso)
        val btnListView           = findViewById<Button>( R.id.button_to_list_view)
        val btnIntents            = findViewById<Button>( R.id.button_to_intents)
        val btnPermissions        = findViewById<Button>( R.id.button_to_permissions)
        val btnSharedPreferences  = findViewById<Button>( R.id.button_to_shared_preferences)
        val btnExtensionFunctions = findViewById<Button>( R.id.button_to_extension_functions)

        btnLifecycle          .setOnClickListener { goToLifeCycleActivity() }
        btnClickEvents        .setOnClickListener { goToClickEventsActivity() }
        btnAndroidExt         .setOnClickListener { goToKotlinAndroidExtActivity() }
        btnPicasso            .setOnClickListener { goToPicassoActivity() }
        btnListView           .setOnClickListener { goToListViewActivity() }
        btnIntents            .setOnClickListener { goToIntentsActivity() }
        btnPermissions        .setOnClickListener { goToPermissionsActivity() }
        btnSharedPreferences  .setOnClickListener { goToSharedPreferencesActivity() }
        btnExtensionFunctions .setOnClickListener { goToExtensionFunctionsActivity() }

    }

    fun showToast() {
        Toast.makeText(this, "Hello from Toast1", Toast.LENGTH_LONG).show()
    }

    fun showSnackBar() {
        val layout = findViewById<ConstraintLayout>(R.id.constranti)

        Snackbar.make(layout, "Hello from the SnackBar!", Snackbar.LENGTH_LONG).show()
        Snackbar.make(layout, "Hello from the SnackBar!", Snackbar.LENGTH_LONG).setAction("UNDO") {
            Snackbar.make(layout, "Email has been restored", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun goToLifeCycleActivity          () = startActivity( Intent(this, LifeCycleActivity::class.java) )
    private fun goToClickEventsActivity        () = startActivity( Intent(this, ClickEventsActivity::class.java) )
    private fun goToKotlinAndroidExtActivity   () = startActivity( Intent(this, KotlinAndroidExtensionsActivity::class.java) )
    private fun goToPicassoActivity            () = startActivity( Intent(this, PicassoActivity::class.java) )
    private fun goToListViewActivity           () = startActivity( Intent(this, ListViewActivity::class.java) )
    private fun goToIntentsActivity            () = startActivity( Intent(this, IntentsActivity::class.java) )
    private fun goToPermissionsActivity        () = startActivity( Intent(this, PermissionsActivity::class.java) )
    private fun goToSharedPreferencesActivity  () = startActivity( Intent(this, SharedPreferencesActivity::class.java) )
    private fun goToExtensionFunctionsActivity () = startActivity( Intent(this, ExtensionFunctionActivity::class.java) )


}