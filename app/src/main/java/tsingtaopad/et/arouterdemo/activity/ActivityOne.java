package tsingtaopad.et.arouterdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import tsingtaopad.et.arouterdemo.R;

@Route(path = "/com/ActivityOne")
public class ActivityOne extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        textView = (TextView) findViewById(R.id.tv);
        button = (Button) findViewById(R.id.addFragment);

        //接收参数
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        textView.setText("参数是：" + key);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 普通Fragment路由跳转
                //获取Fragment 实例
                Fragment fragment = (Fragment) ARouter.getInstance().build("/com/FragmentOne").navigation();

                //添加Fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentLayout, fragment);
                fragmentTransaction.commit();
            }
        });
    }
}
