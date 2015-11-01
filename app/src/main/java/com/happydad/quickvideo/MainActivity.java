package com.happydad.quickvideo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    // Setup a result flag for your video capture
    int ACTION_TAKE_VIDEO = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantCamera();
        ImageButton photoButton = (ImageButton) this.findViewById(R.id.video_button);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                instantCamera();
            }
        });
    }

    public void instantCamera() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(takeVideoIntent, ACTION_TAKE_VIDEO);
        //release() DataBuffer object

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {

            if (requestCode == ACTION_TAKE_VIDEO) {

                Toast.makeText(getApplicationContext(), "The video has been saved to your default camera directory.", Toast.LENGTH_LONG).show();
            }
        }

    }

}