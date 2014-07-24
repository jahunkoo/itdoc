package util;

public class ItDocConstants {

	public static final int OBJECT_TYPE_USER = 1;
	public static final int OBJECT_TYPE_KM_CLINIC = 2;
	public static final int OBJECT_TYPE_KM_DOCTOR = 3;		

	public static final int CODE_ERROR = -1;
	public static final int CODE_DEFAULT = 0;
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_EXIST = 2;

	public static final String RESULT = "result";
	public static final String ERROR = "error";
	public static final String DEFAULT = "default";
	public static final String SUCCESS = "success";
	public static final String EXIST = "exist";
	public static final String MESSAGE = "message";
	
	public static final int MEN = 1;
	public static final int WOMEN = 2;
	
	
	//json 
	public static final String JSON_OBJECT = "JSONObject";
	public static final String JSON_ARRAY = "JSONArray";
	
	
	//main
	public static final String ADDRESS_MAIN_SERVER_HOST = "http://www.itdoc.co.kr";
	public static final String ADDRESS_MAIN_SERVER_PROJECT= "ItDocServer";
	//image
	public static final String ADDRESS_IMG_SERVER_HOST = "http://1.234.75.178:8080";
	public static final String ADDRESS_IMG_SERVER_PROJECT = "ItDocImgServer";
	
	public static final String IMG_PATH_BASIC = "/home/itDoc/img";
	public static final String IMG_PATH_USER = "/user";
	public static final String IMG_PATH_KM_CLINIC = "/kmclinic";
	public static final String IMG_PATH_KM_DOCTOR = "/kmdoctor";		
	
	public static final String IMG_DEFAULT_USER = "userProfileDefault.png";
	public static final String IMG_DEFAULT_KM_CLINIC = "kmClinicDefault.png";
	public static final String IMG_DEFAULT_KM_DOCTOR = "kmDoctorDefault.png";
	
	//for User 
	public static final String INPUT_EMPTY = "정보를 입력하세요";
	public static final String NOT_EMAIL_TYPE = "이메일 형식이 아닙니다.";
	public static final String PASSWORD_LENGTH_NEED_UP_TO_SIX = "비밀번호는 6자리 이상이어야 합니다.";

	// 서버 method url
	public static final String METHOD_URL_GET_BIG_REGION_LIST = "getBigRegionList";
	public static final String METHOD_URL_GET_MIDDLE_REGION_LIST = "getMiddleRegionList";
	public static final String METHOD_URL_GET_SMALL_REGION_LIST = "getSmallRegionList";
	public static final String METHOD_URL_GET_GRADE_LIST = "getGradeList";
	public static final String METHOD_URL_GET_WEEK_LIST = "getWeekList";
	public static final String METHOD_URL_GET_TIME_LIST = "getTimeList";
	public static final String METHOD_URL_GET_ALLKMCLINIC_LIST = "getAllKmClinic";
	public static final String METHOD_URL_GET_DETAIL_KM_CLINIC = "getDetailKmClinic";
	public static final String METHOD_URL_GET_ALL_KEYWORDS = "getAllKeywords";
	public static final String METHOD_URL_REGISTER = "register";
	public static final String METHOD_URL_LOGIN = "login";
}
