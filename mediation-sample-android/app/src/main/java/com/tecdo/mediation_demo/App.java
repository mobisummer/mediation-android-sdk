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
    config.appId = "8eb19e1c-678a-4c3d-a60e-7ac406ffbd3e";
    config.appContext = this;
    config.isDebugMode = true;
    AdSetting.setTestDevice("17807a5a-9c2e-4d99-9c1d-5c63830e1848");
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
