package com.example.quadactivity.lab2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.quadactivity.R

class ResultActivity  : ComponentActivity() {
    companion object Const{
        val MSGFIELD = "msg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val msg = intent.getSerializableExtra(MSGFIELD) as? ResultMsg ?: return

        val formatOk = getString(R.string.testOKCount)
        val formatWrong = getString(R.string.testWrongCount)
        val formatPercent = getString(R.string.testPercent)

        findViewById<TextView>(R.id.textResultOk).text = String.format(formatOk,msg.countRight)
        findViewById<TextView>(R.id.textResultWrong).text = String.format(formatWrong,msg.countWrong)
        findViewById<TextView>(R.id.textResultPercent).text = String.format(formatPercent,msg.countRight*100/(msg.countRight+msg.countWrong))

    }
}