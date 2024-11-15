package com.example.blog_app.UI

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blog_app.Services.ApiCall
import com.example.blog_app.Data.BlogData
import com.example.blog_app.Adapters.MyAdapter
import com.example.blog_app.R
import com.example.blog_app.databinding.ActivityBlogPageBinding

class BLOG_PAGE : AppCompatActivity() {
    var data:List<BlogData> = listOf()
    private lateinit var binding: ActivityBlogPageBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBlogPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(this)
        ApiCall().getBlog(this) { blogs ->
            data = listOf(blogs)
        }
        val adapter = MyAdapter(data)
        recyclerview.adapter = adapter
    }
}