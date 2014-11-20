package com.example.weiyi_fragment;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weiyi_entity.Person;
import com.example.weiyi_phonesms.R;
import com.example.weiyi_util.charChangeutil;

public class InfoFragment extends Fragment {
	private View view;// 缓存页面
	public ListView perListView;
	public personAdapter pAdapter;
	public List<Person> personsList;
	private Cursor cursor;
	public int personSize;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.info_fragment, container, false);
		}
		ViewGroup parent = (ViewGroup) view.getParent();
		if (parent != null) {
			parent.removeView(view);// 先移除
		}
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		personsList = new ArrayList<Person>();
		perListView = (ListView) getActivity().findViewById(R.id.personList);
		personsList = initContacts();
		pAdapter = new personAdapter();
		perListView.setAdapter(pAdapter);
		perListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getActivity(), "bjhk", Toast.LENGTH_LONG).show();

			}
		});
	}

	public List<Person> initContacts() {

		cursor = getActivity().getContentResolver().query(Phone.CONTENT_URI,
				charChangeutil.PHONES_PROJECTION, null, null, null);
		personSize = cursor.getCount();
		pAdapter = new personAdapter();

		Person person = null;
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			person = new Person();
			person.setName(cursor.getString(0));
			person.setPhoneNumber(cursor.getString(1));
			personsList.add(person);
		}
		cursor.close();
		return personsList;

	}

	@Override
	public void onPause() {
		Log.i("INFOFRAGMENT", "ONPAUSE");
		super.onPause();
	}

	@Override
	public void onStart() {
		Log.i("INFOFRAGMENT", "ONSTART");
		super.onStart();
	}

	@Override
	public void onStop() {
		Log.i("INFOFRAGMENT", "ONSTOP");
		super.onStop();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	class ViewHolder {
		private TextView personIcon;
		private TextView personName;

		public ViewHolder(View view) {
			personIcon = (TextView) view.findViewById(R.id.person_Icon);
			personName = (TextView) view.findViewById(R.id.person_name);
			view.setTag(this);
		}
	}

	class personAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return personsList.size();
		}

		@Override
		public Object getItem(int position) {
			return personsList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View.inflate(getActivity()
						.getApplicationContext(), R.layout.person_list_item,
						null);
				new ViewHolder(convertView);
			}
			ViewHolder holder = (ViewHolder) convertView.getTag();
			Person person = personsList.get(position);
			holder.personIcon.setText(person.getName());
			holder.personName.setText(person.getPhoneNumber());
			Log.i(person.getName(), person.getName());
			return convertView;
		}

	}

}
