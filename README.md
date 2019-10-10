# Android 端 SDK 接入指引

## 1. SDK 引入

### `Gradle` 依赖
1. 在项目的Gradle下面增加Maven路径：
```groovy
maven {
            url "https://dl.bintray.com/mobisummer/msmaven"
        }
```
1. 在**App**的 `build.gradle` 文件中加入

```groovy
dependencies {
implementation 'com.tecdo.android:medition:1.0.0'
implementation 'com.tecdo.android:medition_facebook:1.0.0'
implementation 'com.tecdo.android:medition_google:1.0.0'
}
```

> [版本更新内容及行为变更](docs/update.md)



## 2. 初始化

我们提供了两种初始化方式，自动初始化和手动初始化。
> *推荐使用自动初始化，尽早地初始化可以加快商城打开的速度，提升用户体验，提高转化率。*

```java

    MediationConfig config = new MediationConfig();
    config.appId = "YOUR APPID";
    config.appContext = this;
    config.isDebugMode = true;
    Mediation.init(config, new IMediationListener() {
      @Override
      public void initialSuccess() {
        Log.d("App","Mediation initialSuccess");
      }
      @Override
      public void initialFailure(int code, String msg) {
        Log.d("App","Mediation initialFailure:"+msg);
      }
    });
    
```

> **`APP_ID` 请联系商务获取。


## 3. 支持广告类型

目前提供的广告类型有
- 横幅广告 [BannerAd](#BannerAd)
- 插屏广告 [Ad](#Ad-插屏广告)
- 奖励广告 [Ad](#Ad-奖励广告)
- 原生广告 [NativeAd](#NativeAd)

### BannerAd

- **BannerAd支持所有尺寸，并有三种常用尺寸定义**

- BANNER [320x50]
- LARGE_BANNER [320x90]
- RECTANGLE_BANNER [320x250]


1. 在布局文件中添加 `BannerAd`

```xml
<com.tdmediation.android.BannerAd
    android:id="@+id/v_banner"
    android:layout_width="300dp"
    android:layout_height="50dp"
    />

```

2. 在 Java 代码中加载图片

```java

    mBannerAd = findViewById(R.id.v_banner);
    mBannerAd.setADSize(AdSize.BANNER);
    mBannerAd.setPid("69898a73-35f7-430c-b2f1-c616d44407ec");
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
    mBannerAd.preload();
```


### Ad-插屏广告

```java
    interstitialAd = new Ad(this,"cb2a4933-3345-40f9-b6a5-54369a5a3a40");
    interstitialAd.setAdListener(new IAdListener() {
      @Override
      public void onAdLoaded() {
        Log.d("interstitialAd","onAdLoaded");
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

    findViewById(R.id.btn_interstitial_load).setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
             nterstitialAd.preload();
        }
    });

    findViewById(R.id.btn_interstitial_show).setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            interstitialAd.show(MainActivity.this);
        }
    });
```
每一次show之前都需要先进行preload()，在收到onAdLoaded回调之后调用show()方法就可以

### Ad-奖励广告

```java
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
      @Override
      public void onAdComplete(){
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
    
```

1.每一次show之前都需要先进行preload()，在收到onAdLoaded回调之后调用show()方法就可以。

2.如果视频全部播放完可获得奖励。将在onAdComplete进行回调。

### NativeAd


```java
        mTitleView = findViewById(R.id.textView_title);
        mDescView = findViewById(R.id.textView_desc);
        mMediaView = findViewById(R.id.mediaView);
        mIconView = findViewById(R.id.iconView);
        final Button btn = findViewById(R.id.btn_CTR);

        final LinearLayout layout = findViewById(R.id.layout_super);

        mAd = new NativeAd(this,"1e57c30b-af10-4cb3-8674-b6f19c157027");
        mAd.setNativeAdListener(new INativeAdListener() {
            @Override
            public void onNativeAdAssetsLoaded(NativeAdAssets adAssets) {
                mTitleView.setText(adAssets.getTitle());
                mDescView.setText(adAssets.getDescription());
                btn.setText(adAssets.getCallToAction());
                Map<String,View> views = new HashMap<>();
                views.put(NativeAd.KEY_NATIVE_VIEW_DESC,mDescView);
                views.put(NativeAd.KEY_NATIVE_VIEW_TITLE,mTitleView);
                views.put(NativeAd.KEY_NATIVE_VIEW_CALL_TO_ACTION,btn);

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
```
1、原生广告素材将在onNativeAdAssetsLoaded返回。

2、title、description将一定会返回其余信息可能为空，需要判断再进行相应的布局。

3、NativeAd需要通过registerViewForInteraction()方法绑定相关视图，内部会处理视图的点击跳转事件以及MediaView的加载和IconView的加载。



