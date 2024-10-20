package com.example.quadactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.quadactivity.lab2.Lab2P1
import com.example.quadactivity.lab2.Lab2P2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)
        findViewById<Button>(R.id.btnLab2p1).setOnClickListener {
            val newScreen = Intent(this, Lab2P1::class.java)
            startActivity(newScreen)
        }
        findViewById<Button>(R.id.btnLab2p2).setOnClickListener {
            val newScreen = Intent(this, Lab2P2::class.java)
            startActivity(newScreen)
        }
    }
}
