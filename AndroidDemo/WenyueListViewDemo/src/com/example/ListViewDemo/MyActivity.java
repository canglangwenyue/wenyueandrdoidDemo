package com.example.ListViewDemo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.IntentTest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author canglangwenyue
 * 最简单的listview adapter适用于在listview中显示一组String或者一个list的内容
 */

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    ListView listView;

    private List<String> muList = new ArrayList<String>();
    private String[] intentDataString = {"ArrayAdapter","SimpleAdapter","BaseAdapter","SimpleCursorAdapter"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        for (int i=0;i<intentDataString.length;i++) {
            muList.add(intentDataString[i]);
        }

        listView = (ListView) findViewById(R.id.my_listView);
        /*
        android.R.layout.simple_list_item_multiple_choice
        android.R.layout.simple_list_item_checked
        许设置listView.lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
         */
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,muList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast当前选中的listView_item的内容*/
                mySwitcher(muList.get(position).toString());
            }


        });
    }

    private void mySwitcher(String type) {

        if (type=="SimpleAdapter") {
            startActivity(new Intent(MyActivity.this, simpleAdapter.class));
        }else if (type=="ArrayAdapter") {
            Toast.makeText(MyActivity.this,"我一直在这里为你守候",Toast.LENGTH_LONG).show();
        }
        else if (type=="SimpleCursorAdapter") {
            startActivity(new Intent(MyActivity.this, simpleCursorAdapter.class));
        } else if (type=="BaseAdapter") {
            startActivity(new Intent(MyActivity.this, baseAdapter.class));
        }

    }
}
