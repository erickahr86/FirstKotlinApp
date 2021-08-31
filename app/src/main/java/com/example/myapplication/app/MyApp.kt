package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.others.MySharedPreferences

//  LazyLoad
val preferences: MySharedPreferences by lazy { MyApp.prefs!! }

class MyApp: Application() {

    companion object{
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences( applicationContext )
    }

}