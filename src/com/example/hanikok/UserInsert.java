package com.example.hanikok;

import java.io.IOException;
import java.util.Properties;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hanikok.dialog.D_gender;
import com.example.hanikok.dialog.DataBridgeIF;
import com.example.util.Sentence;

import connect.ConnectionBridge;
import dto.User;

public class UserInsert extends Activity implements View.OnClickListener {
	ActionBar actionBar = null; // 액션바 세팅 시작
	
	View user_layout;
	View user_insert_layout;
	
	private String methodUrl;
	private String message;
	private EditText txt_email, txt_pwd, txt_name;
	//private EditTExt txt_phone, txt_age;
	private Button btn_submit, btn_gender;
	private Properties prop;

	private ConnectionBridge bridge = new ConnectionBridge();
	private User user = new User();

	private boolean check = false;
	private boolean isEmailInput;
	private boolean isPwdInput;
	private boolean isNameInput;
/*	private boolean isCellPhoneInput;
	private boolean isBirthYearInput;
	private boolean isGenderInput;*/
	private final int SUCCESS_NUM = 3;

	public InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_insert);
		
		user_layout = (View)findViewById(R.id.user_layout);
		user_insert_layout = (View)findViewById(R.id.user_insert_layout);
	//	user_layout.setVisibility(View.VISIBLE);
	//	user_insert_layout.setVisibility(View.GONE);

		prop = new Properties();
		setLayoutElement();
		setListner();
	}

	private void setLayoutElement() {
		// TODO Auto-generated method stub
		actionBar = getActionBar();
		actionBar.setTitle("회원가입");
		
		txt_email = (EditText) findViewById(R.id.txt_mail);
		txt_pwd = (EditText) findViewById(R.id.txt_pwd);
		txt_name = (EditText) findViewById(R.id.txt_name);
	/*	txt_phone = (EditText) findViewById(R.id.txt_cell);
		txt_age = (EditText) findViewById(R.id.txt_age);
		btn_gender = (Button) findViewById(R.id.btn_gender);
		*/
		btn_submit = (Button) findViewById(R.id.join_submit);
	}

	private void setListner() {
		// TODO Auto-generated method stub
		btn_gender.setOnClickListener(this);
		btn_submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == btn_submit.getId()) {
			if(!getTextInformation()) return;
			if(isAllInfoInput() == true) {
				methodUrl = "register";
				Log.d("koo", prop.toString());
				message = bridge.register(methodUrl, prop, this);
				Log.d("test",message);
				if(message.equals("exist"))
				{
					Toast.makeText(this, Sentence.existEmail, Toast.LENGTH_SHORT)
					.show();
				}
				else
				{
					phoneBook();
					Toast.makeText(this, Sentence.successJoin, Toast.LENGTH_SHORT)
					.show();
					Intent intent = new Intent(this,profileActivity.class);
					startActivity(intent);
				}
			}else{
				Toast.makeText(this, Sentence.noInfomationMessage,Toast.LENGTH_LONG).show();
			}
		}
		
		else if (v.getId() == btn_gender.getId()) {
			D_gender dial_gender = new D_gender();
			dial_gender.show(getFragmentManager(), "SignUp");
		}
	}

	private Cursor getURI() 
    {
        // 주소록 URI        
        Uri people = Contacts.CONTENT_URI;
        
        // 검색할 컬럼 정하기
        String[] projection = new String[] { Contacts._ID, Contacts.DISPLAY_NAME, Contacts.HAS_PHONE_NUMBER };
        
        // 쿼리 날려서 커서 얻기
        String[] selectionArgs = null;
        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";    

        // managedquery 는 activity 메소드이므로 아래와 같이 처리함
        return getContentResolver().query(people, projection, null, selectionArgs, sortOrder);
        // return managedQuery(people, projection, null, selectionArgs, sortOrder);
    }
	
	public void phoneBook() {
        Cursor cursor = getURI();                    // 전화번호부 가져오기    

		int end = cursor.getCount();                // 전화번호부의 갯수 세기
		Log.d("kkm_phone", "end = "+end);

		String [] name = new String[end];    // 전화번호부의 이름을 저장할 배열 선언
		String [] phone = new String[end];    // 전화번호부의 이름을 저장할 배열 선언
		int count = 0;    

		if(cursor.moveToFirst()) 
		{
		    // 컬럼명으로 컬럼 인덱스 찾기 
		    int idIndex = cursor.getColumnIndex("_id");

		    do 
		    {
		//        tempItem = new TempItem();
		        
		        // 요소값 얻기
		        int id = cursor.getInt(idIndex);        
		        String phoneChk = cursor.getString(2);
		        if (phoneChk.equals("1")) {
		            Cursor phones = getContentResolver().query(
		                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
		                    null,
		                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID
		                            + " = " + id, null, null);

		            while (phones.moveToNext()) {
		                phone[count] = phones
		                        .getString(phones
		                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
		            }        
		        }
		        name[count] = cursor.getString(1);

		        // 개별 연락처 삭제                    
		        // rowNum = getBaseContext().getContentResolver().delete(RawContacts.CONTENT_URI, RawContacts._ID+ " =" + id,null);

		        // LogCat에 로그 남기기
		        Log.d("kkm_phone", "id=" + id +", name["+count+"]=" + name[count]+", phone["+count+"]=" + phone[count]);
		        count++;
		        
		    } while(cursor.moveToNext() || count > end);
		}
    }

	
	private boolean getTextInformation() {
		// TODO Auto-generated method stub
		isEmailInput = false;
		isPwdInput = false;
		isNameInput = false;
/*		isCellPhoneInput = false;
		isBirthYearInput = false;*/
	
		
		String email = txt_email.getText().toString();
		// 테스트 해보니 EditText는 입력을 안해도 공백 자체가 값으로 인식됨. 그래서 공백 여부 check
		if (email.trim().length() != 0) {
			if(!user.isEmailAddress(email))
			{
				Toast.makeText(this, Sentence.notEmailType, Toast.LENGTH_SHORT)
				.show();
			}
			else{
				prop.put("email", email);
				isEmailInput = true;
			}
		} else {
			Toast.makeText(this, Sentence.noEmailMessage, Toast.LENGTH_SHORT)
					.show();
		}
		String password = txt_pwd.getText().toString();
		if (password.trim().length() != 0) {
			if(password.trim().length()<=5)
			{
				Toast.makeText(this, Sentence.notPwdType, Toast.LENGTH_SHORT)
				.show();
			}
			else{
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
	/*	String cellPhone = txt_phone.getText().toString();
		if (cellPhone.trim().length() != 0) {
			prop.put("cellPhone", cellPhone);
			isCellPhoneInput = true;
		} else {
			Toast.makeText(this, Sentence.noPhoneMessage, Toast.LENGTH_SHORT)
					.show();
		}
		String birthYear = txt_age.getText().toString();
		if (birthYear.trim().length() != 0) {
			int int_birthYear = Integer.parseInt(birthYear);
			if(int_birthYear>=1900 && int_birthYear<=2014)
			{
				prop.put("birthYear", birthYear);
				isBirthYearInput = true;
			}
			else
			{
				Toast.makeText(this, User.NOT_CORRECT_BIRTH_YEAR, Toast.LENGTH_SHORT)
				.show();
			}
		} else {
			Toast.makeText(this, Sentence.noAgeMessage, Toast.LENGTH_SHORT)
					.show();
		}*/

		return true;
	}

	// 정보 입력이 모두 이루어졌을 때, true를 반환하는 메서드
	private boolean isAllInfoInput() {
		check = false;

		int count = 0;
		if (isEmailInput == true) count++;
		if (isPwdInput == true)	count++;
		if (isNameInput == true) count++;
	/*	if (isCellPhoneInput == true) count++;
		if (isBirthYearInput == true)	count++;
		if (isGenderInput == true) count++;*/
		if (count == SUCCESS_NUM) check = true;
		return check;
	}

	// ------------------------- 다이얼로그 창에서 받은 값을 처리하는 부분-------------------------
	/*@Override
	public void setGenderOnActivity(String gender, int genderCode) {
		btn_gender.setText(gender);
		prop.put("gender", "" + genderCode);
		isGenderInput = true;
	}
*/

}
