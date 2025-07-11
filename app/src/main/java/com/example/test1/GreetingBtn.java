package com.example.test1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class GreetingBtn extends AppCompatActivity implements View.OnClickListener{
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
    Intent intent = new Intent(GreetingBtn.this, KeyHatTV.class);
    startActivity(intent);
  }

  // 内部类定义
  class ClkKeycat implements View.OnClickListener{
    @Override
    public void onClick(View v){
      Intent intent = new Intent(GreetingBtn.this, KeyHatTV.class);
      startActivity(intent);
    }
  }

}
