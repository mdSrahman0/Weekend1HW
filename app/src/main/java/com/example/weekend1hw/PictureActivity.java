// Allow user to take a photo
// Md Rahman

package com.example.weekend1hw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity implements View.OnClickListener{

    Button btPhoto; // "take photo" button
    ImageView imageView; // image view to hold photo
    Toolbar myToolbar;
    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // call this activity's setSupportActionBar() method and
        // pass in the toolbar we created in the xml as the app bar

        // set appropriate content view
        setContentView(R.layout.activity_picture);

        // link views to appropriate id's
        btPhoto = findViewById(R.id.btnCamera);
        imageView = findViewById(R.id.imageView);
        btBack = findViewById(R.id.btnBack);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("WEEKEND1HW");

        // once the take photo button is clicked, do the following
        btPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // create a new intent to access the camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
    }

    // Go back to the main activity
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

}
