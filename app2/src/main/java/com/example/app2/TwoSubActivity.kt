package com.example.app2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.construct.RouterPathDef

@Route(path = RouterPathDef.GROUP_TWO + RouterPathDef.PATH_SUB)
class TwoSubActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }
}