# Android 端 SDK 接入指引

## 1. SDK 引入

### `Gradle` 依赖

1.1 在项目的Gradle下面增加Maven路径：

```groovy
maven {
            url "https://dl.bintray.com/mobisummer/msmaven"
        }
```
在**App**的 `build.gradle` 文件中加入

```groovy
dependencies {
implementation 'com.tecdo.android:mediation:1.0.4.0'
}
```
1.2 mediation-facebook（option）

```groovy
dependencies {
implementation 'com.tecdo.android:mediation_facebook:1.0.4.0'
}
```

1.3 mediation-google（option）

1.3.1 在**App**的 `build.gradle` 文件中加入

```groovy
dependencies {
implementation 'com.tecdo.android:mediation_google:1.0.4.0'
}
```

1.3.2 在**App**的 `Maifest.xml` 加上

```groovy
<meta-data
        android:name="com.google.android.gms.ads.APPLICATION_ID"
        android:value="联系商务获取"/>
```

1.4 mediation-tcash（option）

在**App**的 `build.gradle` 加上

```groovy

dependencies {
implementation 'com.tecdo.android:mediation_tcash:1.0.4.0'
}
```
1.5 mediation_tdshop（option）

```groovy

dependencies {
implementation 'com.tecdo.android:mediation_tdshop:1.0.4.0'
}
```

1.6 mediation_mopub（option）

1.6.1 在**项目**的 `build.gradle` 加上
```groovy

repositories {
        maven { url "https://s3.amazonaws.com/moat-sdk-builds" }
}
```
1.6.1 在**App**的 `build.gradle` 加上
```groovy   
dependencies {
implementation 'com.tecdo.android:mediation_mopub:1.0.4.0'
}
```

1.7 mediation_ironsource（option）

1.7.1 在**项目**的 `build.gradle`加上
```groovy

repositories {
        maven { url "https://dl.bintray.com/ironsource-mobile/android-sdk" }
}
```
1.7.2 在**App**的 `build.gradle` 加上

```groovy
dependencies {
       implementation 'com.tecdo.android:mediation_ironsource:1.0.4.0'
}
```

1.8 mediation_inmobi（option）

在**App**的 `build.gradle` 加上

```groovy
dependencies {
       implementation 'com.tecdo.android:mediation_inmobi:1.0.4.0'
}
```

1.9 mediation_mintegral（option）

在**App**的 `build.gradle` 加上

```groovy
dependencies {
       implementation 'com.tecdo.android:mediation_mintegral:1.0.4.0'
}
```

1.10 mediation_adcolony（option）

在**App**的 `build.gradle` 加上

```groovy
dependencies {
       implementation 'com.tecdo.android:mediation_adcolony:1.0.4.0'
}
```

1.11 mediation_applovin（option）

1.11.1 在**App**的 `build.gradle` 加上

```groovy
dependencies {
       implementation 'com.tecdo.android:mediation_applovin:1.0.4.0'
}
```

1.11.2 在**App**的 `Maifest.xml` 加上

```groovy

<meta-data android:name="applovin.sdk.key"
        android:value="联系商务获取" />
```

1.12 在**App**的 `build.gradle` 加上

```groovy
android {
       compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```


> [版本更新内容及行为变更](docs/update.md)



## 2. 初始化

```java

    MediationConfig config = new MediationConfig(this,"mediation_demo");
    config.isDebugMode = true;
    Mediation.init(config, new IMediationListener() {
      @Override
      public void initialSuccess() {
        Log.d("App","initialSuccess");
      }

      @Override
      public void initialFailure(int code, String msg) {
        Log.d("App","initialFailure:"+msg);
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
    });
    mBannerAd.preload(this);
```


### Ad-插屏广告

```java
    interstitialAd = new Ad(this,"2fab6d7c-67e5-4649-8ab7-366d39e7b6c3");
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

        mAd = new NativeAd(this,"f7189c0e-48d1-4815-837f-8e5770441a17");
        mAd.setNativeAdListener(new INativeAdListener() {
            @Override
            public void onNativeAdAssetsLoaded(NativeAdAssets adAssets) {
                mTitleView.setText(adAssets.getTitle());
                mDescView.setText(adAssets.getDescription());
                btn.setText(adAssets.getCallToAction());
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
```
1、原生广告素材将在onNativeAdAssetsLoaded返回。

2、title、description将一定会返回其余信息可能为空，需要判断再进行相应的布局。

3、NativeAd需要通过registerViewForInteraction()方法绑定相关视图，内部会处理视图的点击跳转事件以及MediaView的加载和IconView的加载。



