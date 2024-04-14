package com.cookandroid.project6_1

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cookandroid.project6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "시간 예약"

        binding.timePicker1.visibility = View.INVISIBLE
        binding.calendarView1.visibility = View.INVISIBLE

        binding.rdoCal.setOnClickListener {
            binding.timePicker1.visibility = View.INVISIBLE
            binding.calendarView1.visibility = View.VISIBLE
        }

        binding.rdoTime.setOnClickListener {
            binding.timePicker1.visibility = View.VISIBLE
            binding.calendarView1.visibility = View.INVISIBLE
        }

        binding.btnStart.setOnClickListener {
            binding.chronometer1.base = SystemClock.elapsedRealtime()
            binding.chronometer1.start()
            binding.chronometer1.setTextColor(Color.RED)
        }

        binding.btnEnd.setOnClickListener {
            binding.chronometer1.stop()
            binding.chronometer1.setTextColor(Color.BLUE)

            binding.tvYear.text = Integer.toString(selectYear)
            binding.tvMonth.text = Integer.toString(selectMonth)
            binding.tvDay.text = Integer.toString(selectDay)

            binding.tvHour.text = Integer.toString(binding.timePicker1.currentHour)
            binding.tvMinute.text = Integer.toString(binding.timePicker1.currentMinute)
        }

        binding.calendarView1.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }
    }
}