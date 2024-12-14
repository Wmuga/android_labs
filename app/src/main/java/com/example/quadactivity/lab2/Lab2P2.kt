package com.example.quadactivity.lab2

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.quadactivity.R

class Lab2P2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2_p2)

//        val table = findViewById<LinearLayout>(R.id.layoutTable)
//        for(i in 1..9 step 3){
//            table.addView(createRow(i))
//        }

        findViewById<Button>(R.id.btnTestAll).setOnClickListener{
            val newScreen = Intent(this, TestActivity::class.java)
            newScreen.putExtra(TestActivity.MSGFIELD,SelectMsg(0,true))
            startActivity(newScreen)
        }

        findViewById<Button>(R.id.btnTestManual).setOnClickListener{
            val newScreen = Intent(this, SelectActivity::class.java)
            startActivity(newScreen)
        }
    }

    private fun createRow(rowNum:Int): LinearLayout{
        val container = LinearLayout(this)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        params.setMargins(0,5,0,0)
        container.layoutParams = params
        container.orientation = LinearLayout.HORIZONTAL
        for (i in rowNum..rowNum+2){
            container.addView(createTableNum(i))
        }
        return container
    }

    private fun createTableNum(forNum:Int):TextView{
        val container = TextView(this)
        container.setTextSize(TypedValue.COMPLEX_UNIT_PT,8f)
        val text = ArrayList<String>()
        for (i in 1..10){
            text.add("$forNum * $i = ${forNum*i} ")
        }
        container.text = text.joinToString("\n")
        return container
    }
}