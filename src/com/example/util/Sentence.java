package com.example.util;

public class Sentence {


	/**
	 * Intro
	 */ 
	public static final String networkErrorMessage = "네트워크 상태를 확인하세요";

	/**
	 * Main
	 */
	public static final String networkErrorPleaseRetry= "네트워크 상태가 고르지 않아요. 다시 눌러보세요";
	public static final String closeAppMessage = "'뒤로'버튼을 한번 더 누르면 종료됩니다.";

	/**
	 * S_favoriteTeacherList
	 */
	public static final String headerStr = "좋아하는 선생님들";

	/**
	 * T_insertTeacher
	 */
	public static final String menuTitle = "선생님 등록하기";
	public static final String noInfomationMessage = "모든 정보는 필수 입력사항 이예요 :)";
	public static final String noEmailMessage = "이메일을 입력해주세요 :)";
	public static final String noPwdMessage = "비밀번호를 입력해주세요 :)";
	public static final String noNameMessage = "이름을 입력해주세요 :)";
	public static final String noPhoneMessage = "전화번호를 입력해주세요 :)";
	public static final String rules = "등록 버튼을 누르면 "+"<a href = \"http://blog.naver.com/totoro1012/90184263922\">쌤통(SSamTong) 이용약관</a>"+"에 동의하고 "
			+"<a href = \"http://blog.naver.com/totoro1012/90184263536\">개인정보 보호정책</a>"+"을 읽고 이해한 것으로 간주됩니다.";
	/**
	 * T_getTeacher
	 */
	public static final String updateTeacherInfo = "수정하기";
	public static final String deactivated = "목록에서 숨기기";
	public static final String reactivated = "목록에 보여주기";
	public static final String toast_deactivated = "선생님 목록에서 사라졌습니다.";
	public static final String toast_reactivated = "선생님 목록에 다시 보여집니다.";

	/**
	 * DialogFragments
	 */
	public static final String birthDialogTitle = "출생 연도";
	public static final String consultableDialogTitle = "협의 여부";
	public static final String contact_call = "전화 걸기";
	public static final String contact_sms = "문자 보내기";
	public static final String contact_cancel = "취소";
	public static final String genderDialogTitle = "성별 선택";
	public static final String gradeDialogTitle = "학년 선택";
	public static final String locationDialogTitle = "과외 지역 선택";
	public static final String priceDialogTitle = "과외 가격";
	public static final String schoolDialogTitle = "학교 선택";
	public static final String subjectDialogTitle = "과외 과목 선택";

	/**
	 * T_oauth
	 */
	public static final String oauth_success = "인증 되셨어요!"; 
	public static final String oauth_wrongNum = "번호가 틀리셨어요!";
	public static final String send_sms_seccess = "인증번호가 발송되었어요";

	/**
	 * profileImg Select dialog 
	 */
	public static final String btnGallary = "사진 앨범";
	public static final String btnCamera = "프로필 삭제";
	public static final String btnDelete = "취소";
	public static final String isDelete = "정말로 삭제합니까?";

	/**
	 *  GetTeacherListsTask
	 */
	public static final String ERROR_MESSAGE = "서버와의 통신이 원할하지 않아요. 네트워크 상태를 확인해주세요";

	/**
	 * D_serverCheckFragment
	 */
	public static final String UPDATE_RECOMMENDATION = "더 좋은 기능이 숨어있는 새로운 버전이 등장했어요!";



	/**
	 * Teacher speciality verification Regular Expression
	 */
	public static final String teacherSpecialityReg = "\\d{3}\\s\\d{4}\\s\\d{4}|([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[0-9]{3}[-:]?[0-9]{4}[-:]?[0-9]{4}|[가-하]{3}[-:]?[가-하]{4}[-:]?[가-하]{4}|카톡|까톡|카카오톡|katok|katalk";

}