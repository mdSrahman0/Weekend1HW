package com.example.weekend1hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity implements View.OnClickListener{

    // name of each EditText, where the user will input their information
    private EditText etFName;
    private EditText etLName;
    private EditText etStAddr;
    private EditText etCity;
    private EditText etState;
    private EditText etZip;

    private Button btSaveInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        etFName = findViewById(R.id.etFName);
        etLName = findViewById(R.id.etLName);
        etStAddr = findViewById(R.id.etStAddr);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);

        btSaveInfo = findViewById(R.id.btSaveInfo);


    } // end onCreate

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btSaveInfo:
                ArrayList<String> info = new ArrayList<>();
                info.add(etFName.getText().toString());
                info.add(etLName.getText().toString());
                info.add(etStAddr.getText().toString());
                info.add(etCity.getText().toString());
                info.add(etState.getText().toString());
                info.add(etZip.getText().toString());

                Intent intent = new Intent(getBaseContext(), AllPersonsActivity.class);
                //intent.putExtra("Information", info);
                intent.putStringArrayListExtra("Information", info);
                startActivity(intent);
        }
        // get user input and save to appropriate array

        /*
        String[] info = new String[6];
        info[0] = etFName.getText().toString();
        info[1] = etLName.getText().toString();
        info[2] = etStAddr.getText().toString();
        info[3] = etCity.getText().toString();
        info[4] = etState.getText().toString();
        info[5] = etZip.getText().toString();

        Intent intent = new Intent(getBaseContext(), AllPersonsActivity.class);
        intent.putExtra("Information", info);
        startActivity(intent);
        */



        /*
        String fname = etFName.getText().toString();
        String lnmae = etLName.getText().toString();
        String addr = etStAddr.getText().toString();
        String city = etCity.getText().toString();
        String state = etState.getText().toString();
        String zip = etZip.getText().toString();
        */
    } // end onClick

} // end personactivity class

class Person {
    private String fName, lName, addr, city, state, zip;

    public Person(String fName, String lName, String addr, String city, String state, String zip){
        this.fName = fName;
        this.lName = lName;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
