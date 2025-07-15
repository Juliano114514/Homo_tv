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

  private ListView hachimiListView;
  private List<String> hachimiStr = new ArrayList<>();
  private ArrayAdapter<String> hachimiAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hachimi);
    hachimiListView = findViewById(R.id.your_heroes);

    for (int i = 0; i < 50; i++) {
      hachimiStr.add("胖宝宝" + i);
    }

    hachimiAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,hachimiStr);
    hachimiListView.setAdapter(hachimiAdapter);
    hachimiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(Hachimi.this,"好胖好可爱",Toast.LENGTH_SHORT).show();
      }
    });
  }

}

