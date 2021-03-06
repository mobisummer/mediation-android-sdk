package com.tecdo.mediation_demo;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tdmediation.android.NativeAd;

import com.tecdo.mediation_common.INativeAdListener;
import com.tecdo.mediation_common.NativeAdAssets;
import com.tecdo.mediation_common.NativeAdMediaView;


import java.util.HashMap;
import java.util.Map;

public class NativeActivity extends AppCompatActivity {

    private TextView mTitleView;
    private TextView mDescView;
    private NativeAdMediaView mMediaView;
    private NativeAdMediaView mIconView;
    private NativeAd mAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_native);

        mTitleView = findViewById(R.id.textView_title);
        mDescView = findViewById(R.id.textView_desc);
        mMediaView = findViewById(R.id.mediaView);
        mIconView = findViewById(R.id.iconView);
        final Button btn = findViewById(R.id.btn_CTR);

        final LinearLayout layout = findViewById(R.id.layout_super);

        mAd = new NativeAd(this,"f7189c0e-48d1-4815-837f-8e5770441a17");
        mAd.setNativeAdListener(new INativeAdListener() {
            @Override
            public void onNativeAdAssetsLoaded(NativeAdAssets adAssets) {
                mTitleView.setText(adAssets.getTitle());
                mDescView.setText(adAssets.getDescription());
                btn.setText(adAssets.getCallToAction());
                if (adAssets.getIcon() == null){
                    ViewGroup parent = (ViewGroup)mIconView.getParent();
                    parent.removeView(mIconView);
                }
                Map<String,View> views = new HashMap<>();
                views.put(NativeAdAssets.KEY_NATIVE_VIEW_DESC,mDescView);
                views.put(NativeAdAssets.KEY_NATIVE_VIEW_TITLE,mTitleView);
                views.put(NativeAdAssets.KEY_NATIVE_VIEW_CALL_TO_ACTION,btn);
                mAd.registerViewForInteraction(layout,mMediaView,mIconView,views);
                btn.setVisibility(adAssets.getCallToAction()!=null?View.VISIBLE:View.GONE);
                Log.d("NativeAd","onNativeAdAssetsLoaded");
            }

            @Override
            public void onNativeAdError(String msg) {
                Log.d("NativeAd","onAdError:"+msg);
            }

            @Override
            public void onNativeAdShow() {
                Log.d("NativeAd","onNativeAdShow");
            }
        });
        mAd.preload();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getActionBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
