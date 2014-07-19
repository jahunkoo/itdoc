package profileSetting;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.hanikok.R;

public class settingHelp extends Activity implements OnClickListener {

	TextView Q1 = null;
	TextView Q2 = null;
	TextView Q3 = null;
	TextView Q4 = null;
	TextView Q5 = null;
	TextView Q6 = null;

	TextView A1 = null;
	TextView A2 = null;
	TextView A3 = null;
	TextView A4 = null;
	TextView A5 = null;
	TextView A6 = null;

	ActionBar actionBar = null; //액션바 세팅 시작

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_setting_help);
		setElements();
	}

	private void setElements() {

		Q1 = (TextView) findViewById(R.id.help_Q1);
		Q2 = (TextView) findViewById(R.id.help_Q2);
		Q3 = (TextView) findViewById(R.id.help_Q3);
		Q4 = (TextView) findViewById(R.id.help_Q4);
		Q5 = (TextView) findViewById(R.id.help_Q5);
		Q6 = (TextView) findViewById(R.id.help_Q6);

		A1 = (TextView) findViewById(R.id.help_A1);
		A2 = (TextView) findViewById(R.id.help_A2);
		A3 = (TextView) findViewById(R.id.help_A3);
		A4 = (TextView) findViewById(R.id.help_A4);
		A5 = (TextView) findViewById(R.id.help_A5);
		A6 = (TextView) findViewById(R.id.help_A6);

		Q1.setOnClickListener(this);
		Q2.setOnClickListener(this);
		Q3.setOnClickListener(this);
		Q4.setOnClickListener(this);
		Q5.setOnClickListener(this);
		Q6.setOnClickListener(this);
		
		//액션바에 객체 할당
		actionBar = getActionBar();
		actionBar.setTitle("설정");
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.help_Q1:
			if (A1.getVisibility() == View.VISIBLE)
				A1.setVisibility(View.GONE);
			else
				A1.setVisibility(View.VISIBLE);
			break;

		case R.id.help_Q2:
			if (A2.getVisibility() == View.VISIBLE)
				A2.setVisibility(View.GONE);
			else
				A2.setVisibility(View.VISIBLE);
			break;
			
		case R.id.help_Q3:
			if (A3.getVisibility() == View.VISIBLE)
				A3.setVisibility(View.GONE);
			else
				A3.setVisibility(View.VISIBLE);
			break;
			
		case R.id.help_Q4:
			if (A4.getVisibility() == View.VISIBLE)
				A4.setVisibility(View.GONE);
			else
				A4.setVisibility(View.VISIBLE);
			break;
			
		case R.id.help_Q5:
			if (A5.getVisibility() == View.VISIBLE)
				A5.setVisibility(View.GONE);
			else
				A5.setVisibility(View.VISIBLE);
			break;
			
		case R.id.help_Q6:
			if (A6.getVisibility() == View.VISIBLE)
				A6.setVisibility(View.GONE);
			else
				A6.setVisibility(View.VISIBLE);
			break;
		}

	}

}
