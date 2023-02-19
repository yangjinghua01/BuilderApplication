package com.example.builderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.builderapplication.navigationbar.NavigationBar;

/**
 * Builder设计模式介绍
 * 又称为建造者模式，将构建过程和表示过程分离（让参数构建过程更加的简单和直观）
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        使用场景，对象构建过程相对来说比较复杂的情况下（参数比较多）
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("title")
                .setIcon(R.drawable.ic_launcher_background)
                .show();
        ViewGroup viewGroup = findViewById(R.id.view_root);
        NavigationBar navigationBar = (NavigationBar) new NavigationBar.Builder(this,R.layout.ui_navigation_bar,viewGroup).setTtile(R.id.back_tv,"back")
                .setBackOnclickListener(R.id.back_tv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "bac", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
    }

}