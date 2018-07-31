package tsingtaopad.et.arouterdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by yangwenmin on 2018/7/30.
 */

public class MyApplication extends Application {

    //  ARouter 调试开关
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();

        if (isDebugARouter) {
            // 下面两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();// 打印日志
            ARouter.openDebug();// 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！ 线上版本需要关闭,否则有安全风险)
        }

        // 官方建议推荐在Application中初始化
        ARouter.init( MyApplication.this );
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // ARouter释放解绑资源
        ARouter.getInstance().destroy();
    }
}
