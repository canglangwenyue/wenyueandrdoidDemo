package com.example.ListViewDemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.example.IntentTest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by canglangwenyue on 12/3/14.
 */
public class simpleAdapter extends Activity {

    private ListView simpleListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);

        simpleListView = (ListView) findViewById(R.id.simplelistView);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(), R.layout.simpleadapteritem, new String[]{"img", "title", "info"}, new int[]{R.id.imageView, R.id.textView, R.id.textView2});
        simpleListView.setAdapter(simpleAdapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("img", R.drawable.ic_launcher);
        map.put("title", "德玛西亚");
        map.put("info", "德玛西亚万岁");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_launcher);
        map.put("title", "卡牌大师");
        map.put("info", "没有一场公平的比赛，也不要去玩一场公平的比赛");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_launcher);
        map.put("title", "炮手");
        map.put("info", "好想射点什么");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_launcher);
        map.put("title", "炼金");
        map.put("info", "摇还是不摇这是一个问题··");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_launcher);
        map.put("title", "死歌");
        map.put("info", "Their pain，is my……pleasure！");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_launcher);
        map.put("title", "寡妇");
        map.put("info", "黑夜就是我的面纱··");
        list.add(map);
        return list;
    }

}