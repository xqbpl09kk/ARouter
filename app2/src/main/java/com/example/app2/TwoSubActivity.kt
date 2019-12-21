package com.example.app2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.construct.RouterPathDef
import com.example.construct.bbb

@Route(path = RouterPathDef.GROUP_TWO + RouterPathDef.PATH_SUB)
class TwoSubActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_just)
        applicationContext.startActivity(Intent(this , DetailActivity::class.java))
       bbb()
    }
}