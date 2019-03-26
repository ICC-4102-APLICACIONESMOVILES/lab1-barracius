package com.example.lab1app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button2.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        var intent = intent
        if( intent.hasExtra("Username")){
            button2.setVisibility(View.GONE)
            textView.setVisibility(View.GONE)
            texto_iniciado.setVisibility(View.VISIBLE)
            cerrar_sesion.setVisibility(View.VISIBLE)
            var user : String = intent.getStringExtra("Username")
            var pass: String = intent.getStringExtra("Password")
            val string = "Bienvenido $user, su clave es $pass"
            texto_iniciado.setText(string)
            cerrar_sesion.setOnClickListener {
                intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
    }}

}