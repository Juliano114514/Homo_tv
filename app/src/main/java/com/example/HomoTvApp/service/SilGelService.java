package com.example.HomoTvApp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class SilGelService extends Service {
  public SilGelService() {
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void onCreate() {
    super.onCreate();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }

  @Override
  public boolean onUnbind(Intent intent) {
    return super.onUnbind(intent);
  }

  @Override
  public IBinder onBind(Intent intent) {
    return new OttoBinder(this);
  }

  public void wcsndm(){
    Toast.makeText(SilGelService.this,"调用service方法",Toast.LENGTH_SHORT).show();
  }
  public class OttoBinder extends Binder{
    private SilGelService msilGelService = null;
    public OttoBinder(SilGelService silGelService) {
      msilGelService = silGelService;
    }

    public void wcsndm (){
      Toast.makeText(SilGelService.this,"调用binder方法",Toast.LENGTH_SHORT).show();
      msilGelService.wcsndm();
    }
  }
}