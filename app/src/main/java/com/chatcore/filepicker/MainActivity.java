package com.chatcore.filepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.utils.Orientation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilePickerBuilder.getInstance()
                        .setMaxCount(20)
//                            .setSelectedFiles(photoPaths)
//                            .setActivityTheme(R.style.FilePickerTheme)
                        .setActivityTitle("Select media")
                        .enableVideoPicker(true)
                        .enableCameraSupport(true)
                        .showGifs(false)
                        .showFolderView(true)
                        .enableSelectAll(true)
                        .enableImagePicker(true)
//                            .setCameraPlaceholder(R.drawable.custom_camera)
                        .withOrientation(Orientation.PORTRAIT_ONLY)
                        .pickPhoto(MainActivity.this, 123);
            }
        });
    }
}
