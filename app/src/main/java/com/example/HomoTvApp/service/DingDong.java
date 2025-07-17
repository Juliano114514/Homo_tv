package com.example.HomoTvApp.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import com.example.HomoTvApp.R;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class DingDong extends Service {

  @SuppressLint("ForegroundServiceType")
  @Override
  public void onCreate() {
    super.onCreate();
    Toast.makeText(this,"楼上的下来搞核酸",Toast.LENGTH_SHORT).show();

    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
      NotificationChannel channel = new NotificationChannel("gao_he_suan","通知",NotificationManager.IMPORTANCE_DEFAULT);
      notificationManager.createNotificationChannel(channel);
    }

    Notification notification = new NotificationCompat.Builder(this,"gao_he_suan")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("楼上的下来搞核酸")
        .setContentText("叮咚鸡")
        .build();
    startForeground(1,notification);
  }

  @Override
  public IBinder onBind(Intent intent) {
    return new DingdongBinder(this);
  }
  public class DingdongBinder extends Binder{
    private DingDong mdingdongService = null;
    public DingdongBinder(DingDong dingdong) {
      mdingdongService = dingdong;
    }

  }
}