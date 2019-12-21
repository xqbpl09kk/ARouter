package com.example.construct

import android.os.Parcelable
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import java.io.Serializable

object ARouterManager {

    private val groupName = VariantionDef.getRouteGroup()

    fun route(path :String , params : HashMap<String , Any>? = null){
        generatePostCard(path , params).navigation()
    }



    private fun generatePostCard(path :String ,
                                 params :HashMap<String , Any>? = null)
            :Postcard{
        val postcard = ARouter.getInstance().build(groupName + path)
        params?.forEach {
            val key = it.key
            when(val value = it.value){
                is Int -> postcard.withInt(key ,value)
                is Boolean -> postcard.withBoolean(key ,value)
                is String -> postcard.withString(key ,value)
                is Serializable -> postcard.withSerializable(key , value)
                is Parcelable -> postcard.withParcelable(key ,value)
                else -> postcard.withObject(key , value)
            }
        }
        return postcard !!
    }
}