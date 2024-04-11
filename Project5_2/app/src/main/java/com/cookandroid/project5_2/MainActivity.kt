package com.cookandroid.project5_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var NumBtn = ArrayList<Button>(10)
    var NumBtnIDs = arrayOf( R.id.numBtn0, R.id.numBtn1, R.id.numBtn2, R.id.numBtn3, R.id.numBtn4,
                             R.id.numBtn5, R.id.numBtn6, R.id.numBtn7, R.id.numBtn8, R.id.numBtn9,)
    lateinit var EditI1 : EditText
    lateinit var EditI2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        EditI1 = findViewById(R.id.EditI1)
        EditI2 = findViewById(R.id.EditI2)

        var focusedTextField : EditText;

        for (i in 0..9 step 1) {
            NumBtn.add(findViewById(NumBtnIDs[i]))

            NumBtn[i].setOnClickListener {
                if (EditI1.isFocused()) {
                    focusedTextField = EditI1
                }
                else if (EditI2.isFocused()) {
                    focusedTextField = EditI2
                }
                else {
                    return@setOnClickListener
                }
                if (it.id == NumBtnIDs[i]) {
                    focusedTextField.setText(focusedTextField.text.toString() + i.toString())
                    Toast.makeText(this@MainActivity, "$i 클릭됨!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}