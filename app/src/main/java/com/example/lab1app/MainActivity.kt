package com.example.lab1app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            if (checkEmail(((editText1.text.toString()))) && editText2.text.toString() != ""){
                Toast.makeText(this@MainActivity,"Has iniciado sesión con exito!",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,SecondActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@MainActivity,"Usuario no valido, intentalo denuevo",Toast.LENGTH_SHORT).show()
            }

        }
    }
     val EMAIL_ADDRESS_PATTERN = Pattern.compile(
         "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
         "\\@" +
         "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
         "(" +
         "\\." +
         "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
         ")+")

    private fun checkEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }
}
