package com.example.hanikok;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

public class PhoneBook {
	Uri ContactsUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
	
	String disId = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
	String disName = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
	String number = ContactsContract.CommonDataKinds.Phone.NUMBER;
	
/*	Cursor cursor = getContentResolver().query(ContactsUri, new String[]{disId, disName, number},null, null, null);
	Global.friendId = new long[cursor.getCount()];
	private Object getContentResolver() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
