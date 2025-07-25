package com.example.blakerandom

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val num1 = findViewById<EditText>(R.id.firstNum)
        val num2 = findViewById<EditText>(R.id.secondNum)
        val res = findViewById<TextView>(R.id.result)

        var result = generate(num1.text.toString().toInt(), num2.text.toString().toInt())
        btn.setOnClickListener {
            res.text = result.toString()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun generate(num1: Int, num2: Int): Int {
        return Random.nextInt(num1, num2 + 1)
    }
}