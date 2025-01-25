package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val  KEY_RESULT_IMC="KEY IMC"

class ResultActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra("KEY_RESULT_IMC" defaultValue:0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificação = findViewById<TextView>(R.id.tv_classificação)
        tvResult.text = result.toString()

        var classificação: String = null.toString()

        if (result > 18.5f) {
            if(result > 18.5f && result <= 24.9f) {
                classificação = "NORMAL"
            } else if(result > 25f && result <= 29.9f){
                classificação = "SOBREPESO"
            } else if(result > 30f && result <= 39.9f) {
                classificação = "Obesidade"
            } else {
                classificação = "OBESIDADE GRAVE"


tvClassificação.text = classificação






                println("Thiérry resultado" + result)

            }
        } else {
            classificação = "MAGREZA"
        }
    }
}