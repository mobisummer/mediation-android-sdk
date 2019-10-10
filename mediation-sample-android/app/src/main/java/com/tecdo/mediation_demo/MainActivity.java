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

    interstitialAd = new Ad(this,"2fab6d7c-67e5-4649-8ab7-366d39e7b6c3");
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
            interstitialAd.destroy();
              interstitialAd.preload();
          }
      });

      findViewById(R.id.btn_interstitial_show).setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
              interstitialAd.show(MainActivity.this);
          }
      });

    rewardVideoAd = new Ad(this,"9d19d8d5-5555-4d71-b83c-106df16cf62f");
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
        rewardVideoAd.destroy();
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
