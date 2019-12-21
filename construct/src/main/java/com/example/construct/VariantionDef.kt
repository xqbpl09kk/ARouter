package com.example.construct

object VariantionDef {

    fun getRouteGroup() :String{
        return when (MyApp.INSTANCE.getAppName()){
            IVariant.APP_ONE -> RouterPathDef.GROUP_ONE
            IVariant.APP_TWO -> RouterPathDef.GROUP_TWO
            else -> RouterPathDef.GROUP_MAIN
        }
    }

}

interface IVariant{
    companion object{
        const val APP_ONE = "ONE"
        const val APP_TWO = "TWO"
    }
}