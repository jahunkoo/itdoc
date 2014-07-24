package com.example.hanikok;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HaniLogin extends Activity {
	
	ActionBar actionBar = null; // 액션바 세팅 시작

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hani_login);
	}
}
