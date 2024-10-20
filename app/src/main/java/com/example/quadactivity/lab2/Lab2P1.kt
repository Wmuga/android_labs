package com.example.quadactivity.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.quadactivity.R
import java.lang.Float.parseFloat
import kotlin.math.sqrt

class Lab2P1 : ComponentActivity() {
    private lateinit var aElem: EditText
    private lateinit var bElem: EditText
    private lateinit var cElem: EditText
    private lateinit var x1Elem: TextView
    private lateinit var x2Elem: TextView
    private lateinit var errElem: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2_p1)

        aElem = findViewById(R.id.inEqA)
        bElem = findViewById(R.id.inEqB)
        cElem = findViewById(R.id.inEqC)
        x1Elem = findViewById(R.id.textEqX1)
        x2Elem = findViewById(R.id.textEqX2)
        errElem = findViewById(R.id.textEqErr)

        findViewById<Button>(R.id.btnEqSolve).setOnClickListener{this.solve()}
    }

    private fun solve(){
        try{
            val a = parseFloat(aElem.text.toString())
            val b = parseFloat(bElem.text.toString())
            val c = parseFloat(cElem.text.toString())

            aElem.setText("")
            bElem.setText("")
            cElem.setText("")

            errElem.text = ""

            val descr = b*b-4*a*c

            if (descr < 0){
                errElem.text = "Нет решения: Дескриминант меньше 0"
                return
            }

            var x1 = (-b+sqrt(descr))/2/a
            var x2 = (-b-sqrt(descr))/2/a

            x1Elem.text = x1.toString()
            x2Elem.text = x2.toString()

        }catch (e:NumberFormatException){
            errElem.text = "Неправильный формат чисел"
        }
    }
}