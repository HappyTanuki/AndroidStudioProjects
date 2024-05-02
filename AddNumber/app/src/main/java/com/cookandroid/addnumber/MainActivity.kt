package com.cookandroid.addnumber

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cookandroid.addnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK){
                Toast.makeText(applicationContext,
                    it.data?.getStringExtra("return") ?: "", Toast.LENGTH_SHORT).show()
            }
        }

        mBinding.button.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            val n = arrayOf(Integer.parseInt(mBinding.editTextText.text.toString()),
                Integer.parseInt(mBinding.editTextText2.text.toString()))
            intent.putExtra("N", n)
            activityResultLauncher.launch(intent)
        }
    }
}