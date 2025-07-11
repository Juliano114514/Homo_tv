package com.example.test1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class GreetingBtn extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.greeting);

    // 内部类实现点击事件监听器
    Button keyhat = findViewById(R.id.keyhat);
    ClkKeycat clkKeycat = new ClkKeycat();
    keyhat.setOnClickListener(clkKeycat);


  }

  class ClkKeycat implements View.OnClickListener{
    @Override
    public void onClick(View v){
      Intent intent = new Intent(GreetingBtn.this, TextActivity.class);
      startActivity(intent);
    }
  }

}
