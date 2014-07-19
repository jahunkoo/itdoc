package com.example.hanikok;

import profileSetting.profileSettingActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class profileActivity extends Activity implements OnClickListener {

	Button btn_setting = null;
	ActionBar actionBar = null; //액션바 세팅 시작

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_activity);
		setElements();
	}
	
	private void setElements(){
		
		//액션바에 객체 할당 및 잔 작업
		actionBar = getActionBar();
		actionBar.setTitle("프로필");
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()){
		
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		
		case R.id.menu_setting :
			Intent intent = new Intent (profileActivity.this,profileSettingActivity.class);
			startActivity(intent);
		
		}
		
		return super.onOptionsItemSelected(item);
	}

	
	
}
