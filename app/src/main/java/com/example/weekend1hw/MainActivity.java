// Allow user to select one of six different activities.
// Md Rahman

package com.example.weekend1hw;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btPhoto;
    Button btEMI;
    Button btPerson;
    Button btAllPersons;
    Button btMedia;
    Button btWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach all necessary activity buttons
        btPhoto = findViewById(R.id.btPhoto);
        btEMI = findViewById(R.id.btEMI);
        btPerson = findViewById(R.id.btPerson);
        btAllPersons = findViewById(R.id.btAllPersons);
        btMedia = findViewById(R.id.btMedia);
        btWebview = findViewById(R.id.btWeb);

        // attach all onclick listeners to buttons
        btPhoto.setOnClickListener(this);
        btEMI.setOnClickListener(this);
        btPerson.setOnClickListener(this);
        btAllPersons.setOnClickListener(this);
        btMedia.setOnClickListener(this);
        btWebview.setOnClickListener(this);
    } // end on create

    // Depending on what button they click, open that activity
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btPhoto:
                Intent int1 = new Intent(MainActivity.this,PictureActivity.class);
                startActivity(int1);
                break;
            case R.id.btEMI:
                Intent int2 = new Intent(MainActivity.this,EMIActivity.class);
                startActivity(int2);
                break;
            case R.id.btPerson:
                Intent int3 = new Intent(MainActivity.this,PersonActivity.class);
                startActivity(int3);
                break;
            case R.id.btAllPersons:
                Intent int4 = new Intent(MainActivity.this,AllPersonsActivity.class);
                startActivity(int4);
                break;
            case R.id.btMedia:
                Intent int5 = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(int5);
                break;
            case R.id.btWeb:
                Intent int6 = new Intent(MainActivity.this, WebActivity.class);
                startActivity(int6);
                break;
        }

    }
}
