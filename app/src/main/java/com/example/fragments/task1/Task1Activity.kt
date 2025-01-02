package com.example.fragments.task1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.fragments.R

class Task1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_task1) as NavHostFragment
    }
}
