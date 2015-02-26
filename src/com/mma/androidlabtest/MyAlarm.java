package com.mma.androidlabtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyAlarm extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast toast = Toast.makeText(context, R.string.alarm_launched, Toast.LENGTH_SHORT);
		toast.show();
	}

}
