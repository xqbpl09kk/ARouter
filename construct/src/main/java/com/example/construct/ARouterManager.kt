package com.example.construct

import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import java.io.Serializable

object ARouterManager {

    private val currentGroup = VariantionDef.getRouteGroup()
    private const val groupMain = RouterPathDef.GROUP_MAIN
    private const val TAG = "ARouterManager"

    fun route(path :String , params : HashMap<String , Any>? = null){
        val result =  generatePostCard(path , params).navigation(appCxt ,
            object : NavigationCallback {
            override fun onLost(postcard: Postcard?) {
                Log.e(TAG , "onLost")
                if(BuildConfig.DEBUG){
                    Toast.makeText(appCxt , "No Route Found in app , switching to main group" , Toast.LENGTH_SHORT).show()
                }
                routeMainGroup(path , params )
            }

            override fun onFound(postcard: Postcard?) {
                Log.e(TAG , "onFound")
            }

            override fun onInterrupt(postcard: Postcard?) {
                Log.e(TAG , "onInterrupt")
            }

            override fun onArrival(postcard: Postcard?) {
                Log.e(TAG ,"onArrival")
            }
        })
        Log.e(TAG , "result = $result")
    }

    private fun routeMainGroup(path :String , params : HashMap<String , Any>? = null){
        generatePostCard(path  , params , true).navigation()
    }

    private fun generatePostCard(path :String  ,
                                 params :HashMap<String , Any>? = null,
                                 toMain : Boolean = false):Postcard{
        val routePath = if(path.contains(groupMain) || path.contains(currentGroup)){
            path
        }else (if(toMain) groupMain else currentGroup).plus(path)
        val postcard = ARouter.getInstance().build(routePath)
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