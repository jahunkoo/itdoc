package com.example.hanikok;

import java.util.ArrayList;

import dto.BigRegion;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class LocationDialog extends DialogFragment implements OnItemClickListener{

	private ArrayList<BigRegion> bigReionList;
	public String[] locationNameArr;
	
	public static LocationDialog newInstance(){
		LocationDialog dialog = new LocationDialog();
		
		ArrayList<BigRegion> bigRegionList= IntroActivity.bigReionList;
		Log.d("koo", "size:"+bigRegionList.size());
		dialog.locationNameArr = new String[bigRegionList.size()];
		for(int i=0;i<bigRegionList.size(); i++){
			dialog.locationNameArr[i] = bigRegionList.get(i).getRegionName();
		}
		
		return dialog;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// 알림창 만드는 일꾼 생성
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				
				LayoutInflater vi = getActivity().getLayoutInflater();
				LinearLayout localListLayout = (LinearLayout) vi.inflate(R.layout.local_list, null);
				ListView listView = (ListView) localListLayout.findViewById(R.id.local_dialoglist);
				
				//TextView textView = new TextView(getActivity());
				//listView.addHeaderView(textView ,"", false);
				//listView.addFooterView(textView ,"", false);
				listView.setOnItemClickListener(this);
				ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, locationNameArr );
				listView.setAdapter(adapter);
				
				builder.setView(localListLayout);
				
				return builder.create();
	}

	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	// String KEY_TEXTPSS = "TEXTPSS";
	// static final int CUSTOM_DIALOG_ID = 0;
/*
	ListView dialog_ListView;

	String[] listContent = { "January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "November",
			"December" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 배경 반투명하는 코드
		WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
		lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		lpWindow.dimAmount = 0.8f;
		getWindow().setAttributes(lpWindow);

		setContentView(R.layout.local_list);
		dialog_ListView = (ListView) findViewById(R.id.local_dialoglist);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listContent);
		dialog_ListView.setAdapter(adapter);

		// setLayout();
		// setTitle(mTitle);
		// setContent(mContent);
		// setClickListener(mLeftClickListener, mRightClickListener);
	}

	public LocationDialog(Context context) {
		// Dialog 배경을 투명 처리 해준다.
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
	}

	
	 * public LocationDialog(Context context, String title, View.OnClickListener
	 * singleListener) { super(context,
	 * android.R.style.Theme_Translucent_NoTitleBar); this.mTitle = title;
	 * this.mLeftClickListener = singleListener; }
	 

	
	 * public LoacationDialog(Context context, String title, String content,
	 * View.OnClickListener leftListener, View.OnClickListener rightListener) {
	 * super(context, android.R.style.Theme_Translucent_NoTitleBar); this.mTitle
	 * = title; this.mContent = content; this.mLeftClickListener = leftListener;
	 * this.mRightClickListener = rightListener; }
	 

	private void setTitle(String title) {
		mTitleView.setText(title);
	}

	
	 * private void setContent(String content) { mContentView.setText(content);
	 * }
	 * 
	 * private void setClickListener(View.OnClickListener left,
	 * View.OnClickListener right) { if (left != null && right != null) {
	 * mLeftButton.setOnClickListener(left);
	 * mRightButton.setOnClickListener(right); } else if (left != null && right
	 * == null) { mLeftButton.setOnClickListener(left); } else {
	 * 
	 * } }
	 
	private TextView mTitleView;
	private TextView mContentView;
	private Button mLeftButton;
	private Button mRightButton;
	private String mTitle;
	private String mContent;

	private View.OnClickListener mLeftClickListener;
	private View.OnClickListener mRightClickListener;

	
	 * Layout
	 

	private void setLayout() {
		
		 * mTitleView = (TextView) findViewById(R.id.tv_title); mContentView =
		 * (TextView) findViewById(R.id.tv_content); mLeftButton = (Button)
		 * findViewById(R.id.bt_left); mRightButton = (Button)
		 * findViewById(R.id.bt_right);
		 
		// Prepare ListView in dialog
		setContentView(R.layout.local_list);
		dialog_ListView = (ListView) findViewById(R.id.local_dialoglist);
	}*/

}
