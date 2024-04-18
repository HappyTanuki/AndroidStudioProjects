package com.cookandroid.project10_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cookandroid.project10_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.voteEnd.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }

        var images = arrayOf(
            R.id.imageView10, R.id.imageView11, R.id.imageView12,
            R.id.imageView13, R.id.imageView14, R.id.imageView15,
            R.id.imageView16, R.id.imageView17, R.id.imageView18, )

        for (item in images.indices) {
        }
    }
}