package com.example.construct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouterPathDef.GROUP_MAIN + RouterPathDef.PATH_MAIN)
open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener {
            ARouterManager.route(RouterPathDef.PATH_DETAIL)
        }

    }
}
