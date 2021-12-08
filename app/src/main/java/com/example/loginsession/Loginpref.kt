package com.example.loginsession

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class Loginpref {
     lateinit var pref :SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit  var con : Context
    var PRIVATEMODE: Int = 0
    constructor(con: Context)
    {
    this.con= con
        pref = con.getSharedPreferences(Pref_name,PRIVATEMODE)
        editor =pref.edit()
    }
    companion object{
        var Pref_name ="Login_Preferences"
        var is_login ="isLoggedIn"
        var key_username ="username"
        var key_password ="password"

    }
    fun creatLoginSession(username:String,password:String){
        editor.putBoolean(is_login,true)
        editor.putString(key_username,username)
        editor.putString(key_password,password)
        editor.commit()

    }
    fun checkLogin(){
        if(!this.isLoggedIn()) {
            var i: Intent = Intent(con, LoginActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(i)
        }

        }
        fun getUserDetails() : HashMap<String, String>{
            var user : Map<String, String> = HashMap<String,String>()
            (user as HashMap).put(key_username,pref.getString(key_username,null)!!)
            (user as HashMap).put(key_password,pref.getString(key_password,null)!!)
            return user

        }
        fun logoutUser(){
            editor.clear()
            editor.commit()
            var i : Intent = Intent(con,LoginActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(i)
        }
        fun isLoggedIn():Boolean{
          return pref.getBoolean(is_login,false)
        }



}