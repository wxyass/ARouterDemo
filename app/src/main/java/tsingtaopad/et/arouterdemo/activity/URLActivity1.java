package tsingtaopad.et.arouterdemo.activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import tsingtaopad.et.arouterdemo.R;

/**
 * URL 中转Activity
 */

@Route(path = "/com/URLActivity1")
public class URLActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url1);
    }
}
