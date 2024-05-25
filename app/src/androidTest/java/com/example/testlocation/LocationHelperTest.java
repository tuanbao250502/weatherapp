package com.example.testlocation;

import android.content.Context;
import android.location.Location;
import android.os.Looper;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class LocationHelperTest {

    private LocationHelper locationHelper;
    private Context context;

    @Before
    public void setUp() {
        context = ApplicationProvider.getApplicationContext();
        locationHelper = new LocationHelper(context);
    }

    @Test
    public void testRequestLocationUpdates() {
        // Mock LocationCallback
        LocationCallback callback = mock(LocationCallback.class);

        // Gọi phương thức requestLocationUpdates
        locationHelper.requestLocationUpdates(callback);

        // Kiểm tra xem fusedLocationProviderClient đã gọi đến requestLocationUpdates hay không
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, callback, Looper.getMainLooper());
        verify(fusedLocationProviderClient).requestLocationUpdates(locationRequest, callback, Looper.getMainLooper());
    }

    @Test
    public void testStopLocationUpdates() {
        // Mock LocationCallback
        LocationCallback callback = mock(LocationCallback.class);

        // Gọi phương thức stopLocationUpdates
        locationHelper.stopLocationUpdates();

        // Kiểm tra xem fusedLocationProviderClient đã gọi đến removeLocationUpdates hay không
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        fusedLocationProviderClient.removeLocationUpdates(callback);
        verify(fusedLocationProviderClient).removeLocationUpdates(callback);
    }
}
