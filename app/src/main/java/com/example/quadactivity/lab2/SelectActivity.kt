package com.example.quadactivity.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.quadactivity.R

class SelectActivity : ComponentActivity() {
    private lateinit var errElem:TextView
    private lateinit var inpElem:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        findViewById<Button>(R.id.btnTestStart).setOnClickListener{start()}
        errElem = findViewById(R.id.selectErr)
        inpElem = findViewById(R.id.inpTestNumber)
    }

    private fun start(){
        try {
            val firstNum = inpElem.text.toString().toInt()

            if (firstNum < 1 || firstNum > 10){
                throw NumberFormatException()
            }

            errElem.text = ""

            val newScreen = Intent(this, TestActivity::class.java)
            newScreen.putExtra(TestActivity.MSGFIELD, SelectMsg(firstNum, false))
            startActivity(newScreen)

        }catch(e:NumberFormatException){
            errElem.text = getString(R.string.testError)
        }
    }
}