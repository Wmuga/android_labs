package com.example.quadactivity.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.quadactivity.R
import kotlin.random.Random

class TestActivity  : ComponentActivity() {
    companion object Const{
        const val MSGFIELD = "msg"
    }

    private val maxCount = 20
    private lateinit var formatTitle: String
    private lateinit var formatEq: String

    private lateinit var elemTitle:TextView
    private lateinit var elemEq:TextView
    private lateinit var elemInput:EditText
    private lateinit var elemPrint:TextView

    private var counter = 0
    private var okCount = 0
    private var num1 = 0
    private var num2 = 0
    private var random = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        formatTitle = getString(R.string.testProgress)
        formatEq = getString(R.string.testEq)
        elemTitle = findViewById(R.id.textTestTitle)
        elemEq = findViewById(R.id.textTestEq)
        elemInput = findViewById(R.id.inpTestResult)
        elemPrint = findViewById(R.id.textTestPrint)
        findViewById<Button>(R.id.btnTestResult).setOnClickListener{check()}

        counter = 0
        okCount = 0
        random = true

        showNext()

        val msg = intent.getSerializableExtra(MSGFIELD) as? SelectMsg ?: return

        if (!msg.random){
            num1 = msg.firstNum
            random = false
            showNext()
        }
    }

    private fun showNext(){
        if (random){
            num1 = Random.nextInt(10)+1
        }
        num2 = Random.nextInt(10)+1

        val title = String.format(formatTitle,counter+1,maxCount)
        val eq = String.format(formatEq,num1,num2)

        elemTitle.text = title
        elemEq.text = eq
        elemInput.setText("")
    }

    private fun check(){
        try{
            val answer = elemInput.text.toString().toInt()
            if (num1*num2 != answer){
                elemPrint.text = getString(R.string.testWrong)
                elemPrint.setTextColor(getColor(R.color.red))
            } else{
                elemPrint.text = getString(R.string.testOK)
                elemPrint.setTextColor(getColor(R.color.green))
                okCount++
            }

            counter++

            if (counter == maxCount){
                val newScreen = Intent(this, ResultActivity::class.java)
                newScreen.putExtra(ResultActivity.MSGFIELD,ResultMsg(okCount,maxCount-okCount))
                startActivity(newScreen)
                return
            }

            showNext()
        }catch(e:NumberFormatException){
            elemPrint.text = getString(R.string.testError)
            elemPrint.setTextColor(getColor(R.color.red))
        }
    }
}