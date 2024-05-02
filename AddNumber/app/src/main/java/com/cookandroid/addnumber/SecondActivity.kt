package com.cookandroid.addnumber

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cookandroid.addnumber.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(sBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sBinding.button3.setOnClickListener {
            var intent = intent
            var n = intent.getIntArrayExtra("N")
            intent.putExtra("return", (n!![0] + n!![1]).toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}