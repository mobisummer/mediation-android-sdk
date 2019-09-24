package com.tecdo.mediation_demo;

import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tdmediation.android.AdSize;
import com.tdmediation.android.BannerAd;
import com.tdmediation.android.IAdListener;



public class BannerActivity extends AppCompatActivity {

  private BannerAd mBannerAd;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_td_banner_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDBannerView");
    }
    mBannerAd = findViewById(R.id.v_banner);
    mBannerAd.setADSize(AdSize.BANNER);
    mBannerAd.setPid("69898a73-35f7-430c-b2f1-c616d44407ec");
    mBannerAd.preload();
    mBannerAd.setAdListener(new IAdListener() {
      @Override
      public void onAdLoaded() {
        Log.d("BannerActivity","onAdLoaded");
      }

      @Override
      public void onAdError(String msg) {
        Log.d("BannerActivity","onAdError:"+msg);
      }

      @Override
      public void onAdShow() {
        Log.d("BannerActivity","onAdShow");
      }

      @Override
      public void onAdClick() {
        Log.d("BannerActivity","onAdClick");
      }

      @Override
      public void onAdClose() {
        Log.d("BannerActivity","onAdClose");
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    getActionBar();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mBannerAd.destroy();
  }
}
