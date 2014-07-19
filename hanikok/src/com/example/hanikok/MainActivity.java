package com.example.hanikok;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private short currentTab = 0; // 현재 탭상태 받는 것

	GridView pop_grid; // 인기순 그리드뷰
	GridView editor_grid; // 에디터순 그리드뷰
	ImageView goPopView, goEditorlView; // 인기순, 에디터순 버튼
	View popView, editorView; // 인기순, 에디터순 레이아웃
	TabHost tabHost = null; // 탭뷰 세팅
	ActionBar actionBar = null; //액션바 세팅 시작
	
	ListView near_list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setElements(); // 객체 생성부분, 리스너 세팅 부분 묶은 함수
		
		tabSetting(); // 탭뷰 호출

		initPoplView();// 인기순 레이아웃 부터 보여줌

		actionBar.setTitle("뜨는 의원");
		
		
		

	}
	
	private void setElements(){

		// 인기순, 에디터순 그리드뷰 등록
		pop_grid = (GridView) findViewById(R.id.gridview_pop);
		pop_grid.setAdapter(new MyAdapter(this));
		editor_grid = (GridView) findViewById(R.id.gridview_editor);
		editor_grid.setAdapter(new MyAdapter(this));

		//근처 리스트 뷰 등록
		near_list = (ListView) findViewById(R.id.near_Listview);
		near_list.setAdapter(new ListAdapter(getApplicationContext()));
		
		
		// 인기순, 에디터순 버튼 등록
		goPopView = (ImageView) findViewById(R.id.PopView_btn);
		goEditorlView = (ImageView) findViewById(R.id.EditorView_btn);
		goPopView.setOnClickListener(this);
		goEditorlView.setOnClickListener(this);

		// 인기순, 에디터순 레이아웃(xml)등록
		popView = (View) findViewById(R.id.popInfoXml);
		editorView = (View) findViewById(R.id.editorInfoXml);

		
		
		//액션바에 객체 할당
		actionBar = getActionBar();
	}

	
	
	
	
	public class MyAdapter extends BaseAdapter {

		private List<Item> items = new ArrayList<Item>();
		private LayoutInflater inflator;

		public MyAdapter(Context context) {
			// TODO Auto-generated constructor stub
			inflator = LayoutInflater.from(context);
			items.add(new Item("생명마루 한의원", "서울 강남구", "Like : 87", R.drawable.image_1));
			items.add(new Item("편강 한의원", "서울 중구", "Like:77", R.drawable.image_2));
			items.add(new Item("특별한별 한의원", "서울 성동구", "Like : 67", R.drawable.image_3));
			items.add(new Item("맑은숲 한의원", "서울 강남구", "Like:56", R.drawable.image_4));
			items.add(new Item("삼성 한의원", "서울 노원구", "Like:43", R.drawable.image_5));
			items.add(new Item("고운누리 한의원", "서울 강서구", "Like:41", R.drawable.image_6));
			items.add(new Item("풀입 한의원", "서울 강남구", "Like:31", R.drawable.image_7));
			items.add(new Item("경희 한의원", "서울 성북구", "Like:21", R.drawable.image_8));
			items.add(new Item("한림 병원", "서울 중구", "Like:20", R.drawable.image_9));
			items.add(new Item("버드나무 한의원", "서울 강남구", "Like:17", R.drawable.image_10));
			items.add(new Item("자연과 한의원", "서울 용산구", "Like:11", R.drawable.image_11));
			items.add(new Item("선재 한의원", "서울 동대문구", "Like:5", R.drawable.image_12));

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return items.get(position).drawableId;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View v = convertView;
			ImageView img1;
			TextView txt1;
			TextView txt2;
			TextView txt3;
			if (v == null) {
				v = inflator.inflate(R.layout.grid_item, parent, false);
				v.setTag(R.id.picture, v.findViewById(R.id.picture));
				v.setTag(R.id.text, findViewById(R.id.text));
				v.setTag(R.id.text, findViewById(R.id.text_local));
				v.setTag(R.id.text, findViewById(R.id.text_like));

			}

			img1 = (ImageView) v.findViewById(R.id.picture);
			txt1 = (TextView) v.findViewById(R.id.text);
			txt2 = (TextView) v.findViewById(R.id.text_local);
			txt3 = (TextView) v.findViewById(R.id.text_like);

			Item item = (Item) getItem(position);

			img1.setImageResource(item.drawableId);
			txt1.setText(item.name);
			txt2.setText(item.local);
			txt3.setText(item.like);

			return v;
		}

	}

	private class Item {
		final String name;
		final String local;
		final String like;
		final int drawableId;

		Item(String name, String local, String like, int drawableId) {
			this.name = name;
			this.local = local;
			this.like = like;
			this.drawableId = drawableId;

		}
	}

	public void onClick(View v) {

		switch (v.getId()) {

		// 인기순, 에디터순 버튼 눌렀을 때 해당 레이아웃을 보여줌.
		case R.id.PopView_btn:
			initPoplView();
			break;

		case R.id.EditorView_btn:
			initEditorView();
			break;
		}
	}

	// 인기순 레이아웃
	private void initPoplView() {
		editorView.setVisibility(View.GONE);// 에디터 레이아웃 숨김
		popView.setVisibility(View.VISIBLE);// 인기순 레이아웃 보여줌
		goPopView.setImageResource(R.drawable.pop_btn_over); // 인기순 버튼 롤오버
		goEditorlView.setImageResource(R.drawable.editor_btn_open); // 에디터순 디폴트
																	// 버튼
	}

	// 에디터순 레이아웃
	private void initEditorView() {
		editorView.setVisibility(View.VISIBLE);
		popView.setVisibility(View.GONE);
		goPopView.setImageResource(R.drawable.pop_btn_open);
		goEditorlView.setImageResource(R.drawable.editor_btn_over);

	}

	private void tabSetting() {

		ImageView mainmenu_1 = new ImageView(this);
		mainmenu_1.setImageResource(R.drawable.main_menu_1);

		ImageView mainmenu_2 = new ImageView(this);
		mainmenu_2.setImageResource(R.drawable.main_menu_2);

		ImageView mainmenu_3 = new ImageView(this);
		mainmenu_3.setImageResource(R.drawable.main_menu_3);

		ImageView mainmenu_4 = new ImageView(this);
		mainmenu_4.setImageResource(R.drawable.main_menu_4);

		ImageView mainmenu_5 = new ImageView(this);
		mainmenu_5.setImageResource(R.drawable.main_menu_5);

		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) { //각각의 탭이 변할때의 리스너
				if ("Tab1".equals(tabId)) {
					currentTab = 0;
					actionBar.setTitle("뜨는 의원");
				}
				if ("Tab2".equals(tabId)) {
					currentTab = 1;
					actionBar.setTitle("소식");
				}
				if ("Tab3".equals(tabId)) {
					currentTab = 2;
					actionBar.setTitle("추천");
				}
				if ("Tab4".equals(tabId)) {
					currentTab = 3;
					actionBar.setTitle("검색");
				}
				if ("Tab5".equals(tabId)) { //설정을 누를때 새로운 액티비티를 연다
					tabHost.setCurrentTab(currentTab); // 설정을 누르기 전의 탭의 상태로 변환 한다.
					Intent intent = new Intent(MainActivity.this, profileActivity.class);
					startActivity(intent);
				}
			}
			
			
		});
		tabHost.setup();

		// Tab1 Setting
		TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
		tabSpec1.setIndicator(mainmenu_1); // Tab Subject
		tabSpec1.setContent(R.id.tab1); // Tab Content
		tabHost.addTab(tabSpec1);

		// Tab2 Setting
		TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
		tabSpec2.setIndicator(mainmenu_2); // Tab Subject
		tabSpec2.setContent(R.id.tab2); // Tab Content
		tabHost.addTab(tabSpec2);

		// Tab3 Setting
		TabSpec tabSpec3 = tabHost.newTabSpec("Tab3");
		tabSpec3.setIndicator(mainmenu_3); // Tab Subject
		tabSpec3.setContent(R.id.tab3); // Tab Content
		tabHost.addTab(tabSpec3);

		// Tab4 Setting
		TabSpec tabSpec4 = tabHost.newTabSpec("Tab4");
		tabSpec4.setIndicator(mainmenu_4); // Tab Subject
		tabSpec4.setContent(R.id.tab4); // Tab Content
		tabHost.addTab(tabSpec4);

		// Tab5 Setting
		TabSpec tabSpec5 = tabHost.newTabSpec("Tab5");
		tabSpec5.setIndicator(mainmenu_5); // Tab Subject
		tabSpec5.setContent(R.id.tab5); // Tab Content
		tabHost.addTab(tabSpec5);

		// show First Tab Content
		tabHost.setCurrentTab(0);
	}

	

}
