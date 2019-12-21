package com.example.myapplication

import com.example.construct.IVariant
import com.example.construct.MyApp
import com.example.construct.VariantionDef

class OneApp : MyApp() {
    override fun getAppName(): String {
        return IVariant.APP_ONE
    }


}