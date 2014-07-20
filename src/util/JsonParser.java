package util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import dto.BigRegion;
import dto.Grade;
import dto.MiddleRegion;
import dto.Time;
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
		}
		return obj;
	}

	private String parserRegister(String data) throws JSONException {
		JSONObject jsonObj = new JSONObject(data);
		String result = jsonObj.getString("result");
		return result;
	}

	// 메서드 네이밍 : parse+클래스명+자료구조
	private ArrayList<BigRegion> parseBigRegionList(String data)
			throws JSONException {
		ArrayList<BigRegion> bigRegionList = new ArrayList<BigRegion>();

		JSONObject jsonObj = new JSONObject(data);
		JSONArray jsonArray = jsonObj.getJSONArray("BigRegion");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject indexObj = jsonArray.getJSONObject(i);
			BigRegion bigRegion = new BigRegion();
			bigRegion.setRegionCode(indexObj.getInt("regionCode"));
			bigRegion.setRegionName(indexObj.getString("regionName"));
			bigRegionList.add(bigRegion);
			Log.d("koo", bigRegion.toString());
		}

		return bigRegionList;
	}

	// 메서드 네이밍 : parse+클래스명+자료구조
	private ArrayList<MiddleRegion> parseMiddleRegionList(String data)
			throws JSONException {
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
			Log.d("koo", middleRegion.toString());
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
			Log.d("koo", grade.toString());
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
			Log.d("koo", week.toString());
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
			Log.d("koo", time.toString());
		}
		return timeList;
	}

}
