package com.example.HomoTvApp;

import android.view.View;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KeyHatTV extends AppCompatActivity {

  private Handler handler = new Handler();
  private String originalText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sign_up);

    // 获取 TextView
    TextView textView = findViewById(R.id.marquee);
    textView.setSelected(true);  // 使 TextView 获得焦点
  }

  public void logIn(View view){
    Button v = (Button) view;
    originalText = v.getText().toString();
    v.setEnabled(false);
    v.setText("登录中");
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        v.setText(originalText);
        v.setEnabled(true);
      }
    },1000);

    EditText accEdt = findViewById(R.id.account);
    EditText pwdEdt = findViewById(R.id.pwd);
    String acc = accEdt.getText().toString();
    String pwd = pwdEdt.getText().toString();
    if(acc.isEmpty() || pwd.isEmpty()){
      Toast.makeText(this,"账号或密码不能为空，哈气失败😠",Toast.LENGTH_SHORT).show();
    }

  }
}