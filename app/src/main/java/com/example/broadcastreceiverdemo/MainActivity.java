package com.example.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom broadcast receiver
        BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Custom broadcast received.", Toast.LENGTH_SHORT).show();
            }
        };

        // Intent filter for custom receiver
        IntentFilter filter = new IntentFilter("com.example.MyCustomReceiver.call");
        this.registerReceiver(br, filter);

        // Broadcast receiver for battery low
        BroadcastReceiver br2 = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Batter is low, please charge.", Toast.LENGTH_SHORT).show();
            }
        };

        // Intent filter for battery low
        IntentFilter filter2 = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        this.registerReceiver(br2, filter2);

    }

    public void callCustomReceiver(View view){
        Intent i1 = new Intent();
        i1.setAction("com.example.MyCustomReceiver.call");
        sendBroadcast(i1);
    }
}