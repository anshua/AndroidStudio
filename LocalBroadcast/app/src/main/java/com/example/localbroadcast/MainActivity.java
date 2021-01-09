package com.example.localbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LocalBroadcastReceiver localBroadcastReceiver;
    private TextView textView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsAndButtons();
        registerLocalBroadcast();
    }

    private void initViewsAndButtons() {
        textView = findViewById(R.id.tvView);
        btn = findViewById(R.id.btnSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.anshuahi.local.broadcast");
                intent.putExtra("data", "Anshu is the best");
                sendBroadcast(intent);

            }
        });
    }

    private void registerLocalBroadcast(){
        localBroadcastReceiver = new LocalBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.anshuahi.local.broadcast");
        registerReceiver(localBroadcastReceiver, intentFilter);
    }

    private class LocalBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText(intent.getStringExtra("data"));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localBroadcastReceiver);
    }
}