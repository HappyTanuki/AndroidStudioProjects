package com.cookandroid.addnumber

import android.content.Intent
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
            var n1 = intent.getIntExtra("N1", 0)
            var n2 = intent.getIntExtra("N2", 0)
            when (intent.getStringExtra("op")) {
                "+" -> intent.putExtra("return", (n1 + n2).toString())
                "-" -> intent.putExtra("return", (n1 - n2).toString())
                "*" -> intent.putExtra("return", (n1 * n2).toString())
                "/" -> intent.putExtra("return", (n1 / n2).toString())
            }
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}