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
