package com.example.android.localbroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyReciever reciever;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.clickerBTN);
        btn.setOnClickListener(this);
        reciever = new MyReciever();

    }

    @Override
    protected void onStart() {
        super.onStart();
       LocalBroadcastManager.getInstance(this).registerReceiver(reciever, new IntentFilter("evento"));

    }
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String message = intent.getStringExtra("message");
            Log.d("receiver", "Got message: " + message);
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(reciever);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clickerBTN:
                clicked();
                break;
            default:
                return;
        }
    }

    private void clicked() {
        Log.d("sender", "Broadcasting message");
        Intent intent = new Intent("evento");
        // You can also include some extra data.
        intent.putExtra("message", "This is my message!");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
