package tsingtaopad.et.arouterdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import tsingtaopad.et.arouterdemo.R;

/**
 * Created by yangwenmin on 2018/7/30.
 */
@Route(path = "/com/FragmentTwo")
public class FragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view ;
    }
}