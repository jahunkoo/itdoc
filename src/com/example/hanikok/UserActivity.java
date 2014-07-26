package com.example.hanikok;

import java.io.FileOutputStream;
import java.util.Properties;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.util.Sentence;

import connect.ConnectionBridge;
import dto.User;

public class UserActivity extends Activity implements View.OnClickListener {
	ActionBar actionBar = null; // 액션바 세팅 시작

	String filename = "itdot_my_info";
	FileOutputStream outputStream;

	View user_layout;
	View user_insert_layout;

	private Button facebook_btn, email_join_btn, email_login_btn;
	private String methodUrl;
	private String message;
	private EditText txt_email;
	private EditText txt_pwd, txt_name;
	// private EditTExt txt_phone, txt_age;
	private Button btn_submit;
	// private Button btn_gender;
	private Properties prop;

	private ConnectionBridge bridge = new ConnectionBridge();
	private User user = new User();

	private boolean check = false;
	private boolean isEmailInput;
	private boolean isPwdInput;
	private boolean isNameInput;

	/*
	 * private boolean isCellPhoneInput; private boolean isBirthYearInput;
	 * private boolean isGenderInput;
	 */
	private final int SUCCESS_NUM = 3;

	public InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);

		prop = new Properties();
		setLayoutElement();
		setListner();
	}

	private void setLayoutElement() {
		// TODO Auto-generated method stub
		user_layout = (View) findViewById(R.id.user_layout);
		user_insert_layout = (View) findViewById(R.id.userInsertXml);
		email_join_btn = (Button) findViewById(R.id.email_join_btn);
		email_login_btn = (Button) findViewById(R.id.email_login_btn);
		txt_email = (EditText) findViewById(R.id.txt_mail);
		txt_pwd = (EditText) findViewById(R.id.txt_pwd);
		txt_name = (EditText) findViewById(R.id.txt_name);
		btn_submit = (Button) findViewById(R.id.join_submit);

		user_insert_layout.setVisibility(View.GONE);

	}

	private void setListner() {
		// TODO Auto-generated method stub
		email_join_btn.setOnClickListener(this);
		email_login_btn.setOnClickListener(this);
		btn_submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.facebook_btn:
			break;

		case R.id.email_join_btn:
			// user_layout.setVisibility(View.GONE);
			user_insert_layout.setVisibility(View.VISIBLE);
			break;

		case R.id.email_login_btn:
			break;

		case R.id.join_submit:
			if (!getTextInformation())
				return;
			if (isAllInfoInput() == true) {
				methodUrl = "register";
				Log.d("koo", prop.toString());
				message = bridge.register(methodUrl, prop, this);
				Log.d("test", message);
				if (message.equals("exist")) {
					Toast.makeText(this, Sentence.existEmail,
							Toast.LENGTH_SHORT).show();
				} else {
					// 회원가입 성공
					// phoneBook();

					// 사용자 데이터 (이메일, 패스워드 저장)
					/*
					 * SharedPreferences user_info = getSharedPreferences(
					 * "user_info", 0); SharedPreferences.Editor editor =
					 * user_info.edit();
					 */
					SharedPreferences shared_user_info = getSharedPreferences("user_info", 0);
					SharedPreferences.Editor editor = shared_user_info.edit();
					
					editor.putString("user_email", txt_email.getText().toString());
					editor.putString("user_pwd", txt_pwd.getText().toString());
					
					editor.commit();

					Toast.makeText(this, Sentence.successJoin,
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(this,
							ProfilePictureActivity.class);
					startActivity(intent);
				}
			} else {
				Toast.makeText(this, Sentence.noInfomationMessage,
						Toast.LENGTH_LONG).show();
			}
			break;

		}

	}

	private boolean getTextInformation() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		isEmailInput = false;
		isPwdInput = false;
		isNameInput = false;
		/*
		 * isCellPhoneInput = false; isBirthYearInput = false;
		 */

		String email = txt_email.getText().toString();
		// 테스트 해보니 EditText는 입력을 안해도 공백 자체가 값으로 인식됨. 그래서 공백 여부 check
		if (email.trim().length() != 0) {
			if (!user.isEmailAddress(email)) {
				Toast.makeText(this, Sentence.notEmailType, Toast.LENGTH_SHORT)
						.show();
			} else {
				prop.put("email", email);
				isEmailInput = true;
			}
		} else {
			Toast.makeText(this, Sentence.noEmailMessage, Toast.LENGTH_SHORT)
					.show();
		}
		String password = txt_pwd.getText().toString();
		if (password.trim().length() != 0) {
			if (password.trim().length() <= 5) {
				Toast.makeText(this, Sentence.notPwdType, Toast.LENGTH_SHORT)
						.show();
			} else {
				prop.put("password", password);
				isPwdInput = true;
			}
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

		return true;
	}

	// 정보 입력이 모두 이루어졌을 때, true를 반환하는 메서드
	private boolean isAllInfoInput() {
		check = false;

		int count = 0;
		if (isEmailInput == true)
			count++;
		if (isPwdInput == true)
			count++;
		if (isNameInput == true)
			count++;
		/*
		 * if (isCellPhoneInput == true) count++; if (isBirthYearInput == true)
		 * count++; if (isGenderInput == true) count++;
		 */
		if (count == SUCCESS_NUM)
			check = true;

		return check;
	}
}
