package com.example.test1;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class PurpleEgg extends AppCompatActivity {

  private MediaPlayer mediaPlayer;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.purple_egg);

    LinearLayout textViewGroup = findViewById(R.id.kim);    // 获取包含多个 TextView 的 LinearLayout
    Animation upDownAnimation = AnimationUtils.loadAnimation(this, R.anim.up_down);     // 加载动画资源
    textViewGroup.startAnimation(upDownAnimation);    // 应用动画

    mediaPlayer = MediaPlayer.create(this,R.raw.general_kim);
  }

  @Override
  protected void onStart() {
    super.onStart();
    // 开始播放音频
    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
      mediaPlayer.start();
      mediaPlayer.setVolume(100,100);
    }
  }

  @Override
  protected void onStop() {
    super.onStop();
    // 停止播放音频
    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
      mediaPlayer.stop();
      mediaPlayer.release();
      mediaPlayer = null;
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    // 释放 MediaPlayer 资源
    if (mediaPlayer != null) {
      mediaPlayer.release();
      mediaPlayer = null;
    }
  }
}