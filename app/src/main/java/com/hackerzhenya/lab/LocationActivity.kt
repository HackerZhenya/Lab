package com.hackerzhenya.lab

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_location.*


class LocationActivity : AppCompatActivity() {
    private lateinit var mLocationListener: LocationListener
    private lateinit var mLocationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        mLocationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        mLocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                latValue.text = location.latitude.toString()
                lonValue.text = location.longitude.toString()
            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }
    }

    override fun onResume() {
        super.onResume()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), 1)
        else
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, mLocationListener)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                if (grantResults.isEmpty() || grantResults.any { it == PackageManager.PERMISSION_DENIED }) {
                    Toast.makeText(this, "Необходисо разрешение для доступа к геопозиции", Toast.LENGTH_LONG).show()
                    finish()
                }
                return
            }
        }
    }
}
