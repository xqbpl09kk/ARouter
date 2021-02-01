package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.construct.ARouterManager;
import com.example.construct.RouterPathDef;

@Route(path = RouterPathDef.GROUP_ONE + RouterPathDef.PATH_DETAIL)
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findViewById(R.id.oneDetailText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouterManager.INSTANCE.route(RouterPathDef.PATH_SUB , null);
            }
        });

        android.widget.Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }
}
