package com.example.android.localbroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Android on 6/21/2017.
 */

public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String broadString = intent.getStringExtra("message");
        Toast.makeText(context, "WOoooooooooooooow gottem " + broadString, Toast.LENGTH_SHORT).show();
    }
}
