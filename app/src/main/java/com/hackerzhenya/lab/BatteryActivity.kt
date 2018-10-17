package com.hackerzhenya.lab

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_battery.*


class BatteryActivity : AppCompatActivity() {
    lateinit var broadcastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery)

        broadcastReceiver = BatteryBroadcastReceiver { batteryLevel, isCharging ->
            batteryState.text = when (isCharging) {
                true -> "Charging"
                false -> "Not charging"
            }

            batteryPercentage.text = "$batteryLevel%"
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(broadcastReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastReceiver)
    }
}
