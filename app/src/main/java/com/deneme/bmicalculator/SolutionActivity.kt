package com.deneme.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution)

        val solTextView = findViewById<TextView>(R.id.solutionTextView)
        val tryButton = findViewById<Button>(R.id.tryButton)

        val height = intent.getStringExtra("height")
        val weight = intent.getStringExtra("weight")

        val heightStr = height.toString()
        val weightStr = weight.toString()

        val heightValue = heightStr.toDouble() / 100.0
        val weightValue = weightStr.toDouble()

        val BMI = weightValue / (heightValue * heightValue)
        val BMIString = String.format("%.2f", BMI)
        val message = "Your BMI is $BMIString.\n"

        val result = when {
            BMI < 18.5 -> "$message Your BMI value is Underweight."
            BMI >= 18.5 && BMI < 24.9 -> "$message Your BMI value is Normal."
            BMI >= 24.9 && BMI < 29.9 -> "$message Your BMI value is Overweight."
            BMI >= 29.9 -> "$message Your BMI value is Obese."
            else -> {
                "$message Your BMI value is incalculable."
            }
        }

        solTextView.text = result

        tryButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
