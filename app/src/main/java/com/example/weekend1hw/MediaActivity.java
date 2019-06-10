package com.example.weekend1hw;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MediaActivity extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer player;
    ImageView image;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        image = findViewById(R.id.mediaImage);
        image.setImageResource(R.drawable.music);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
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

    public void play(View v) {
        // if the media player doesn't already exist, create it.
        // Once you hit pause or stop, the media player still exists, so we don't have to
        // use following if again
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.wiitheme);

            // once song has completed, stop the player and free up resources
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    // don't just stop playing, but free up it's resources
    // done by calling StopPlayer()
    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer(){
        // if player exists, release it's resources to fully stop
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer stopped", Toast.LENGTH_SHORT).show();
        }
    }

    // As soon as we leave our activity, stop the media player
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}
