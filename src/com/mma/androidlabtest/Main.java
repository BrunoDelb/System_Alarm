package com.mma.androidlabtest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {

	Button btn_schedule;
	Button btn_stop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn_schedule = (Button)findViewById (R.id.btn_schedule);
		btn_stop = (Button)findViewById (R.id.btn_stop);
		btn_schedule.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (Main.this, MyAlarm.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(Main.this, 0, intent, 0);
				AlarmManager alarmManager = (AlarmManager)getSystemService (Activity.ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 5 * 1000, 5 * 1000, pendingIntent);
				Toast toast = Toast.makeText(Main.this, R.string.alarm_schedule, Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		
		btn_stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (Main.this, MyAlarm.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(Main.this, 0, intent, 0);
				AlarmManager alarmManager = (AlarmManager)getSystemService (Activity.ALARM_SERVICE);
				alarmManager.cancel(pendingIntent);
				Toast toast = Toast.makeText(Main.this, R.string.alarm_stop, Toast.LENGTH_SHORT);
				toast.show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
