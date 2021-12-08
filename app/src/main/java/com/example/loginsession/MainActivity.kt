package com.example.loginsession

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.app.NotificationCompatSideChannelService

class MainActivity : AppCompatActivity() {
   private    lateinit var etusername :TextView
    private lateinit var etPassword :TextView
     private lateinit var btnLogout : Button
    lateinit var session :Loginpref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        session = Loginpref(this)
        etusername =findViewById(R.id.tw6)
        etPassword =findViewById(R.id.tw7)
        btnLogout = findViewById(R.id.btOut)

        session.checkLogin()

            var user: HashMap<String,String> = session.getUserDetails()
            var userName = user.get(Loginpref.key_username)
            var password = user.get(Loginpref.key_password)
            etusername.setText(userName)
            etPassword.setText(password)
            btnLogout.setOnClickListener {
                session.logoutUser()



        }

    }
}