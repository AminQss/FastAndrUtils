package com.hotapk.fastandrutils;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.hotapk.fastandrutils.baseadapter.AutoRVAdapter;
import com.hotapk.fastandrutils.baseadapter.RecViewHolder;
import com.hotapk.fastandrutils.bean.TitleInfor;

import java.util.ArrayList;
import java.util.List;

import cn.hotapk.fastandrutils.utils.FLogUtils;
import cn.hotapk.fastandrutils.utils.FPermissionUtils;

/**
 * @author laijian
 * @version 2017/11/2
 * @Copyright (C)下午3:24 , www.hotapk.cn
 */
public class FMainActivity extends FBaseActivity {

    private RecyclerView recyclerview;
    private List<TitleInfor> titleInfors = new ArrayList<>();
    private AutoRVAdapter<TitleInfor> autoRVAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        setData();
        setAutoRVAdapter();

        FPermissionUtils.requestPermissions(this, 200, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE}, new FPermissionUtils.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {

            }

            @Override
            public void onPermissionDenied(String[] deniedPermissions) {

            }

            @Override
            public void manifestUnPermission(String[] unpermission) {

            }
        });
        TitleInfor s = new TitleInfor("s");
        FLogUtils.getInstance().e(s);
    }

    private void setData() {
        titleInfors.add(new TitleInfor("获取app应用相关信息"));
        titleInfors.add(new TitleInfor("获取assets的内容"));
        titleInfors.add(new TitleInfor("清除app缓存"));
        titleInfors.add(new TitleInfor("防止过快点击"));
        titleInfors.add(new TitleInfor("数据转换类"));
        titleInfors.add(new TitleInfor("设备信息类"));
        titleInfors.add(new TitleInfor("Toast显示"));
        titleInfors.add(new TitleInfor("软键盘结合EditText"));
        titleInfors.add(new TitleInfor("沉浸式状态栏"));
        titleInfors.add(new TitleInfor("权限申请"));
        titleInfors.add(new TitleInfor("log日志"));
        titleInfors.add(new TitleInfor("异常退出crash"));
        titleInfors.add(new TitleInfor("时间操作"));
        titleInfors.add(new TitleInfor("简单数据校验相关"));
        titleInfors.add(new TitleInfor("图片相关"));
        titleInfors.add(new TitleInfor("网络相关"));
    }

    private void setAutoRVAdapter() {
        autoRVAdapter = new AutoRVAdapter<TitleInfor>(this, titleInfors) {
            @Override
            public int setLayoutid(int position) {
                return R.layout.title_item;
            }

            @Override
            public void onBindViewHolder(RecViewHolder holder, int position, TitleInfor item) {
                holder.setTextView(R.id.item_tv, item.getTitleName());

            }
        };
        autoRVAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                setOnItemClick(position);
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(autoRVAdapter);
    }


    private void setOnItemClick(int position) {
        Intent intent = null;
        if (position == 0) {
            intent = new Intent(this, FAppInforActivity.class);
        } else if (position == 1) {
            intent = new Intent(this, FReadAssetsActivity.class);
        } else if (position == 2) {
            intent = new Intent(this, FCleanCacheActivity.class);
        } else if (position == 3) {
            intent = new Intent(this, FCheckDoubleClickActivity.class);
        } else if (position == 4) {
            intent = new Intent(this, FConvertActivity.class);
        } else if (position == 5) {
            intent = new Intent(this, FDeviceActivity.class);
        } else if (position == 6) {
            intent = new Intent(this, FToastActivity.class);
        } else if (position == 7) {
            intent = new Intent(this, FKeyBoradActivity.class);
        } else if (position == 8) {
            intent = new Intent(this, FStatusBarActivity.class);
        } else if (position == 9) {
            intent = new Intent(this, FPermissionActivity.class);
        } else if (position == 10) {
            intent = new Intent(this, FLogActivity.class);
        } else if (position == 11) {
        } else if (position == 12) {
            intent = new Intent(this, FDateActivity.class);
        } else if (position == 13) {
            intent = new Intent(this, FValidatorActivity.class);
        } else if (position == 14) {
            intent = new Intent(this, FImageActivity.class);
        } else if (position == 15) {
            intent = new Intent(this, FNetworkActivity.class);
        }
        startActivity(intent);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        FPermissionUtils.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
