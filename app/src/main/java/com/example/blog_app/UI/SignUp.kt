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
import com.example.blog_app.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var pref: SharedPreferences = getSharedPreferences("User", MODE_PRIVATE)
        var email = binding.editTextTextEmailAddress.text
        var password = binding.editTextTextPassword.text
        var user = binding.editTextText.text
        var edit = pref.edit()
        binding.button.setOnClickListener(View.OnClickListener {
            var mail = binding.editTextTextEmailAddress.text.toString()
            var pass = binding.editTextTextPassword.text.toString()
            var name = binding.editTextText.text.toString()
            if (TextUtils.isEmpty(mail)) {
                binding.editTextTextEmailAddress.setError("Please enter email");
            }
            else if (TextUtils.isEmpty(pass)) {
                binding.editTextTextPassword.setError("Please enter password");
            }
            else if (TextUtils.isEmpty(name)) {
                binding.editTextTextPassword.setError("Please enter username");
            }
            else {
                edit.putBoolean("User",true)
                edit.putString("Username",user.toString())
                edit.putString("Email", email.toString())
                edit.putString("Password", password.toString())
                edit.apply()
                var intent = Intent(this@SignUp, Login::class.java)
                startActivity(intent)
            }
        })

    }
}