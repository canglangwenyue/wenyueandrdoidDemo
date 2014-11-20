package com.example.weiyi_fragment;

import com.example.weiyi_phonesms.R;
import com.example.weiyi_phonesms.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SmsFragment extends Fragment{
	private View view;//缓存页面
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//		Log.i("slide","FriendFragment-onCreateView");
		if(view==null){
			view=inflater.inflate(R.layout.sms_fragment,container, false);
		}
		ViewGroup parent = (ViewGroup) view.getParent();
		if(parent!=null){
			parent.removeView(view);//先移除
		}
		return view;
	}
//	@Override
//    public void onPause()
//    {
//        // TODO Auto-generated method stub
//        super.onPause();
//        Log.i("slide","FriendFragment--onPause");
//    }
//	@Override
//	public void onStop() {
//		// TODO Auto-generated method stub
//		super.onStop();
//		Log.i("slide","FriendFragment--onStop");
//	}
}
