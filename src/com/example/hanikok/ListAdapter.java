package com.example.hanikok;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	private List<Item> items = new ArrayList<Item>();
	private LayoutInflater inflator;

	public ListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		inflator = LayoutInflater.from(context);
		items.add(new Item("생명마루 한의원", "서울 강남구", "Like : 87", R.drawable.image_1));
		items.add(new Item("편강 한의원", "서울 중구", "Like:77", R.drawable.image_2));
		items.add(new Item("특별한별 한의원", "서울 성동구", "Like : 67", R.drawable.image_3));
		items.add(new Item("맑은숲 한의원", "서울 강남구", "Like:56", R.drawable.image_4));
		items.add(new Item("삼성 한의원", "서울 노원구", "Like:43", R.drawable.image_5));
		items.add(new Item("고운누리 한의원", "서울 강서구", "Like:41", R.drawable.image_6));
		items.add(new Item("풀입 한의원", "서울 강남구", "Like:31", R.drawable.image_7));
		items.add(new Item("경희 한의원", "서울 성북구", "Like:21", R.drawable.image_8));
		items.add(new Item("한림 병원", "서울 중구", "Like:20", R.drawable.image_9));
		items.add(new Item("버드나무 한의원", "서울 강남구", "Like:17", R.drawable.image_10));
		items.add(new Item("자연과 한의원", "서울 용산구", "Like:11", R.drawable.image_11));
		items.add(new Item("선재 한의원", "서울 동대문구", "Like:5", R.drawable.image_12));

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return items.get(position).drawableId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		ImageView img1;
		TextView txt1;
		TextView txt2;
		TextView txt3;
		if (v == null) {
			v = inflator.inflate(R.layout.near_listview_row, parent, false);
			v.setTag(R.id.picture, v.findViewById(R.id.near_list_image));
			v.setTag(R.id.text, v.findViewById(R.id.near_list_name));
			v.setTag(R.id.text, v.findViewById(R.id.near_list_location));
			v.setTag(R.id.text, v.findViewById(R.id.near_list_like));

		}

		img1 = (ImageView) v.findViewById(R.id.near_list_image);
		txt1 = (TextView) v.findViewById(R.id.near_list_name);
		txt2 = (TextView) v.findViewById(R.id.near_list_location);
		txt3 = (TextView) v.findViewById(R.id.near_list_like);

		Item item = (Item) getItem(position);

		img1.setImageResource(item.drawableId);
		txt1.setText(item.name);
		txt2.setText(item.local);
		txt3.setText(item.like);

		return v;
	}


	private class Item {
		final String name;
		final String local;
		final String like;
		final int drawableId;

		Item(String name, String local, String like, int drawableId) {
			this.name = name;
			this.local = local;
			this.like = like;
			this.drawableId = drawableId;

		}
	}
	
}