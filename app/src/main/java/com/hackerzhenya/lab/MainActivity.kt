package com.hackerzhenya.lab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Виталя вынимай!!!", Toast.LENGTH_LONG).show()
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
