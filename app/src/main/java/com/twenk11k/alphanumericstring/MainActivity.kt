package com.twenk11k.alphanumericstring

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val TAG = "TAGMainActivity";

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_uuid -> {
                randomUUID()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_random -> {
                randomClass()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_method1 -> {
                randomMethod1()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        // Create RandomUUID
        randomUUID()
    }
    private fun randomUUID(){

        val generatedUUID =  UUID.randomUUID().toString()
        txtMain.setText(generatedUUID)
        Log.d(TAG,"UUID: "+generatedUUID)
    }
    private fun randomClass(){
        val randomVal =  Utils.getRandomStr()
        txtMain.setText(randomVal)
        Log.d(TAG,"randomVal: "+randomVal)

    }
    private fun randomMethod1(){
        val randomVal =  Utils.randomMethod1()
        txtMain.setText(randomVal)
        Log.d(TAG,"randomMethod1: "+randomVal)

    }
}
