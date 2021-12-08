package com.example.loginsession

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var eName : EditText
    private lateinit var ePass : EditText
    private  lateinit var btnLog : Button
    lateinit var session :Loginpref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        session = Loginpref(this)
        if(session.isLoggedIn()){
            var i : Intent = Intent(applicationContext,MainActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }
       eName =findViewById(R.id.ePer)
        ePass =findViewById(R.id.eTv2)
        btnLog =findViewById(R.id.btCli)


        btnLog.setOnClickListener {
            var usename =  eName.text.toString().trim()
            var password = ePass.text.toString().trim()
            if(usename.isEmpty()&&password.isEmpty()){
                Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show()
            }
            else{

                session.creatLoginSession(usename,password)
                var i :Intent =Intent(applicationContext,MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }



    }
}