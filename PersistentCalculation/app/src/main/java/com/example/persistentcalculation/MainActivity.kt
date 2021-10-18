package com.example.persistentcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var doubleNum: EditText
    lateinit var floatNum: EditText
    lateinit var multiply: Button
    lateinit var result: TextView
    var num1: Double = 0.0
    var num2: Float = 0.0f
    var resultText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         doubleNum = findViewById(R.id.doubleNum)
         floatNum = findViewById(R.id.floatNum)
         multiply = findViewById(R.id.multiply)
         result = findViewById(R.id.result)

        multiply.setOnClickListener {
             num1 = doubleNum.text.toString().toDouble()
             num2 = floatNum.text.toString().toFloat()
             resultText = (num1*num2).toString()
            result.text = "The Result:\n $resultText"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("result", resultText)

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        resultText = savedInstanceState.getString("result" ).toString()
        result.text =  "The Result:\n $resultText"
    }
}