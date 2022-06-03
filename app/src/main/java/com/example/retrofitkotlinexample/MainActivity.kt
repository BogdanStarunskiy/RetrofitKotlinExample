package com.example.retrofitkotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitkotlinexample.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, MainFragment()).commit()
    }
}