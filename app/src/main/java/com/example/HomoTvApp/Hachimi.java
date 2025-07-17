package com.example.HomoTvApp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Hachimi extends AppCompatActivity {

  private ListView mHachimiListView;
  private List<String> mHachimiStr = new ArrayList<>();
  private ArrayAdapter<String> mHachimiAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hachimi);
    mHachimiListView = findViewById(R.id.your_heroes);

    for (int i = 0; i < 50; i++) {
      mHachimiStr.add("条目" + i);
    }

    mHachimiAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, mHachimiStr);
    mHachimiListView.setAdapter(mHachimiAdapter);
    mHachimiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(Hachimi.this,"条目"+id+"被点击",Toast.LENGTH_SHORT).show();
      }
    });
  }

}

