package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar os componentes de Edittext
        // Criar uma váriavel e associar o componente de UI<EditText>
        // Recuperar botão da tela
        // Colocar ação no botão
        // Recuperar o peso digitado no texto

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btncalcular)

        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if(pesoStr == "" && alturaStr == ""){
                //Mostra mensagem para o usúario

                Snackbar
                    .make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG

                    )
                    .show()

            }else{
                val peso = edtPeso.text.toString().toFloat()
                val altura = edtAltura.text.toString().toFloat()


                val alturaQ2 = (altura * altura)
                val result = peso / alturaQ2

                // Cores
                // EditText background + Icone
                // Gradiente + icone + titulo + descrição

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, result)
                startActivity(intent)

                println("Thiérry ação do botão" + result)
            }

        }

    }
}

private fun Intent.putExtras(keyResultImc: String, result: Float) {

}
