package com.deneme.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val height = findViewById<EditText>(R.id.heightText)
        val weight = findViewById<EditText>(R.id.weightText)
        val failMessage = findViewById<TextView>(R.id.failMessage)

        button.setOnClickListener {
            val heightStr = height.text.toString()
            val weightStr = weight.text.toString()
            if (height.text.isBlank() || weight.text.isBlank()) {
                failMessage.text = "Please enter a valid height and weight"
            } else {
                val intent = Intent(this, SolutionActivity::class.java)
                intent.putExtra("height", heightStr)
                intent.putExtra("weight", weightStr)
                startActivity(intent)
            }
        }
    }
}
