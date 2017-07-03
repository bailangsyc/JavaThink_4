package com.example.shao.javathink_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 这个project主要是用来练习java基础的，通过JavaLibrary来练习java编程思想4
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        //A类（MainActivity）调用B（View）类中的方法
        btn.setOnClickListener(this);
    }

    @Override
    /**
     * 回调就是：A 调用B类的方法C，然后B类中再调用A中的D，A中的方法D就是回调方法
     * android中给按钮添加点击监听事件，就是典型的回调
     *  1：MainActivity实现了View.OnClickListener接口，所以它必须实现接口中的onClick(), 在MainActivity中调用View的setOnClickListener(this)就是A中调用B中的方法，将自己传给view
     *  2.在View中performClick()，调用MainActvity中的onClick（）方法   这就是然后B类中再调用A中的D
     * 回调方法
     */
    public void onClick(View v) {
        Toast.makeText(this, "onClick()",Toast.LENGTH_LONG).show();
    }
}
