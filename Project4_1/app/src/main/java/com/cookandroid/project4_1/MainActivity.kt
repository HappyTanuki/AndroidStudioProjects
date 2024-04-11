package com.cookandroid.project4_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    internal var numBtns = ArrayList<Button>(10)
    internal var numBtnIDs = arrayOf(   R.id.numBtn0, R.id.numBtn1, R.id.numBtn2, R.id.numBtn3, R.id.numBtn4,
                                        R.id.numBtn5, R.id.numBtn6, R.id.numBtn7, R.id.numBtn8, R.id.numBtn9   )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        for (i in 0..9 step 1) {
            numBtns[i] = findViewById<Button>(numBtnIDs[i])
        }
    }
}