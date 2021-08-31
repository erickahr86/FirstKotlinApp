package com.example.myapplication.others

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.activities.models.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar
{
    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?)
    {
        _toolbar = toolbar
        _toolbar?.let {
            setSupportActionBar( _toolbar )
        }
    }

    override fun enableHomeDisplay(value: Boolean)
    {
        supportActionBar!!.setDisplayHomeAsUpEnabled( value )
    }
}