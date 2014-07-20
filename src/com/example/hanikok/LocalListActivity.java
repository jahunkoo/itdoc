package com.example.hanikok;

import android.app.ListActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LocalListActivity extends ListActivity {
	
	TextView Selection;
	String[] items = {"������","��û��","������","������","�⼺��","����ö","Ȳ��ȫ"};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Window feature for no title - must be set prior to calling setContentView.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.local_list);        
        
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
        //Selection = (TextView)findViewById(R.id.selection);
    }    
}