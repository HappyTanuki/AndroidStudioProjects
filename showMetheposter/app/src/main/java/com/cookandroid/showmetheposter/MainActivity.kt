package com.cookandroid.showmetheposter

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cookandroid.showmetheposter.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner : Spinner = binding.spinner1
        val adapter : ArrayAdapter<String>
        val movies = arrayOf("선택하세요", "명량", "기생충", "짱구 극장판", "T4")
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movies)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val imageview: ImageView = binding.imageView
                when (movies[p2]) {
                    "명량" ->
                        imageview.setImageResource(R.drawable.sea)
                    "기생충" ->
                        imageview.setImageResource(R.drawable.parasite)
                    "짱구 극장판" ->
                        imageview.setImageResource(R.drawable.jjang)
                    else ->
                        imageview.setImageResource(0)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                return
            }
        }
        spinner.adapter = adapter
    }
}