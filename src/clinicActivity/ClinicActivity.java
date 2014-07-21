package clinicActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanikok.R;

public class ClinicActivity extends Activity {

	ActionBar actionBar = null;
	private int clinicId; // 나중에 액티비티에서 넘겨받은 한의원 id를 여기에 저장한다. 이 id를 기반으로 서버에서
							// 정보를 요청한다.

	private String clinicDetail;
	private String phoneNumber;
	private String location;
	private String price;
	private String workTime;

	ImageView image;

	TextView tvClinicName;
	TextView tvClinicMajor;
	TextView tvDetail;
	TextView tvPhoneNumber;
	TextView tvLocation;
	TextView tvPrice;
	TextView tvWorkTime;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		clinicId = getIntent().getIntExtra("Id", 1);
		setContentView(R.layout.clinic);
		
		Log.d("kim","ClinicActivity(39) clinic ID is " + clinicId);
		
		setElements();

	}

	private void setElements() {

		// 이 화면에서는 액션바를 보여주지 않는다.
		actionBar = getActionBar();
		actionBar.hide();

		tvClinicName = (TextView) findViewById(R.id.clinic_name);
		tvClinicMajor = (TextView) findViewById(R.id.clinic_major);
		tvDetail = (TextView) findViewById(R.id.tv_clinicDetail);
		tvPhoneNumber = (TextView) findViewById(R.id.tv_clinicPhone);
		tvLocation = (TextView) findViewById(R.id.tv_location);
		tvPrice = (TextView) findViewById(R.id.tv_Price);
		tvWorkTime = (TextView) findViewById(R.id.tv_workTime);

	}

}
