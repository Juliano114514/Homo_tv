package com.example.test1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class KeyHatTV extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sign_up);

    // 获取 TextView
    TextView textView = findViewById(R.id.textView);
    // 请求焦点
    textView.setSelected(true);  // 使 TextView 获得焦点
  }
}