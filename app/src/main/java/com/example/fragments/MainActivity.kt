package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.fragments.task1.Task1Activity
import com.example.fragments.task2.Task2Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonTask1 = findViewById<Button>(R.id.button_task1)
        val buttonTask2 = findViewById<Button>(R.id.button_task2)

        buttonTask1.setOnClickListener {
            val intent = Intent(this, Task1Activity::class.java)
            startActivity(intent)
        }

        buttonTask2.setOnClickListener {
            val intent = Intent(this, Task2Activity::class.java)
            startActivity(intent)
        }
    }
}
