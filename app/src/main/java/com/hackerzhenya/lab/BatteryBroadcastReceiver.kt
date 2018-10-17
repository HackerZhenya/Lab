package com.hackerzhenya.lab

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager


class BatteryBroadcastReceiver(val updateLayout: (batteryLevel: Int, isCharging: Boolean) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL

        updateLayout(level, isCharging)
    }
}