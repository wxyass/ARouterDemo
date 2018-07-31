package tsingtaopad.et.arouterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import tsingtaopad.et.arouterdemo.service.IService;

@Route(path = "/com/MainActivity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Autowired(name = "/service/hello")
    IService service;

    @Autowired(name = "/service/hello2")
    IService service2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(this); //普通Activity路由跳转
        findViewById(R.id.bt2).setOnClickListener(this);// 实现像 startActivityForResult（） 功能，使用  navigation(Activity mContext, int requestCode)
        findViewById(R.id.bt4).setOnClickListener(this);// 监听路由过程
        findViewById(R.id.bt5).setOnClickListener(this);// 发起路由并且传递参数
        findViewById(R.id.bt6).setOnClickListener(this);// 原始分组
        findViewById(R.id.bt7).setOnClickListener(this);// 自定义分组
        findViewById(R.id.bt8).setOnClickListener(this);// 加载本地html
        findViewById(R.id.bt9).setOnClickListener(this);// 暴露服务
        findViewById(R.id.bt10).setOnClickListener(this);// 暴露服务
        findViewById(R.id.bt11).setOnClickListener(this);//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1://普通Activity路由跳转
                ARouter.getInstance().build("/com/ActivityOne").navigation();
                break;
            case R.id.bt2:// 实现像 startActivityForResult（） 功能，使用  navigation(Activity mContext, int requestCode)
                ARouter.getInstance()
                        .build("/com/ActivityOne")
                        .navigation(this, 100);
                break;

            case R.id.bt4:// 监听路由过程
                ARouter.getInstance()
                        .build("/com/ActivityOne")
                        .navigation(this, new NavCallback() {

                            @Override
                            public void onFound(Postcard postcard) {
                                Log.e("zhao", "onArrival: 找到了 ");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.e("zhao", "onArrival: 找不到了 ");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.e("zhao", "onArrival: 跳转完了 ");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("zhao", "onArrival: 被拦截了 ");
                            }
                        });

                break;
            case R.id.bt5:// 发起路由并且传递参数
                ARouter.getInstance()
                        .build("/com/ActivityOne")
                        .withString("key", "123")  //参数：键：key 值：123
                        .navigation();
                break;
            case R.id.bt6:// 原始分组
                ARouter.getInstance()
                        .build("/com/ActivityOne")
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {
                                String group = postcard.getGroup();
                                Log.e("zhao", "分组是: " + group);
                            }
                        });
                break;
            case R.id.bt7:// 自定义分组
                ARouter.getInstance()
                        .build("/com/CustomGroupActivity", "customGroup")
                        .navigation();
                break;
            case R.id.bt8:// 加载本地html
                ARouter.getInstance().build("/com/WebActivity").navigation();
                break;
            case R.id.bt9:// 暴露服务
                ARouter.getInstance().inject(this);
                service.sayHello(this);
                break;
            case R.id.bt10:// 暴露服务
                ARouter.getInstance().inject(this);
                service2.sayHello(this);
                break;
            case R.id.bt11://

                break;
        }
    }
}
