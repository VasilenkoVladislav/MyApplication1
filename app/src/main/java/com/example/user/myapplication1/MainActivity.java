package com.example.user.myapplication1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NotificationCompat;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Intent i = getIntent();
        TextView txt=(TextView)findViewById(R.id.textViewres);
        txt.setText(i.getStringExtra("MyData"));
    }
    public void GoSecondpageOne(View v)
    {
        Intent i=new Intent(MainActivity.this,SecondActivityTwo.class);
        startActivity(i);
    }
    public void GoSecondpageTwo(View v)
    {
        Intent i=new Intent(MainActivity.this,SecondActivityTwo.class);
        startActivity(i);
    }
    public void GoSecondpageThree(View v)
    {
            NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        Intent resultIntent = new Intent(this, SecondActivityTwo.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(SecondActivityTwo.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }

}
