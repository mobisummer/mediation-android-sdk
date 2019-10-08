package com.tecdo.mediation_demo;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.tdmediation.android.Ad;

import com.tecdo.mediation_common.IAdListener;


public class MainActivity extends AppCompatActivity {


  private Ad interstitialAd;
  private Ad rewardVideoAd;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    interstitialAd = new Ad(this,"8f43f46a-d409-4cc5-86fe-7678992a438f");
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

      @Override
      public void onAdComplete() {
        Log.d("interstitialAd","onAdComplete");
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

    rewardVideoAd = new Ad(this,"0c699734-05bf-4445-813a-4c018767e80f");
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
      @Override
      public void onAdComplete() {
        Log.d("rewardVideoAd","onAdComplete");
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
