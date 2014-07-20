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

			// keywordArray 받아와야 함
			// picturePathArray 받아와야 함
			// userSimpleInfoArray 받아와야 함

			kmClinicDetailView.setDetails(indexobj.getString("detail"));
			kmClinicDetailView.setLinePhone(indexobj.getString("linePhone"));
			kmClinicDetailView.setBigRegionCode(indexobj.getString("bigRegionCode"));
			kmClinicDetailView.setBigRegionName(indexobj.getString("bigRigionName"));
			kmClinicDetailView.setMiddleRegionCode(indexobj.getString("middleRegionCode"));
			kmClinicDetailView.setMiddleRegionName(indexobj.getString("middleRegionName"));
			kmClinicDetailView.setRemainRegionName(indexobj.getString("remainRegionNmae"));
			kmClinicDetailView.setMapPoint(indexobj.getString("mapPoint"));
			kmClinicDetailView.setHomepage(indexobj.getString("homePage"));
			kmClinicDetailView.setType(indexobj.getInt("type"));
			kmClinicDetailView.setFollowNum(indexobj.getInt("followNum"));

			// reviewArray 받아 와야 함.

			// keywordArray 를 받기 위한 형태

			JSONArray JSONkeywordArray = new JSONArray();
			JSONkeywordArray = indexobj.getJSONArray("keywordArray");
			String[] keyArraytemp;
			for (int idx = 0; idx < JSONkeywordArray.length(); idx++) {
				// keyArraytemp[i] = JSONkeywordArray.getString(i);
			}

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
			Log.d("kim", kmClinicView.toString());
			kmClinicView.setName(indexobj.getString("name"));
			kmClinicView.setMapPoint(indexobj.getString("mapPoint"));
			kmClinicView.setBigRegionCode(indexobj.getInt("bigRegionCode"));
			kmClinicView.setBigRegionName(indexobj.getString("bigRegionName"));
			kmClinicView.setMiddleRegionCode(indexobj.getInt("middleRegionCode"));
			kmClinicView.setMiddleRegionName(indexobj.getString("middleRegionName"));
			kmClinicView.setRemainRegion(indexobj.getString("remainRegion"));
			kmClinicView.setFollowNum(indexobj.getInt("followNum"));
			kmClinicView.setRatingNum(indexobj.getInt("ratingNum"));
			kmClinicView.setPicturePath(indexobj.getString("picturePath"));
			kmClinicView.setUserLikeNum(indexobj.getInt("userLikeNum"));
			Log.d("kim", kmClinicView.toString());
			JSONArray JSONindexArray = new JSONArray();
			JSONindexArray = indexobj.getJSONArray("keywordArray");
			List<String> keywordList = new ArrayList();
			for (int idx = 0; idx < JSONindexArray.length(); idx++) {
				keywordList.add(JSONindexArray.getString(i));
			}

			kmClinicView.setKeywordList(keywordList);

			JSONindexArray = indexobj.getJSONArray("userSimpleInfoList");
			List<UserSimpleInfo> userSimpleInfoList = new ArrayList();
			for (int idx = 0; idx < JSONindexArray.length(); idx++) {
				indexobj = JSONindexArray.getJSONObject(i);

				UserSimpleInfo userSimpleInfo = new UserSimpleInfo();

				userSimpleInfo.setEmail(indexobj.getString("email"));
				userSimpleInfo.setName(indexobj.getString("name"));
				userSimpleInfo.setPicturePath(indexobj.getString("picturePath"));

				userSimpleInfoList.add(userSimpleInfo);
			}
			kmClinicView.setUserSimpleInfoList(userSimpleInfoList);

			kmClinicViewList.add(kmClinicView);
		}

		return kmClinicViewList;
	}

}
