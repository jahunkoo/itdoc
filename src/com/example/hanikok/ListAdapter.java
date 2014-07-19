package com.example.hanikok;

import java.util.ArrayList;
import java.util.List;

import lazyList.ImageLoader;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	public List<Item> items = new ArrayList<Item>();
	private String[] data = null;
	private LayoutInflater inflator;
	public ImageLoader imageLoader;

	public ListAdapter(Context context, String[] d) {
		// TODO Auto-generated constructor stub
		inflator = LayoutInflater.from(context);
		imageLoader = new ImageLoader(context);
		data = d;
			items.add(new Item("생명마루 한의원", "서울 역삼동", "Like : 87", d[0]));
			items.add(new Item("편강 한의원", "서울 중구", "Like:77", d[1]));
			items.add(new Item("특별한별 한의원", "서울 성동구", "Like : 67", d[2]));
			items.add(new Item("맑은숲 한의원", "서울 강남구", "Like:56", d[3]));
			items.add(new Item("삼성 한의원", "서울 노원구", "Like:43", d[4]));
			items.add(new Item("고운누리 한의원", "서울 강서구", "Like:41", d[5]));
			items.add(new Item("풀입 한의원", "서울 강남구", "Like:31", d[6]));
			items.add(new Item("경희 한의원", "서울 성북구", "Like:21", d[7]));
			items.add(new Item("한림 병원", "서울 중구", "Like:20", d[8]));
			items.add(new Item("버드나무 한의원", "서울 강남구", "Like:17", d[9]));
			items.add(new Item("자연과 한의원", "서울 용산구", "Like:11", d[10]));
			items.add(new Item("선재 한의원", "서울 동대문구", "Like:5", d[11]));
	}

	public void additem(String name, String location, String like, String picturePath) {
		items.add(new Item(name, location, like, picturePath));
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		ImageView img1 = null;
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

		txt1 = (TextView) v.findViewById(R.id.near_list_name);
		txt2 = (TextView) v.findViewById(R.id.near_list_location);
		txt3 = (TextView) v.findViewById(R.id.near_list_like);
		img1 = (ImageView) v.findViewById(R.id.near_list_image);
		Item item = (Item) getItem(position);

		txt1.setText(item.name);
		txt2.setText(item.local);
		txt3.setText(item.like);

		Log.d("kim","ListAdapter(86) PicturePath is " + item.picturePath);
		Log.d("kim","ListAdapter(87) img1 is " + img1);
		try{
		imageLoader.DisplayImage(item.picturePath, img1);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return v;
	}

	private class Item {
		final String name;
		final String local;
		final String like;
		final String picturePath;

		Item(String name, String local, String like, String picturePath) {
			this.name = name;
			this.local = local;
			this.like = like;
			this.picturePath = picturePath;

		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}