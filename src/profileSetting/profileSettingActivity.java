package profileSetting;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.hanikok.R;

public class profileSettingActivity extends Activity implements OnClickListener {

	Button btn_help = null;
	ActionBar actionBar = null; //액션바 세팅 시작
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_setting_activity);
		setElements();
		
	}

	private void setElements(){
		btn_help = (Button) findViewById(R.id.setting_help);
		
		btn_help.setOnClickListener(this);
		
		//액션바에 객체 할당
		actionBar = getActionBar();
		actionBar.setTitle("설정");
	}
	
	@Override
	public void onClick(View v) {

		switch (v.getId()){
		
		case R.id.setting_help :
			
			Intent intent = new Intent (profileSettingActivity.this,settingHelp.class);
			startActivity(intent);
		
		}
		
	}

	
	
}
