package com.hackerzhenya.lab

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "10 миллионов лет ушло на выполнение этой задачи", Toast.LENGTH_LONG).show()

        goto_battery.setOnClickListener {
            runActivity(BatteryActivity::class)
        }

        goto_location.setOnClickListener {
            runActivity(LocationActivity::class)
        }
    }

    fun runActivity(cls: KClass<*>) {
        startActivity(Intent(this, cls.java))
    }

    override fun onStart() {
        super.onStart()
        Log.d("App", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("App", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("App", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("App", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("App", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("App", "onDestroy")
    }
}
