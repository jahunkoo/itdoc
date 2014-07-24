package com.example.hanikok.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.hanikok.R;
import com.example.util.DataTypeTranslatorUtil;
import com.example.util.Sentence;


public class D_gender extends DialogFragment implements OnItemClickListener {
	private DataTypeTranslatorUtil util = new DataTypeTranslatorUtil(); 
	private DataBridgeIF bridge;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		bridge = (DataBridgeIF) activity;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		LayoutInflater infl_gender = getActivity().getLayoutInflater();
		LinearLayout linear_gender = (LinearLayout) infl_gender.inflate(R.layout.d_gender,null);
		ListView lv_gender = (ListView) linear_gender.findViewById(R.id.list_gender);
		lv_gender.setAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, util.genders));
		lv_gender.setOnItemClickListener(this);
		
		builder.setTitle(Sentence.genderDialogTitle);
		builder.setView(linear_gender);
		
		return builder.create();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View item, int position, long arg3) {
		String selectedGender = parent.getItemAtPosition(position).toString();
		int genderCode = util.genderStrToInt(selectedGender);
		bridge.setGenderOnActivity(selectedGender, genderCode);
		this.dismiss();
		
	}
}
