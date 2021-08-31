package com.example.myapplication.others

import android.content.Context

class MySharedPreferences(context: Context){

    private val filename = "my_preferences"
    private val prefs    = context.getSharedPreferences( filename, Context.MODE_PRIVATE )

    var name: String
        get()  = prefs.getString("name", "").toString()
    set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get()  = prefs.getInt("age", -1)
    set(value) = prefs.edit().putInt("age", value).apply()
}