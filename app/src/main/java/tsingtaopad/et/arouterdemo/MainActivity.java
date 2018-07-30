package tsingtaopad.et.arouterdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/com/MainActivity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(this); //普通Activity路由跳转
        findViewById(R.id.bt2).setOnClickListener(this);// 实现像 startActivityForResult（） 功能，使用  navigation(Activity mContext, int requestCode)
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        findViewById(R.id.bt6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1://普通Activity路由跳转
                ARouter.getInstance().build("/com/ActivityOne").navigation();
                break;
            case R.id.bt2:// 实现像 startActivityForResult（） 功能，使用  navigation(Activity mContext, int requestCode)
                ARouter.getInstance()
                        .build("/com/ActivityTwo")
                        .navigation(this, 100);
                break;

            case R.id.bt4://

                break;
            case R.id.bt5://

                break;
            case R.id.bt6://

                break;
        }
    }
}
