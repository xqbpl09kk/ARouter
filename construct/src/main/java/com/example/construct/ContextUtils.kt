package com.example.construct

import android.content.Context
import android.content.Intent
import java.lang.Exception

lateinit var appCxt : Context

fun Context.startActivity(intent : Intent){
    throw Exception("You cannot start!!!!!!!!!!!")
}