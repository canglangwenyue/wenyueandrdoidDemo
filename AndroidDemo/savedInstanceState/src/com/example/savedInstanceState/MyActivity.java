package com.example.savedInstanceState;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyActivity extends Activity {
    private static final String TAG = "WenYue_Log";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // If an instance of this activity had previously stopped, we can
        // get the original text it started with.
        if(null != savedInstanceState)
        {
            int IntTest = savedInstanceState.getInt("IntTest");
            String StrTest = savedInstanceState.getString("StrTest");
            Toast.makeText(MyActivity.this,StrTest,Toast.LENGTH_LONG).show();

            Log.e(TAG, "onCreate get the savedInstanceState+IntTest=" + IntTest + "+StrTest=" + StrTest);
        }
        setContentView(R.layout.main);

        Log.e(TAG, "onCreate");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save away the original text, so we still have it if the activity
        // needs to be killed while paused.
        savedInstanceState.putInt("IntTest", 0);
        savedInstanceState.putString("StrTest", "savedInstanceState test");
        super.onSaveInstanceState(savedInstanceState);
        Log.e(TAG, "使用了我的onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int IntTest = savedInstanceState.getInt("IntTest");
        String StrTest = savedInstanceState.getString("StrTest");
        Log.e(TAG, "onRestoreInstanceState+IntTest="+IntTest+"+StrTest="+StrTest);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onPause","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onPause","onDestroy");
    }
}
