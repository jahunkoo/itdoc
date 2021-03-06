package connect;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import util.ItDocConstants;
import util.ItDocUtil;
import util.JsonParser;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import dto.BigRegion;
import dto.Grade;
import dto.KmClinicDetailView;
import dto.KmClinicView;
import dto.MiddleRegion;
import dto.Time;
import dto.Week;

/**
 * 서버로부터 데이터를 내려받을 때,중간 다리 역할을 하는 클래스
 * 
 */
public class ConnectionBridge extends Activity{

	public static final String MAIN_SERVER_ADDRESS = "http://www.itdoc.co.kr";
	public static final String MAIN_PROJECT_NAME = "ItDocServer";
	public static final String IMG_SERVER_ADDRESS = "http://yss159.cafe24.com:8080";
	public static final String IMG_PROJECT_NAME = "ItDocImgServer";

	/**
	 * naming rule: get+Class명(타입)+어떤자료구조
	 * 
	 * @param methodUrl
	 *            요청하고자 하는 method주소
	 * @param context
	 *            데이터 통신이 이루어지는 동안 로딩화면을 띄우기 위해 필요
	 */
	public ArrayList<BigRegion> getBigRegionList(String methodUrl,
			Context context) {
		ArrayList<BigRegion> bigRegionList = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME,
				methodUrl);
		HttpConnectionModule connection = new HttpConnectionModule(context);
		try {
			connection.setMethod(HttpConnectionModule.GET);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();
			bigRegionList = (ArrayList<BigRegion>) new JsonParser(methodUrl)
					.parse(result);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return bigRegionList;
	}

	public ArrayList<MiddleRegion> getMiddleRegionList(String methodUrl,
			Context context) {
		ArrayList<MiddleRegion> middleRegionList = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME,
				methodUrl);
		HttpConnectionModule connection = new HttpConnectionModule(context);
		try {
			connection.setMethod(HttpConnectionModule.GET);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();
			middleRegionList = (ArrayList<MiddleRegion>) new JsonParser(
					methodUrl).parse(result);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return middleRegionList;
	}

	public ArrayList<Grade> getGradeList(String methodUrl, Context context) {
		ArrayList<Grade> gradeList = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME,
				methodUrl);
		HttpConnectionModule connection = new HttpConnectionModule(context);
		try {
			connection.setMethod(HttpConnectionModule.GET);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();
			gradeList = (ArrayList<Grade>) new JsonParser(methodUrl)
					.parse(result);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return gradeList;
	}

	public ArrayList<Week> getWeekList(String methodUrl, Context context) {
		ArrayList<Week> weekList = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME,
				methodUrl);
		HttpConnectionModule connection = new HttpConnectionModule(context);
		try {
			connection.setMethod(HttpConnectionModule.GET);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();
			weekList = (ArrayList<Week>) new JsonParser(methodUrl)
					.parse(result);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return weekList;
	}

	public ArrayList<Time> getTimeList(String methodUrl, Context context) {
		ArrayList<Time> timeList = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME,
				methodUrl);
		HttpConnectionModule connection = new HttpConnectionModule(context);
		try {
			connection.setMethod(HttpConnectionModule.GET);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();
			timeList = (ArrayList<Time>) new JsonParser(methodUrl)
					.parse(result);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return timeList;
	}

	public ArrayList<KmClinicView> getKmClinicViewList(String methodUrl,
			Context context) {
		ArrayList<KmClinicView> KmClinicView = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME,
				methodUrl);
		HttpConnectionModule connection = new HttpConnectionModule(context);
		try {
			connection.setMethod(HttpConnectionModule.GET);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();

			KmClinicView = (ArrayList<KmClinicView>) new JsonParser(methodUrl).parse(result);
	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			Log.d("kim", "kim");
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return KmClinicView;
	}
	
	
	public ArrayList<KmClinicDetailView> getKmClinicDetailViewList(String methodUrl, Context context, int clinicId) {
		ArrayList<KmClinicDetailView> KmClinicDetailViewList = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME, methodUrl);
		
		Properties prop = new Properties();
		prop.setProperty("kmClinicId", String.valueOf(clinicId));
		try {
			HttpConnectionModule connection = new HttpConnectionModule(context);
			connection.setMethod(HttpConnectionModule.POST);
			connection.setProperties(prop);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();
			KmClinicDetailViewList = (ArrayList<KmClinicDetailView>) new JsonParser(methodUrl).parse(result);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			
		} catch (UnsupportedEncodingException e) {
		}

		return KmClinicDetailViewList;
	}

	public ArrayList<String> getAllKeywords(String methodUrl, Context context) {
		ArrayList<String> AllKeywordsList = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME, methodUrl);
		
		try {
			HttpConnectionModule connection = new HttpConnectionModule(context);
			connection.setMethod(HttpConnectionModule.GET);
			connection.downloadTask.execute(targetUrl);
			String result = connection.downloadTask.get();
			AllKeywordsList = (ArrayList<String>) new JsonParser(methodUrl).parse(result);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			
		}

		return AllKeywordsList;
	}
	
	
	public String register(String methodUrl, Properties props, Context context) {
		String result = null;
		String targetUrl = getFullUrl(MAIN_SERVER_ADDRESS, MAIN_PROJECT_NAME,
				methodUrl);
		Log.d("koo", targetUrl);
		// http://localhost:8080/ItDocServer/register?email=asd2323sd@gmail.com&password=asdasd
		HttpConnectionModule connection = new HttpConnectionModule(context);
		try {
			connection.setMethod(HttpConnectionModule.POST);
			connection.setProperties(props);
			Log.d("koo", props.toString());

			connection.downloadTask.execute(targetUrl);
			String data = connection.downloadTask.get();
			result = (String) new JsonParser(methodUrl).parse(data);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// 이미지 업로드
	public String insertImage(String methodUrl, File uploadFile, Context context,  String email) {
		String result = null;
		// String email = "koo10682@gmail.com";

		
		Log.d("kim","ConnectionBridge email ->" + email);
		
		// String email = user_picture.txt_email.getText().toString();
		String targetUrl = getFullUrl(ItDocConstants.ADDRESS_IMG_SERVER_HOST,
				ItDocConstants.ADDRESS_IMG_SERVER_PROJECT, methodUrl);

		String picturePath = new ItDocUtil().createPicturePath(email,
				uploadFile.getName());

		HttpConnectionModule connection = new HttpConnectionModule(context);
		connection.setMethod(HttpConnectionModule.MULTIPART_POST);
		connection.setProfileImgFile(uploadFile, email, picturePath,
				ItDocConstants.OBJECT_TYPE_USER);

		connection.downloadTask.execute(targetUrl);

		try {
			String data = connection.downloadTask.get();
			// {"result","success"}
			// result = (String) new JsonParser(methodUrl).parse(data);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = ItDocConstants.SUCCESS;
		return result;
	}

	private String getFullUrl(String serverUrl, String projectUrl,
			String methodUrl) {
		return serverUrl + "/" + projectUrl + "/" + methodUrl;
	}
}
