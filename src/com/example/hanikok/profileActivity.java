package com.example.hanikok;

import profileSetting.profileSettingActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class profileActivity extends Activity implements OnClickListener {

	Button btn_setting = null;
	ActionBar actionBar = null; // 액션바 세팅 시작
	
//	View user_layout;
//	View user_insert_layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_activity);
		
	//	user_layout = (View)findViewById(R.id.user_layout);
	//	user_insert_layout = (View)findViewById(R.id.user_insert_layout);
		
		///회원가입, 로그인, 로그아웃 버튼
		Button hani_join_btn = (Button)findViewById(R.id.join_hani);
		hani_join_btn.setOnClickListener(this);
		Button hani_login_btn = (Button)findViewById(R.id.login_hani);
		hani_login_btn.setOnClickListener(this);
		Button hani_logout_btn = (Button)findViewById(R.id.logout_hani);
		hani_logout_btn.setOnClickListener(this);
		
		setElements();
	}

	private void setElements() {

		// 액션바에 객체 할당 및 잔 작업
		actionBar = getActionBar();
		actionBar.setTitle("프로필");
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		
		//회원가입
		case R.id.join_hani:
			Intent intent = new Intent(this,UserActivity.class);
			startActivity(intent);
			break;

		case R.id.login_hani:
			Intent intent_login = new Intent(this,HaniLogin.class);
			startActivity(intent_login);
			//Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT)
			//.show();
			break;
			
		case R.id.logout_hani:
			Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT)
			.show();
			break;

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

		case R.id.menu_setting:
			Intent intent = new Intent(profileActivity.this,
					profileSettingActivity.class);
			startActivity(intent);

		}

		return super.onOptionsItemSelected(item);
	}

}
