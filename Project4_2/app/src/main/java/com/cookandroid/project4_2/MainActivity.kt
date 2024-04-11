package com.cookandroid.project4_2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var text1 : TextView
    private lateinit var text2 : TextView
    private lateinit var chkAgree : CheckBox
    private lateinit var rGroup1 : RadioGroup
    private lateinit var rdoDog : RadioButton
    private lateinit var rdoCat : RadioButton
    private lateinit var rdoRabbit : RadioButton
    private lateinit var btnOK : Button
    private lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        text1 = findViewById(R.id.Text1)
        text2 = findViewById(R.id.Text2)
        chkAgree = findViewById(R.id.ChkAgree)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoDog = findViewById(R.id.RdoDog)
        rdoCat = findViewById(R.id.RdoCat)
        rdoRabbit = findViewById(R.id.RdoRabbit)
        btnOK = findViewById(R.id.BtnOK)
        imgPet = findViewById(R.id.ImgPet)

        btnOK.setOnClickListener {
            when (rGroup1.checkedRadioButtonId) {
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택 하세요.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}