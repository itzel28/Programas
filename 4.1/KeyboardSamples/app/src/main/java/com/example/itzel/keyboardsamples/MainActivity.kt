package com.example.itzel.keyboardsamples

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }
    fun showText(view: View) {

        val editText = findViewById<View>(R.id.editText_main) as EditText

        if (editText != null) {

            val showString = editText.text.toString()

            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show()

        }

    }

}