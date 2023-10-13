package com.example.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView latitude_textView;
    private TextView longitude_textView;
    private MapFragment9 mapFragment;
    private MainActivity.OnChangeListener onChangeListener;
    private Button marker_button;
    private Button track_button;
    private final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                init();
            } else {
                // 请求位置权限
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                init();
            } else {
                Log.e("Permission", "Location permission denied.");
            }
        }
    }

    private void init() {
        mapFragment = new MapFragment9(this);
        mapFragment.mapEventListener(onLocationUpdateListener);
        getSupportFragmentManager().beginTransaction().add(R.id.map_frameLayout,mapFragment).commit();
        setupUI();
    }

    private void setupUI() {
        latitude_textView = findViewById(R.id.latitude_textView);
        longitude_textView = findViewById(R.id.longitude_textView);
        marker_button = findViewById(R.id.button);
        track_button = findViewById(R.id.button2);

        marker_button.setOnClickListener(view -> {
            onChangeListener.onChangeListener(1);
        });
        track_button.setOnClickListener(view -> {
            onChangeListener.onChangeListener(0);
        });
    }

    public MapFragment9.OnLocationUpdateListener onLocationUpdateListener = new MapFragment9.OnLocationUpdateListener() {
        @Override
        public void onLocationUpdate(double latitude, double longitude) {
            latitude_textView.setText(String.valueOf(latitude));
            longitude_textView.setText(String.valueOf(longitude));
        }
    };

    public interface OnChangeListener {
        void onChangeListener(int status);
    }

    public void mapChangeListener(MainActivity.OnChangeListener listener) {
        onChangeListener = listener;
    }
}