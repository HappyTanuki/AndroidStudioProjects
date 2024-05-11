package com.example.movielistview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movielistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mbin : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbin.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        class MyAdapter : BaseAdapter() {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val movietitle = arrayOf("명량", "기생충", "짱구 극장판", "T4")
                val movie_thumbnail_id = arrayOf(R.drawable.sea, R.drawable.parasite, R.drawable.jjang, 0)
                var view = convertView

                if (view == null) {
                    val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    view = inflater.inflate(R.layout.listview_element, parent, false)
                    val movie_thumbnail = view?.findViewById(R.id.movie_thumbnail) as ImageView
                    val movie_title = view?.findViewById(R.id.movie_title) as TextView
                    val movie_desciption = view?.findViewById(R.id.movie_description) as TextView

                    movie_thumbnail.setImageResource(movie_thumbnail_id[position])
                    movie_title.setText(movietitle[position])
                    movie_desciption.setText(movietitle[position])
                }

                return view
            }
            override fun getCount(): Int {
                return 3
            }
            override fun getItem(position: Int): Any {
                return 0
            }
            override fun getItemId(position: Int): Long {
                return 0
            }
        }
        val adapter : MyAdapter = MyAdapter()
        mbin.movieList.adapter = adapter
    }
}