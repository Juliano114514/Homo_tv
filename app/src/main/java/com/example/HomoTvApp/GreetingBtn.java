package com.example.HomoTvApp;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.ServiceConnection;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.IBinder;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import com.example.HomoTvApp.service.SilGelService;


public class GreetingBtn extends AppCompatActivity implements View.OnClickListener{

  private SilGelService.OttoBinder ottoBinder = null;
  private ServiceConnection conn = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      ottoBinder = (SilGelService.OttoBinder) service;
      ottoBinder.wcsndm();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.greeting);

    // 内部类实现点击事件监听器
    Button keyhat = findViewById(R.id.keyhat);
    ClkKeycat clkKeycat = new ClkKeycat();
    keyhat.setOnClickListener(clkKeycat);

    // 匿名类实现点击事件监听
    Button dingdong = findViewById(R.id.dingdong);
    dingdong.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 暂时跳到略猫区
        Intent intent = new Intent(GreetingBtn.this, KeyHatTV.class);
        startActivity(intent);
      }
    });

    Button purple_egg = findViewById(R.id.purple_egg);
    purple_egg.setOnClickListener(this); // 见证区临时汇入略猫区
  }

  // 本类实现点击事件监听
  @Override
  public void onClick(View v){
    Intent intent = new Intent(GreetingBtn.this, PurpleEgg.class);
    startActivity(intent);
  }

  // 启动服务
  public void waAo(View view) {
    Intent intent = new Intent(this, SilGelService.class);
   bindService(intent,conn,BIND_AUTO_CREATE);
  }


  // 内部类定义
  class ClkKeycat implements View.OnClickListener{
    @Override
    public void onClick(View v){
      Intent intent = new Intent(GreetingBtn.this, KeyHatTV.class);
      startActivity(intent);
    }
  }



  // xml显式调用并弹出对话框
  public void ccb(View view) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("老爷爷，我给你踩背来咯");
    builder.setNegativeButton("？", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        Intent intent = new Intent(GreetingBtn.this,ccb.class);
        startActivity(intent);
      }
    });
    AlertDialog alertDialog = builder.create();
    alertDialog.show();
  }

  // xml隐式调用
  public void xmlClick(View v) {
    if (v.getId() == R.id.hachimi) {
      Intent intent = new Intent();
      intent.setAction("LITTLE_WHITE_GLOVES").setClassName(getPackageName(), "com.example.HomoTvApp.Hachimi");
      startActivity(intent);
    }

  }
}
