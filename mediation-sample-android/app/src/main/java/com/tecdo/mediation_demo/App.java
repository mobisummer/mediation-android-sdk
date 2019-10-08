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
//    config.appId = "mediation_demo";
    config.appId = "2cc0add8-ccb0-48b3-91af-c4feb8d9b253";
    config.appContext = this;
    config.isDebugMode = true;
    AdSetting.addTestDevice("0a183b5a-e657-447b-b341-b1448f5af0e7",AdSetting.AD_SDK_PLATFORM_FACEBOOK);
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
