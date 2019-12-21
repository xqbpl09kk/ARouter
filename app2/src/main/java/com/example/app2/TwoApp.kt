package com.example.app2

import com.example.construct.IVariant
import com.example.construct.MyApp
import com.example.construct.VariantionDef

class TwoApp : MyApp() {


    override fun getAppName(): String {
        return IVariant.APP_TWO
    }


}