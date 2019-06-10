package com.example.weekend1hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AllPersonsActivity extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    Button btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_persons);
        btBack = findViewById(R.id.btnBack);

        listView = findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        Intent i = getIntent();
        //arrayList.add("Hi");
        arrayList = i.getStringArrayListExtra("Information");
        ArrayAdapter Adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(Adapter);

    }

    // Go Back to main activity
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
