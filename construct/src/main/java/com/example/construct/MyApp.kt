package com.example.construct

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

abstract class MyApp : Application(){

    companion object{
        lateinit var INSTANCE : MyApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        appCxt = this
        initARouter()
    }

    private fun initARouter(){
        if(BuildConfig.DEBUG){
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }

    abstract fun getAppName() :String
}