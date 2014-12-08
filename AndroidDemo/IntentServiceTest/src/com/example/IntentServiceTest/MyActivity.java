package com.example.IntentServiceTest;

import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showNotification();
    }

    private void showNotification() {
        CharSequence text = getText("Start");

        Notification notification = new Notification(R.drawable.ic_launcher, text,
                System.currentTimeMillis());

        // 当点击通知时，启动该contentIntent关联的activity
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MyActivity.class), 0);

        // 在通知栏上显示标题和内容
        notification.setLatestEventInfo(this,
                getText(R.string.local_service_label), text, contentIntent);

        mNM.notify(NOTIFICATION, notification);
    }
}
