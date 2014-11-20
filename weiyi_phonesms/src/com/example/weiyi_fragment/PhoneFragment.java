package com.example.weiyi_fragment;

import com.example.weiyi_phonesms.R;
import com.example.weiyi_phonesms.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhoneFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.phone_fragment, container, false);
		// 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生IllegalStateException。
		ViewGroup parent = (ViewGroup) view.getParent();
		if (parent != null) {
			parent.removeView(view);
		}
		return view;
	}

}
