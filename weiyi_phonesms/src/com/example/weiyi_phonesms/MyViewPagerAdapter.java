package com.example.weiyi_phonesms;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * 这个adapter里面有Fragment数组
 * @author Striver_zw
 *   Date  2014-11-19
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> fragments;//需要添加到上面的Fragment
	
	public MyViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	/**
	 * 自定义的构造函数
	 * @param fm
	 * @param fragments ArrayList<Fragment>
	 */
	public MyViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}
	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);//返回Fragment对象
	}
	@Override
	public int getCount() {
		return fragments.size();//返回Fragment的个数
	}
}
