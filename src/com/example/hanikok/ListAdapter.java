package com.example.hanikok;

import java.util.ArrayList;
import java.util.List;

import connect.ConnectionBridge;

import util.JsonParser;

import lazyList.ImageLoader;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import dto.KmClinicView;

public class ListAdapter extends BaseAdapter {

	public List<Item> items = new ArrayList<Item>();
	private LayoutInflater inflator;
	public ImageLoader imageLoader;

	public ListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		inflator = LayoutInflater.from(context);
		imageLoader = new ImageLoader(context);
		
		ArrayList<KmClinicView> kmClinicViewList = new ArrayList<KmClinicView>();
		ConnectionBridge connectionBridge = new ConnectionBridge();
		kmClinicViewList = connectionBridge.getKmClinicViewList("getAllKmClinic", context);
		
		for (int i=0; i< kmClinicViewList.size(); i++) {
			
			KmClinicView kmClinicView = kmClinicViewList.get(i);
			
			String local = kmClinicView.getBigRegionName() + kmClinicView.getMiddleRegionName() + kmClinicView.getRemainRegion();
			
			items.add(new Item(kmClinicView.getName(), local, String.valueOf(kmClinicView.getFollowNum()), kmClinicView.getPicturePath()));
		}
		
		
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