package com.example.construct

import android.app.Activity
import android.content.Context
import android.content.Intent
import java.lang.Exception

lateinit var appCxt : Context

fun Activity.startActivity(intent : Intent){
    throw Exception("You cannot start!!!!!!!!!!!")
}
fun Context.bbb(){

}