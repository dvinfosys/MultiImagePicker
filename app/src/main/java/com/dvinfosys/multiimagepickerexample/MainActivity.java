package com.dvinfosys.multiimagepickerexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dvinfosys.multiimagepicker.Activitys.AlbumPickerActivity;
import com.dvinfosys.multiimagepicker.Modal.Image;
import com.dvinfosys.multiimagepicker.Utils.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenImagesPicker;
    private TextView tvImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenImagesPicker = findViewById(R.id.tv_open_images_picker);
        tvImagePath = findViewById(R.id.tv_images);

        btnOpenImagesPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlbumPickerActivity.class);
                intent.putExtra(Constants.INTENT_EXTRA_LIMIT, 3);
                startActivityForResult(intent, Constants.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            ArrayList<Image> images = data.getParcelableArrayListExtra(Constants.INTENT_EXTRA_IMAGES);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0, l = images.size(); i < l; i++) {
                stringBuffer.append(images.get(i).path + "\n");
            }
            tvImagePath.setText(stringBuffer.toString());
        }
    }
}