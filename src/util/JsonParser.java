package util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import dto.BigRegion;
import dto.Grade;
import dto.KmClinicDetailView;
import dto.KmClinicView;
import dto.MiddleRegion;
import dto.Time;
import dto.UserSimpleInfo;
import dto.Week;

public class JsonParser {

	private String methodUrl;

	/**
	 * 요청한 methodUrl에 따라 다르게 리턴되는 데이터를 파싱하기 위해서, 생성자에서 반드시 methodUrl을 넣도록 함
	 * 
	 * @param methodUrl
	 */
	public JsonParser(String methodUrl) {
		this.methodUrl = methodUrl;
	}

	public Object parse(String data) throws JSONException {
		Object obj = null;

		if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_BIG_REGION_LIST)) { // return
																				// 타입
																				// :
																				// HashMap<String,ArrayList>
			obj = parseBigRegionList(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_MIDDLE_REGION_LIST)) {
			obj = parseMiddleRegionList(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_REGISTER)) {
			obj = parserRegister(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_GRADE_LIST)) {
			obj = parseGradeList(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_WEEK_LIST)) {
			obj = parseWeekList(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_TIME_LIST)) {
			obj = parseTimeList(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_ALLKMCLINIC_LIST)) {
			obj = parseKmClinicViewList(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_DETAIL_KM_CLINIC)) {
			obj = parseKmClinicDetailViewList(data);
		} else if (methodUrl.equals(ItDocConstants.METHOD_URL_GET_ALL_KEYWORDS)) {
			obj = parseAllKeywords(data);
		}
		return obj;
	}

	private String parserRegister(String data) throws JSONException {
		JSONObject jsonObj = new JSONObject(data);
		String result = jsonObj.getString("result");
		return result;
	}

	// 메서드 네이밍 : parse+클래스명+자료구조
	private ArrayList<BigRegion> parseBigRegionList(String data) throws JSONException {
		ArrayList<BigRegion> bigRegionList = new ArrayList<BigRegion>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("BigRegion");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject indexObj = jsonArray.getJSONObject(i);
			BigRegion bigRegion = new BigRegion();
			bigRegion.setRegionCode(indexObj.getInt("regionCode"));
			bigRegion.setRegionName(indexObj.getString("regionName"));
			bigRegionList.add(bigRegion);
		}

		return bigRegionList;
	}

	// 메서드 네이밍 : parse+클래스명+자료구조
	private ArrayList<MiddleRegion> parseMiddleRegionList(String data) throws JSONException {
		ArrayList<MiddleRegion> middleRegionList = new ArrayList<MiddleRegion>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("MiddleRegion");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject indexObj = jsonArray.getJSONObject(i);
			MiddleRegion middleRegion = new MiddleRegion();
			middleRegion.setRegionCode(indexObj.getInt("regionCode"));
			middleRegion.setRegionName(indexObj.getString("regionName"));
			middleRegion.setBigRegionCode(indexObj.getInt("bigRegionCode"));
			middleRegionList.add(middleRegion);
		}

		return middleRegionList;
	}

	// 메서드 네이밍 : parse+클래스명+자료구조
	private ArrayList<Grade> parseGradeList(String data) throws JSONException {
		ArrayList<Grade> gradeList = new ArrayList<Grade>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("Grade");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject indexObj = jsonArray.getJSONObject(i);
			Grade grade = new Grade();
			grade.setGradeCode(indexObj.getInt("gradeCode"));
			grade.setGradeName(indexObj.getString("gradeName"));
			gradeList.add(grade);
		}

		return gradeList;
	}

	private ArrayList<Week> parseWeekList(String data) throws JSONException {
		ArrayList<Week> weekList = new ArrayList<Week>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("Week");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject indexobj = jsonArray.getJSONObject(i);
			Week week = new Week();
			week.setWeekCode(indexobj.getInt("weekCode"));
			week.setWeekNameKor(indexobj.getString("weekNameKor"));
			weekList.add(week);
		}
		return weekList;
	}

	private ArrayList<Time> parseTimeList(String data) throws JSONException {
		ArrayList<Time> timeList = new ArrayList<Time>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("TIme");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject indexobj = jsonArray.getJSONObject(i);
			Time time = new Time();
			time.setTimeCode(indexobj.getInt("TimeCode"));
			time.setTimeHalf(indexobj.getString("TimeHalf"));
			timeList.add(time);
		}
		return timeList;
	}

	// 메서드 네이밍 : parse+클래스명+자료구조
	private ArrayList<KmClinicDetailView> parseKmClinicDetailViewList(String data) throws JSONException {
		ArrayList<KmClinicDetailView> KmClinicDetailViewList = new ArrayList<KmClinicDetailView>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("KmClinicDetailView");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject indexobj = jsonArray.getJSONObject(i);
			KmClinicDetailView kmClinicDetailView = new KmClinicDetailView();
			kmClinicDetailView.setId(indexobj.getInt("id"));
			kmClinicDetailView.setName(indexobj.getString("name"));
			
			Log.d("kim", "kmClinicDetailView is " + kmClinicDetailView.getName());;
			
			// keywordArray 받아와야 함 Array를 받아 와서 다시 string list 형태로 바꿔 주는 형태
			JSONArray JSONindexArray = new JSONArray();

			JSONindexArray = indexobj.getJSONArray("keywordList");
			
			List<String> keywordList = new ArrayList();

			try {

				for (int idx = 0; idx < JSONindexArray.length(); idx++) {

					keywordList.add(JSONindexArray.getString(idx));
				}
			} catch (Exception e) {
				e.printStackTrace();
				Log.d("kim","JsonParser(169)");
			}

			kmClinicDetailView.setKeywordList(keywordList);
			// 기본적 파싱

			kmClinicDetailView.setDetails(indexobj.getString("details"));
			kmClinicDetailView.setLinePhone(indexobj.getString("linePhone"));
			kmClinicDetailView.setBigRegionCode(indexobj.getString("bigRegionCode"));
			kmClinicDetailView.setBigRegionName(indexobj.getString("bigRegionName"));
			kmClinicDetailView.setMiddleRegionCode(indexobj.getString("middleRegionCode"));
			kmClinicDetailView.setMiddleRegionName(indexobj.getString("middleRegionName"));
			kmClinicDetailView.setRemainRegion(indexobj.getString("remainRegion"));
			// kmClinicDetailView.setMapPoint(indexobj.getString("mapPoint"));
			kmClinicDetailView.setHomepage(indexobj.getString("homepage"));
			kmClinicDetailView.setType(indexobj.getInt("type"));
			// kmClinicDetailView.setFollowNum(indexobj.getInt("followNum"));

			// userSimpleInfoArray 받아와야 함 받아와서 다시 내부에서 재 파싱 하는 형태
			JSONindexArray = indexobj.getJSONArray("userSimpleInfoList");
			List<UserSimpleInfo> userSimpleInfoList = new ArrayList();

			try {
				for (int idx = 0; idx < JSONindexArray.length(); idx++) {
					indexobj = JSONindexArray.getJSONObject(i);

					UserSimpleInfo userSimpleInfo = new UserSimpleInfo();
					userSimpleInfo.setEmail(indexobj.getString("email"));
					userSimpleInfo.setName(indexobj.getString("name"));
					userSimpleInfo.setPicturePath(indexobj.getString("picturePath"));
					userSimpleInfoList.add(userSimpleInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Log.d("kim","JsonParser(204)");
			}
			kmClinicDetailView.setUserSimpleInfoList(userSimpleInfoList);

			// reviewArray 받아 와야 함. 현재 미구현 review 자체가 현재 미구현 상태
			
			KmClinicDetailViewList.add(kmClinicDetailView);
		}
		
		return KmClinicDetailViewList;
	}

	private ArrayList<KmClinicView> parseKmClinicViewList(String data) throws JSONException {
		ArrayList<KmClinicView> kmClinicViewList = new ArrayList<KmClinicView>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("KmClinicViewList");

		for (int i = 0; i < jsonArray.length(); i++) {
			KmClinicView kmClinicView = new KmClinicView();
			JSONObject indexobj = jsonArray.getJSONObject(i);

			kmClinicView.setId(indexobj.getInt("id"));
			kmClinicView.setName(indexobj.getString("name"));
			// 맵포인트는 아직 존재하지 않아서 받아오지 않음
			// kmClinicView.setMapPoint(indexobj.getString("mapPoint"));
			kmClinicView.setBigRegionCode(indexobj.getInt("bigRegionCode"));
			kmClinicView.setBigRegionName(indexobj.getString("bigRegionName"));
			kmClinicView.setMiddleRegionCode(indexobj.getInt("middleRegionCode"));
			kmClinicView.setMiddleRegionName(indexobj.getString("middleRegionName"));
			kmClinicView.setRemainRegion(indexobj.getString("remainRegion"));
			kmClinicView.setFollowNum(indexobj.getInt("followNum"));
			kmClinicView.setRatingNum(indexobj.getInt("ratingNum"));
			kmClinicView.setPicturePath(indexobj.getString("picturePath"));
			kmClinicView.setUserLikeNum(indexobj.getInt("userLikeNum"));
			JSONArray JSONindexArray = new JSONArray();
			JSONindexArray = indexobj.getJSONArray("keywordList");
			List<String> keywordList = new ArrayList();
			try {
				for (int idx = 0; idx < JSONindexArray.length(); idx++) {
					keywordList.add(JSONindexArray.getString(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			kmClinicView.setKeywordList(keywordList);

			JSONindexArray = indexobj.getJSONArray("userSimpleInfoList");
			List<UserSimpleInfo> userSimpleInfoList = new ArrayList();

			try {
				for (int idx = 0; idx < JSONindexArray.length(); idx++) {
					indexobj = JSONindexArray.getJSONObject(i);

					UserSimpleInfo userSimpleInfo = new UserSimpleInfo();

					userSimpleInfo.setEmail(indexobj.getString("email"));
					userSimpleInfo.setName(indexobj.getString("name"));
					userSimpleInfo.setPicturePath(indexobj.getString("picturePath"));

					userSimpleInfoList.add(userSimpleInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			kmClinicView.setUserSimpleInfoList(userSimpleInfoList);

			kmClinicViewList.add(kmClinicView);
		}

		return kmClinicViewList;
	}
	
	// 메서드 네이밍 : parse+클래스명+자료구조
		private ArrayList<String> parseAllKeywords(String data) throws JSONException {
			ArrayList<String> AllKeywordsList = new ArrayList<String>();

			JSONObject jsonObj = new JSONObject(data);
			JSONArray jsonArray = jsonObj.getJSONArray("keywords");
			for (int i = 0; i < jsonArray.length(); i++) {

				AllKeywordsList.add(jsonArray.getString(i));
				
			}
			
			return AllKeywordsList;
			
		}
		
}
