package com.tecdo.mediation_demo;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.tdmediation.android.Ad;
import com.tdmediation.android.IAdListener;



public class MainActivity extends AppCompatActivity {


  private Ad interstitialAd;
  private Ad rewardVideoAd;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    interstitialAd = new Ad(this,"cb2a4933-3345-40f9-b6a5-54369a5a3a40");
    interstitialAd.setAdListener(new IAdListener() {
      @Override
      public void onAdLoaded() {
        Log.d("MainActivity","onAdLoaded");
      }

      @Override
      public void onAdError(String msg) {
        Log.d("interstitialAd","onAdError:"+msg);
      }

      @Override
      public void onAdShow() {
        Log.d("interstitialAd","onAdShow");
      }

      @Override
      public void onAdClick() {
        Log.d("interstitialAd","onAdClick");
      }

      @Override
      public void onAdClose() {
        Log.d("interstitialAd","onAdClose");
      }
    });

    rewardVideoAd = new Ad(this,"5fecf474-376d-4612-837d-78325b94a62f");
    rewardVideoAd.setAdListener(new IAdListener() {
      @Override
      public void onAdLoaded() {
        Log.d("rewardVideoAd","onAdLoaded");
      }

      @Override
      public void onAdError(String msg) {
        Log.d("rewardVideoAd","onAdError:"+msg);
      }

      @Override
      public void onAdShow() {
        Log.d("rewardVideoAd","onAdShow");
      }

      @Override
      public void onAdClick() {
        Log.d("rewardVideoAd","onAdClick");
      }

      @Override
      public void onAdClose() {
        Log.d("rewardVideoAd","onAdClose");
      }
    });

    findViewById(R.id.btn_interstitial_load).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        interstitialAd.preload();
      }
    });

    findViewById(R.id.btn_interstitial_show).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        interstitialAd.show(MainActivity.this);
      }
    });

    findViewById(R.id.btn_video_load).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        rewardVideoAd.preload();
      }
    });

    findViewById(R.id.btn_video_show).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        rewardVideoAd.show(MainActivity.this);
      }
    });

    findViewById(R.id.btn_banner).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        navigateTo(BannerActivity.class);
      }
    });

    findViewById(R.id.btn_native).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        navigateTo(NativeActivity.class);
      }
    });

  }

  public void navigateTo(Class<?> clazz) {
    Intent intent = new Intent(this, clazz);
    startActivity(intent);
  }
}
