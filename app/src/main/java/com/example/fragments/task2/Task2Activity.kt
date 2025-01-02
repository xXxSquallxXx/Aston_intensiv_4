package com.example.fragments.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.fragments.R

class Task2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_task2) as NavHostFragment
        navHostFragment.navController
    }
}
