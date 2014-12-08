package com.example.ListViewDemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.example.IntentTest.R;

/**
 * Created by canglangwenyue on 12/3/14.
 */
public class simpleCursorAdapter extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplecursoradapter);

        Cursor cursor=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.simplecursoradapteritem, cursor,
                new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME},
                new int[]{R.id.people_name});

        ListView listView = (ListView) findViewById(R.id.simplecusorlistView);
        listView.setAdapter(adapter);
    }

}