package com.tecdo.mediation_demo;

import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tdmediation.android.BannerAd;

import com.tecdo.mediation_common.AdSize;
import com.tecdo.mediation_common.IAdListener;


public class BannerActivity extends AppCompatActivity {

  private BannerAd mBannerAd;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_td_banner_show);
    if (getSupportActionBar() != null) {

      getSupportActionBar().setTitle("BannerAd");
    }
    mBannerAd = findViewById(R.id.v_banner);
    mBannerAd.setADSize(AdSize.BANNER);
//    mBannerAd.setPid("fc18d70b-df89-4d20-96a8-51e070bdcbd4");
    mBannerAd.setPid("e068545a-c05f-46fc-9d6f-dd13b7d69a7b");
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

      @Override
      public void onAdComplete() {
        Log.d("BannerActivity","onAdComplete");
      }
    });
    mBannerAd.preload();
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
