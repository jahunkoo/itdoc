package com.example.hanikok;

import java.util.Properties;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.util.Sentence;

public class UserInsert extends Activity implements OnClickListener {

	private boolean isEmailInput;
	private boolean isPwdInput;
	private boolean isNameInput;
	private boolean isPhoneInput;
	private boolean isAgeInput;
	private boolean isGenderInput;

	private EditText txt_email, txt_pwd, txt_name, txt_phone, txt_age;
	private Button btn_submit, btn_gender;
	private Properties prop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_insert);

		setLayoutElement();
		setListner();
	}

	private void setLayoutElement() {
		// TODO Auto-generated method stub
		txt_email = (EditText) findViewById(R.id.txt_email);
		txt_pwd = (EditText) findViewById(R.id.txt_pwd);
		txt_name = (EditText) findViewById(R.id.txt_name);
		txt_phone = (EditText) findViewById(R.id.txt_phone);
		txt_age = (EditText) findViewById(R.id.txt_age);
		btn_gender = (Button) findViewById(R.id.btn_gender);
		btn_submit = (Button) findViewById(R.id.join_submit);
	}

	private void setListner() {
		// TODO Auto-generated method stub
		btn_submit.setOnClickListener(this);
		btn_gender.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// 중복클릭 막기
		v.setClickable(false);

		if (v.getId() == btn_submit.getId()) {
			if (!getTextInformation())
				return;
			else{
				Toast.makeText(this, Sentence.noInfomationMessage, Toast.LENGTH_LONG).show();
			}
			

		}
	}

	private boolean getTextInformation() {
		// TODO Auto-generated method stub
		isEmailInput = false;
		isPwdInput = false;
		isNameInput = false;
		isPhoneInput = false;

		String email = txt_email.getText().toString();
		// 테스트 해보니 EditText는 입력을 안해도 공백 자체가 값으로 인식됨. 그래서 공백 여부 check
		if (email.trim().length() != 0) {
			prop.put("email", email);
			isEmailInput = true;
		} else {
			Toast.makeText(this, Sentence.noNameMessage, Toast.LENGTH_SHORT)
					.show();
		}
		String pwd = txt_pwd.getText().toString();
		if (pwd.trim().length() != 0) {
			prop.put("password", pwd);
			isPwdInput = true;
		} else {
			Toast.makeText(this, Sentence.noPwdMessage, Toast.LENGTH_SHORT)
					.show();
		}
		String name = txt_name.getText().toString();
		if (name.trim().length() != 0) {
			prop.put("name", name);
			isNameInput = true;
		} else {
			Toast.makeText(this, Sentence.noNameMessage, Toast.LENGTH_SHORT)
					.show();
		}
		String phone = txt_phone.getText().toString();
		if (phone.trim().length() != 0) {
			prop.put("password", phone);
			isPhoneInput = true;
		} else {
			Toast.makeText(this, Sentence.noPhoneMessage, Toast.LENGTH_SHORT)
					.show();
		}

		return false;
	}

}
