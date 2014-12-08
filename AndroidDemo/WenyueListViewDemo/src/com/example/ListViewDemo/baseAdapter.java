package com.example.ListViewDemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.ViewGroup;
import android.widget.*;
import com.example.IntentTest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by canglangwenyue on 12/3/14.
 */
public class baseAdapter extends Activity {

    private ListView personListView;
    private List<Person> personList;
    private PersonAdapter personAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseadapter);

        personList = new ArrayList<Person>();
        personListView = (ListView) findViewById(R.id.baseadapterlistView);
        personList = initContacts();
        personAdapter = new PersonAdapter();
        personListView.setAdapter(personAdapter);

    }

    private List<Person> initContacts() {
        Cursor cursor = getContentResolver().query(Phone.CONTENT_URI,charChangeutil.PHONES_PROJECTION,null,null,null);
        personAdapter = new PersonAdapter();
        Person person = null;
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            person = new Person();
            person.setName(cursor.getString(0));
            person.setPhoneNumber(cursor.getString(1));
            personList.add(person);
        }
        cursor.close();
        return personList;
    }

    class ViewHolder {
        private TextView personIcon;
        private TextView personName;

        public ViewHolder(View view) {
            personIcon = (TextView) view.findViewById(R.id.personNameTextView);
            personName = (TextView) view.findViewById(R.id.personNumberTextView);
            view.setTag(this);
        }
    }

    class PersonAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return personList.size();
        }

        @Override
        public Object getItem(int position) {
            return personList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView==null) {
                convertView = View.inflate(getApplicationContext(),R.layout.baseadapteritem,null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            Person person = personList.get(position);
            holder.personIcon.setText(person.getName());
            holder.personName.setText(person.getPhoneNumber());

            Button button = (Button) convertView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(baseAdapter.this,"Don't touch me!",Toast.LENGTH_LONG).show();
                }
            });



            return convertView;
        }
    }

}