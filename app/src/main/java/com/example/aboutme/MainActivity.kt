package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDone: Button = findViewById(R.id.done_button)
        val nickname_edit: TextView = findViewById(R.id.nickname_edit)
        val nickname_text: TextView = findViewById(R.id.nickname_text)

        btnDone.setOnClickListener(){

            val nickname = nickname_edit.text.toString()
            nickname_text.text = nickname

            nickname_text.visibility = View.VISIBLE
            btnDone.visibility = View.GONE
            nickname_edit.visibility = View.GONE

            // Hide the keyboard.
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }

        nickname_text.setOnClickListener(){

            nickname_text.visibility = View.GONE
            btnDone.visibility = View.VISIBLE
            nickname_edit.visibility = View.VISIBLE

            nickname_edit.requestFocus()

            // Show the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nickname_edit, 0)
        }
    }
}