package com.example.quadactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.quadactivity.databinding.MainScreenBinding
import com.example.quadactivity.lab2.Lab2P1
import com.example.quadactivity.lab2.Lab2P2
import com.example.quadactivity.lab3.Lab3P1
import com.example.quadactivity.lab3.Lab3P2


class MainActivity : ComponentActivity() {
    private lateinit var binding: MainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLab2p1.setOnClickListener{startScreen(Lab2P1::class.java)}
        binding.btnLab2p2.setOnClickListener{startScreen(Lab2P2::class.java)}

        binding.btnLab3p1.setOnClickListener{startScreen(Lab3P1::class.java)}
        binding.btnLab3p2.setOnClickListener{startScreen(Lab3P2::class.java)}
    }

    private fun startScreen(cls:Class<*>){
        val newScreen = Intent(this, cls)
        startActivity(newScreen)
    }
}
