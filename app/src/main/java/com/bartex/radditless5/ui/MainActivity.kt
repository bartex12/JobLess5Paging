package com.bartex.radditless5.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bartex.radditless5.R

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initToolbar()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
    }
    private fun initToolbar() {
        //поддержка экшенбара
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) //отключаем показ заголовка - у нас свой
        //текстовое поле в тулбаре
        with(toolbarTitle){
            textSize = 16f
            setTextColor(Color.WHITE)
            text = context.getString(R.string.app_name)
        }
    }
}