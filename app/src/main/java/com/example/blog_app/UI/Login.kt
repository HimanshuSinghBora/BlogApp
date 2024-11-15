package com.example.blog_app.UI

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.blog_app.R
import com.example.blog_app.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var pref:SharedPreferences = getSharedPreferences("User", MODE_PRIVATE)
        var email = pref.getString("Email","")
        var password = pref.getString("Password","")
        var edit = pref.edit()
        binding.button.setOnClickListener(View.OnClickListener {
            var mail = binding.editTextTextEmailAddress.text.toString()
            var pass = binding.editTextTextPassword.text.toString()

            if (TextUtils.isEmpty(mail)) {
                binding.editTextTextEmailAddress.setError("Please enter email");
            }
            else if (TextUtils.isEmpty(pass)) {
                binding.editTextTextPassword.setError("Please enter password");
                }
           else {
                if (email == mail && password == pass) {
                    edit.putBoolean("New",false)
                    edit.apply()
                    var intent = Intent(this@Login, BLOG_PAGE::class.java)
                    startActivity(intent)
                }
            }
        })


    }
}