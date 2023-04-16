package com.ferasdev.bottomsheetapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferasdev.bottomsheetapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        // R.layout.activity_main
        setContentView(view)

        setSupportActionBar(binding.toolbarActivityMain)
    }
}