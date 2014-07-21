package com.example.hanikok;

import java.util.ArrayList;

import util.ItDocConstants;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import connect.ConnectionBridge;
import dto.BigRegion;
import dto.Grade;
import dto.MiddleRegion;
import dto.Time;
import dto.Week;

public class IntroActivity extends Activity // ��Ʈ�� �κ� ��Ƽ��Ƽ
{

	// 지역정보 및 데이터를 저장할 리스트 생성
	public static ArrayList<BigRegion> bigReionList;
	public static ArrayList<MiddleRegion> middleReionList;
	public static ArrayList<Grade> gradeList;
	public static ArrayList<Week> weekList;
	public static ArrayList<Time> timeList;

	// 핸들러 선언 안드로이드 UI 접근은 쓰레드->핸들로->UI를 통해서만 가능함
	public Handler bigRegionHandler = new Handler();
	public Handler middleRegionHandler = new Handler();
	public Handler gradeHandler = new Handler();
	public Handler timeHandler = new Handler();
	public Handler weekHandler = new Handler();

	ImageView intro;
	ImageView intro2;
	ActionBar actionBar = null; // 액션바 세팅 시작

	// 성공할 경우와 실패할 경우를 고려해야함 성공하면 1 실패하면 2 (다시 보내야 함)
	public Thread RegionThread = new Thread(new Runnable() {

		@Override
		public void run() {
			bigRegionHandler.post(bigRegionRunnable);
			middleRegionHandler.post(middleRegionRunnable);
			gradeHandler.post(gradeRunnable);
			timeHandler.post(timeRunnable);
			weekHandler.post(weekRunnable);
		}
	});

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		actionBar = getActionBar();
		actionBar.hide();
		setContentView(R.layout.intro);
		

		new Thread(new Runnable() {
			public void run() {
				try {

					intro = (ImageView) findViewById(R.id.intro_Img); // ��Ʈ��
																		// �̹���
																		// ����
					//Animation alphaAnim = AnimationUtils.loadAnimation(
						//	IntroActivity.this, R.anim.alpha); // �ִ� ���� ����
					//intro.startAnimation(alphaAnim);
					Thread.sleep(1000); // 3�ʰ� �ΰ? �����ش�. ��Ʈ�� �����̺κ�
					isIntro();
					//RegionThread.start();

				}

				catch (Exception e) {
				}

			}

		}).start();

	}
	
	Runnable bigRegionRunnable = new Runnable() {
		public void run() {
			bigReionList = new ConnectionBridge()
			.getBigRegionList(
					ItDocConstants.METHOD_URL_GET_BIG_REGION_LIST,
					IntroActivity.this);
	Log.d("Big","Success");
			/*ArrayList<BigRegion> bigRegionList = new ConnectionBridge()
					.getBigRegionList(
							ItDocConstants.METHOD_URL_GET_BIG_REGION_LIST,
							IntroActivity.this);
			Log.d("Big","Success");*/
			//String tmpStr = new String();
			//for (BigRegion bigRegion : bigRegionList) {
			//	tmpStr += bigRegion.toString();
			//	tmpStr += "\n";
			//}
			//print(tmpStr);
		}
	};
	
	Runnable middleRegionRunnable = new Runnable() {
		public void run() {
			ArrayList<MiddleRegion> middleRegionList = new ConnectionBridge()
					.getMiddleRegionList(
							ItDocConstants.METHOD_URL_GET_MIDDLE_REGION_LIST,
							IntroActivity.this);

			/*String tmpStr = new String();
			for (MiddleRegion middleRegion : middleRegionList) {
				tmpStr += middleRegion.toString();
				tmpStr += "\n";
			}
			print(tmpStr);*/
		}
	};
	

	Runnable gradeRunnable = new Runnable() {
		public void run() {
			ArrayList<Grade> gradeList = new ConnectionBridge()
					.getGradeList(
							ItDocConstants.METHOD_URL_GET_GRADE_LIST,
							IntroActivity.this);

			//String tmpStr = new String();
			//for (Grade grade : gradeList) {
				//tmpStr += grade.toString();
				//tmpStr += "\n";
		//	}
			//print(tmpStr);
		}
	};
	
	Runnable weekRunnable = new Runnable() {
		public void run() {
			ArrayList<Week> weekList = new ConnectionBridge()
					.getWeekList(
							ItDocConstants.METHOD_URL_GET_WEEK_LIST,
							IntroActivity.this);

			//String tmpStr = new String();
		//	for (Week week : weekList) {
			//	tmpStr += week.toString();
				//tmpStr += "\n";
			//}
			//print(tmpStr);
		}
	};
	
	Runnable timeRunnable = new Runnable() {
		public void run() {
			ArrayList<Time> timeList = new ConnectionBridge()
					.getTimeList(
							ItDocConstants.METHOD_URL_GET_TIME_LIST,
							IntroActivity.this);

			//String tmpStr = new String();
			//for (Time time : timeList) {
				//tmpStr += time.toString();
				//tmpStr += "\n";
		//	}
			//print(tmpStr);
		}
	};

	private void isIntro() {
		RegionThread.start();
		Intent intent = new Intent(this, MainActivity.class); // Mainȭ������
																// �̵��Ѵ�.
		startActivity(intent);
		finish();
	}

}
