package com.tecdo.mediation_demo;

import android.app.Application;
import android.util.Log;

import com.tdmediation.android.AdSetting;
import com.tdmediation.android.IMediationListener;
import com.tdmediation.android.Mediation;
import com.tdmediation.android.MediationConfig;


/**
 * App class.
 *
 * @author Lucas Cheung.
 * @date 2019-06-29.
 */
public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();


    MediationConfig config = new MediationConfig();
    config.appId = "mediation_demo";
    config.appContext = this;
    config.isDebugMode = true;
//    AdSetting.addTestDevice("1E2FB1EC9AF4599C8816321C0BE7F829",AdSetting.AD_SDK_PLATFORM_GOOGLE);
        AdSetting.addTestDevice("da968250-3f3e-4ecb-9964-121533c1c539",AdSetting.AD_SDK_PLATFORM_FACEBOOK);
//    AdSetting.setGaTestDevice("B017F5D3A7AC576372DAF1060D4FE4C4");
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
  }
}
