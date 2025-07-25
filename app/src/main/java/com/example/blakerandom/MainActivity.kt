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
        val num1EditText = findViewById<EditText>(R.id.firstNum)
        val num2EditText = findViewById<EditText>(R.id.secondNum)
        val resultTextView = findViewById<TextView>(R.id.result)

        btn.setOnClickListener {
            try {
                val num1 = num1EditText.text.toString().toInt()
                val num2 = num2EditText.text.toString().toInt()

                if (num1 >= num2) {
                    resultTextView.text = "Ошибка: первое число должно быть меньше второго"
                    return@setOnClickListener
                }

                val randomNumber = Random.nextInt(num1, num2 + 1)
                resultTextView.text = randomNumber.toString()
            } catch (e: NumberFormatException) {
                resultTextView.text = "Введите числа!"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}