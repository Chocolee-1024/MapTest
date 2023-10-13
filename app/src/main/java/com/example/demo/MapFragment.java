package com.example.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {
//    private LocationRequest locationRequest;
//    private LocationCallback locationCallback;
//    private FusedLocationProviderClient locationProviderClient;
//    private GoogleMap mMap;
//    private int status = 0;
//    private MainActivity activity;
//    private OnLocationUpdateListener locationUpdateListener;
//
//    public MapFragment(MainActivity activity) {
//        this.activity = activity;
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_map, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        activity.mapChangeListener(onChangeListener);
//        SupportMapFragment mapFragment =
//                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//        if (mapFragment != null) {
//            mapFragment.getMapAsync(callback);
//        }
//    }


//    private OnMapReadyCallback callback = new OnMapReadyCallback() {
//        @Override
//        public void onMapReady(@NonNull GoogleMap googleMap) {
//            mMap = googleMap;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                createLocationRequest();
//            }
//            mMap.moveCamera(CameraUpdateFactory.zoomTo(15.0f));
//
//            locationCallback = new LocationCallback() {
//                @Override
//                public void onLocationResult(@NonNull LocationResult locationResult) {
//                    if (locationResult == null) {
//                        return;
//                    }
//
//                    for (Location location : locationResult.getLocations()) {
//
//                        float accuracy = location.getAccuracy();
//                        Log.e("TAG", "onLocationResult: " + "test" );
//                        if (status == 0) {
//                            if (accuracy < 40.0f) {
//                                LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
//                                locationUpdateListener.onLocationUpdate(location.getLatitude(), location.getLongitude());
//                                if (ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                                    return;
//                                }
//                                mMap.setMyLocationEnabled(true);
//                                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//                            }
//                        } else {
//                            if(accuracy < 40.0f) {
//                                LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
//                                locationUpdateListener.onLocationUpdate(location.getLatitude(), location.getLongitude());
//                                mMap.setMyLocationEnabled(false);
//                                mMap.addMarker(new MarkerOptions().position(sydney).title(""));
//                                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//                            }
//                        }
//                    }
//                }
//            };
//            startLocationUpdates();
//        }
//    };
//
//    public MainActivity.OnChangeListener onChangeListener = new MainActivity.OnChangeListener() {
//        @Override
//        public void onChangeListener(int mode) {
//            status = mode;
//            mMap.clear();
//        }
//    };
//
////    @RequiresApi(api = Build.VERSION_CODES.S)
////    protected void createLocationRequest() {
////        locationRequest = new LocationRequest.Builder(3000)
////                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
////                .build();
////    }
//
//    @SuppressLint("MissingPermission")
//    private void startLocationUpdates() {
//        locationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
//        locationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
//    }
//
//    public interface OnLocationUpdateListener {
//        void onLocationUpdate(double latitude, double longitude);
//    }
//
//    public void mapEventListener(OnLocationUpdateListener listener) {
//        locationUpdateListener = listener;
//    }
}