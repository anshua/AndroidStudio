package com.example.powerresources2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private PowerReceiver powerReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver();
    }

    private void registerReceiver(){
        powerReceiver = new PowerReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        registerReceiver(powerReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(powerReceiver);
    }
}