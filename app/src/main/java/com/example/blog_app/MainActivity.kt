package com.example.blog_app

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.blog_app.UI.BLOG_PAGE
import com.example.blog_app.UI.Login
import com.example.blog_app.UI.SignUp
import com.example.blog_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var pref: SharedPreferences = getSharedPreferences("User", MODE_PRIVATE)
        var new = pref.getBoolean("New",true)
        var user = pref.getBoolean("User",false)
        Handler().postDelayed({
            if(new) {
                if (!user) {
                    val iNext: Intent
                    iNext = Intent(this@MainActivity, SignUp::class.java)
                    startActivity(iNext)
                }
                else{
                    val iNext: Intent
                    iNext = Intent(this@MainActivity, Login::class.java)
                    startActivity(iNext)
                }
            }
            else{
                val iNext: Intent
                iNext = Intent(this@MainActivity, BLOG_PAGE::class.java)
                startActivity(iNext)
            }
    }, 3000)
    }
}