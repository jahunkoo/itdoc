package com.example.hanikok;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;
import clinicActivity.ClinicActivity;

import com.example.hanikok.ListAdapter.SimpleClinicList;
import com.example.hanikok.dialog.LocationDialog;

import connect.ConnectionBridge;

public class MainActivity extends FragmentActivity implements OnClickListener, android.widget.AbsListView.OnScrollListener, OnItemClickListener {

	public static String userId;
	private short currentTab = 0; // 현재 탭상태 받는 것
	private boolean isPressed = false; // 두번 누르면 종료 되기 위한 조건
	Handler mHandler = null;

	TabHost tabHost = null; // 탭뷰 세팅
	ActionBar actionBar = null; // 액션바 세팅 시작

	// ----------------뜨는 의원 카테고리---------------------------//
	ImageView goPopView, goEditorlView; // 인기순, 에디터순 버튼
	GridView pop_grid; // 인기순 그리드뷰
	GridView editor_grid; // 에디터순 그리드뷰
	View popView, editorView; // 인기순, 에디터순 레이아웃
	// -----------------------------------------------------------//

	// ------------------소식 카테고리-----------------------------//
	ImageView goReView, goTotalView, goFollowView; // 리뷰어, 전체, 팔로우 순 버튼
	View reView, totalView, followView; // 리뷰어, 전체, 팔로우 순 레이아웃
	// -----------------------------------------------------------//

	// ------------------검색 카테고리-----------------------------//
	AutoCompleteTextView  goSearchView1; // 한이원 이름 또는 병명 검색창
	ImageView goSearchView2; // 지역 또는 지하철역 검색창
	ImageView goSearchView3; // 사람 이름 또는 리스트이름 검색창
	View searchView1, searchView2, searchView3; // 검색창 레이아웃
	View searchView_up; // 슬레이트 레이아웃
	View searchView_down;
	Button searchCancel;
	// -----------------------------------------------------------//

	private Animation mTranslateUpAnim;
	private Animation aniShow, aniHide;
	private boolean open = false;

	// ------------------소식 카테고리-----------------------------//
	ListView mListView;
	private boolean mLockListView;
	private ListAdapter listAdapter;
	private LayoutInflater mInflater;

	// -----------------------------------------------------------//
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		aniShow = AnimationUtils.loadAnimation(this, R.anim.translate_up);
		aniHide = AnimationUtils.loadAnimation(this, R.anim.left_out);

		setElements(); // 객체 생성부분, 리스너 세팅 부분 묶은 함수

		tabSetting(); // 탭뷰 호출

		initPoplView();// 인기순 레이아웃 부터 보여줌

		initReView(); // 리뷰어 레이아웃 부터 보여줌

		// initSearchView(); // 검색 레이아웃 보여줌

		actionBar.setTitle("뜨는 의원");

	}

	private void setElements() {

		// -------------뜨는의원 카테고리-----------------------------//
		// 인기순, 에디터순 버튼 등록
		goPopView = (ImageView) findViewById(R.id.PopView_btn);
		goEditorlView = (ImageView) findViewById(R.id.EditorView_btn);
		goPopView.setOnClickListener(this);
		goEditorlView.setOnClickListener(this);

		// 인기순, 에디터순 레이아웃(xml)등록
		popView = (View) findViewById(R.id.popInfoXml);
		editorView = (View) findViewById(R.id.editorInfoXml);

		// 인기순, 에디터순 그리드뷰 등록
		pop_grid = (GridView) findViewById(R.id.gridview_pop);
		pop_grid.setAdapter(new MyAdapter(this));
		editor_grid = (GridView) findViewById(R.id.gridview_editor);
		editor_grid.setAdapter(new MyAdapter(this));
		// --------------------------------------------------------//

		// -------------소식 카테고리-------------------------------//
		// 리뷰어, 전체, 팔로우순 버튼 등록
		goReView = (ImageView) findViewById(R.id.ReView_btn);
		goTotalView = (ImageView) findViewById(R.id.TotalView_btn);
		goFollowView = (ImageView) findViewById(R.id.FollowView_btn);
		goReView.setOnClickListener(this);
		goTotalView.setOnClickListener(this);
		goFollowView.setOnClickListener(this);

		// 인기순, 에디터순 레이아웃(xml)등록
		reView = (View) findViewById(R.id.reViewInfoXml);
		totalView = (View) findViewById(R.id.totalViewInfoXml);
		followView = (View) findViewById(R.id.followViewInfoXml);
		// --------------------------------------------------------//

		// -------------검색 카테고리-------------------------------//
		goSearchView1 = (AutoCompleteTextView) findViewById(R.id.SearchView_btn1);
		goSearchView2 = (ImageView) findViewById(R.id.SearchView_btn2);
		goSearchView3 = (ImageView) findViewById(R.id.SearchView_btn3);
		goSearchView1.setOnClickListener(this);
		goSearchView2.setOnClickListener(this);
		goSearchView3.setOnClickListener(this);
		searchCancel = (Button) findViewById(R.id.search_cancel);
		searchCancel.setOnClickListener(this);
		// 검색창 레이아웃(xml)등록
		// searchView1 = (View) findViewById(R.id.searchViewInfoXml);
		// searchView2 = (View) findViewById(R.id.searchViewInfoXml);
		// searchView3 = (View) findViewById(R.id.searchViewInfoXml);
		// searchView_up = (View) findViewById(R.id.searchEditInfoXml);
		searchView_up = (View) findViewById(R.id.includeLayout4);
		// searchView_down = (View) findViewById(R.id.topMenuLinearlayout4);
		searchView_down = (View) findViewById(R.id.tabhost);
		// searchView1.setVisibility(View.VISIBLE);
		searchView_up.setVisibility(View.GONE);

		// 자동 완성 기능을 위한 키워드들의 리스트를 위해 만든 ArrayList
		ArrayList<String> allKeywordsList = new ArrayList<String>();
		
		// 모든 키워드를 받아 오도록 만든 url과 통신하여 키워드를 리스트화 시킨다.
		ConnectionBridge keywordConnection = new ConnectionBridge();
		allKeywordsList = keywordConnection.getAllKeywords("getAllKeywords", this);
		ArrayAdapter<String> keywordsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, allKeywordsList);
		goSearchView1.setAdapter(keywordsAdapter);

		// --------------------------------------------------------//

		// 근처 리스트 뷰 등록
		listAdapter = new ListAdapter(this);
		addItems(12);

		mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// mListView.addFooterView(mInflater.inflate(R.layout.footer, null));

		mListView = (ListView) findViewById(R.id.near_Listview);
		mListView.setAdapter(listAdapter);
		mListView.setOnItemClickListener(this);
		mListView.setOnScrollListener(this);
		mLockListView = false;

		// 액션바에 객체 할당
		actionBar = getActionBar();

		// 핸들러에 2초 대기 저장

		mHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {

				if (msg.what == 0) {
					isPressed = false;
				}
			}
		};
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

		// 인기순, 에디터순 버튼을 눌렀을 때 해당 레이아웃을 보여줌.
		case R.id.PopView_btn:
			initPoplView();
			break;

		case R.id.EditorView_btn:
			initEditorView();
			break;

		// 리뷰어, 전체, 팔로우 버튼을 눌렀을 때 해당 레이아웃을 보여줌.
		case R.id.ReView_btn:
			initReView();
			break;

		case R.id.TotalView_btn:
			initTotalView();
			break;

		case R.id.FollowView_btn:
			initFollowView();
			break;

		case R.id.SearchView_btn1:
			// changeImage();
			// searchView_up.setVisibility(View.VISIBLE);
			// searchView_up.bringToFront();
			// searchView_up.setVisibility(View.VISIBLE);
			// searchView_up.startAnimation(mTranslateUpAnim);
			// searchView_down.setVisibility(View.GONE); // 탭뷰 숨김
			// searchView_up.setVisibility(View.VISIBLE); // 검색창을 보여줌
			// searchView_up.startAnimation(aniShow); // 애니메이션 효과
			// Intent intent = new Intent(getBaseContext(),
			// LocalListActivity.class);
			// startActivity(intent);

			// searchView_down.setVisibility(View.GONE);

			break;

		case R.id.SearchView_btn2:
			// changeImage();
			LocationDialog locationDialog = LocationDialog.newInstance();
			locationDialog.show(getSupportFragmentManager(), "location");

			break;

		case R.id.SearchView_btn3:
			// changeImage();
			break;
		case R.id.search_cancel:
			searchView_up.setVisibility(View.GONE);
			searchView_down.setVisibility(View.VISIBLE);
			break;
		}
	}

	@Override
	public void onBackPressed() {

		if (searchView_up.getVisibility() == View.VISIBLE) {
			searchView_up.setVisibility(View.GONE);
			searchView_down.setVisibility(View.VISIBLE);
		} else {

			if (!isPressed) {
				Toast.makeText(MainActivity.this, "'뒤로'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
				isPressed = true;
				mHandler.sendEmptyMessageDelayed(0, 2000);
			} else {
				super.onBackPressed();
			}
		}
	}

	public class PageAnimationListener implements AnimationListener {

		public void onAnimationEnd(Animation arg0) {
			// 애니메이션이 종료 되었을때 나머지 뷰들은 보이지 않게 한다.
			/*
			 * if (imageIndex == 0) { mImgView02.setVisibility(View.INVISIBLE);
			 * mImgView03.setVisibility(View.INVISIBLE);
			 * 
			 * } else if (imageIndex == 1) {
			 * mImgView01.setVisibility(View.INVISIBLE);
			 * mImgView03.setVisibility(View.INVISIBLE);
			 * 
			 * } else if (imageIndex == 2) {
			 * mImgView01.setVisibility(View.INVISIBLE);
			 * mImgView02.setVisibility(View.INVISIBLE);
			 * 
			 * }
			 */
		}

		public void onAnimationRepeat(Animation arg0) {
			// TODO Auto-generated method stub

		}

		public void onAnimationStart(Animation arg0) {
			// TODO Auto-generated method stub

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

	// 리뷰어 레이아웃
	private void initReView() {
		totalView.setVisibility(View.GONE);// 전체 레이아웃 숨김
		followView.setVisibility(View.GONE);// 팔로우 레이아웃 숨김
		reView.setVisibility(View.VISIBLE);// 리뷰어 레이아웃 보여줌
		goReView.setImageResource(R.drawable.review_btn_over); // 리뷰어 버튼 롤오버
		goTotalView.setImageResource(R.drawable.total_btn_open); // 전체 버튼
		goFollowView.setImageResource(R.drawable.follow_btn_open); // 팔로우 버튼
	}

	// 전체 레이아웃
	private void initTotalView() {
		totalView.setVisibility(View.VISIBLE);// 전체 레이아웃 보여줌
		followView.setVisibility(View.GONE);// 팔로우 레이아웃 숨김
		reView.setVisibility(View.GONE);// 리뷰어 레이아웃 숨김
		goReView.setImageResource(R.drawable.review_btn_open); // 리뷰어 버튼
		goTotalView.setImageResource(R.drawable.total_btn_over); // 전체 버튼 롤오버
		goFollowView.setImageResource(R.drawable.follow_btn_open); // 팔로우 버튼
	}

	// 팔로우 레이아웃
	private void initFollowView() {
		totalView.setVisibility(View.GONE);// 전체 레이아웃 숨김
		followView.setVisibility(View.VISIBLE);// 팔로우 레이아웃 숨김
		reView.setVisibility(View.GONE);// 리뷰어 레이아웃 보여줌
		goReView.setImageResource(R.drawable.review_btn_open); // 리뷰어 버튼
		goTotalView.setImageResource(R.drawable.total_btn_open); // 전체 버튼
		goFollowView.setImageResource(R.drawable.follow_btn_over); // 팔로우 버튼 롤오버
	}

	// 검색 레이아웃
	private void initSearchView() {
		// totalView.setVisibility(View.GONE);// 전체 레이아웃 숨김
		// followView.setVisibility(View.VISIBLE);// 팔로우 레이아웃 숨김
		// reView.setVisibility(View.GONE);// 리뷰어 레이아웃 보여줌
		// searchView1.setVisibility(View.GONE);// 검색 레이아웃 보여줌
		// searchView_up.setVisibility(View.VISIBLE);

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
			public void onTabChanged(String tabId) { // 각각의 탭이 변할때의 리스너
				if ("Tab1".equals(tabId)) {
					currentTab = 0;
					actionBar.setTitle("뜨는 의원");
					actionBar.setDisplayHomeAsUpEnabled(false);
				}
				if ("Tab2".equals(tabId)) {
					currentTab = 1;
					actionBar.setTitle("소식");
				}
				if ("Tab3".equals(tabId)) {
					currentTab = 2;
					actionBar.setTitle("주변");
				}
				if ("Tab4".equals(tabId)) {
					currentTab = 3;
					actionBar.setTitle("검색");
				}
				if ("Tab5".equals(tabId)) { // 설정을 누를때 새로운 액티비티를 연다
					tabHost.setCurrentTab(currentTab); // 설정을 누르기 전의 탭의 상태로 변환
														// 한다.
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

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		int count = totalItemCount - visibleItemCount;

		/*
		 * Log.d("kim", "firstVisibleItem is " + firstVisibleItem); Log.d("kim",
		 * "visibleItemCount is " + visibleItemCount); Log.d("kim",
		 * "totalItemCount is " + totalItemCount); Log.d("kim", "count is " +
		 * count); Log.d("kim", "mLockListView is " + mLockListView);
		 */

		if (firstVisibleItem >= count && totalItemCount != 0 && mLockListView == false) {
			addItems(12);
		}

	}

	private void addItems(final int size) {
		// 아이템을 추가하는 동안 중복 요청을 방지하기 위해 락을 걸어둡니다.
		mLockListView = true;

		Runnable run = new Runnable() {
			@Override
			public void run() {

				mLockListView = false;
			}

		};

		Handler handler = new Handler();
		handler.postDelayed(run, 300);

	}

	private String[] mStrings = { "http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test1.png", "http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test2.jpg",
			"http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test3.jpg", "http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test4.png",
			"http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test5.png", "http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test6.png",
			"http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test7.png", "http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test8.png",
			"http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test9.png", "http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test10.png",
			"http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test11.png", "http://yss159.cafe24.com:8080/ItDocImgServer/getPicture?pictureName=test12.png"

	};

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		SimpleClinicList simpleClinicList = (SimpleClinicList) parent.getAdapter().getItem(position);

		int clinicId = simpleClinicList.getId();

		Log.d("kim", "MainActivity(592) clinicId = " + clinicId);

		Intent intent = new Intent(MainActivity.this, ClinicActivity.class);
		intent.putExtra("Id", clinicId);
		startActivity(intent);

	}

}
