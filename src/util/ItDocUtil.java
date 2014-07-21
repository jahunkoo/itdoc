package util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class ItDocUtil {
	
	private final String REGEX_AT = "@"; 
	private final String REGEX_SHARP = "#";
	private final String REGEX_DOT = ".";
	
	/**
	 * 이메일과 파일명으로 이미지이름 만들어주는 메서드
	 * @param email
	 * @param originalFileName
	 * @return
	 */
	public String createPicturePath(String email, String originalFileName){
		String[] fileNameArr = originalFileName.split("[.]");
		String[] tmpArr = email.split(REGEX_AT);
		String replacedString = null;
		if(tmpArr[0].contains(REGEX_DOT)){
			replacedString = replaceDotToSharp(tmpArr[0]);
		}else {
			replacedString = tmpArr[0];
		}
		String picturePath = replacedString+getTimeStr()+"."+fileNameArr[1];
		
		return picturePath;
	}
	
	private String replaceDotToSharp(String originalString){
		int length = originalString.length();
		int dotPosition = originalString.indexOf(REGEX_DOT);
		System.out.println(dotPosition);
		String front = originalString.substring(0,dotPosition);
		String end = originalString.substring(dotPosition+1,length);
		String replacedString = front+REGEX_SHARP+end;
		return replacedString;
	}
	
	//연+월+날짜+시간(24)+분+초+밀리초+임의의 수(0~100)
	private String getTimeStr(){
		StringBuffer timeStr = new StringBuffer();
		Date currentDate = Calendar.getInstance().getTime();
		long currentTime = currentDate.getTime();
		timeStr.append(currentTime);
		timeStr.append(createRandomNum());
		return  timeStr.toString();
	}
	
	// 0~100 사이의 임의의 수 반환
	private final int MULTIPLY_NUM = 100;
	private String createRandomNum(){
		int randomNum = (int) (Math.random()* MULTIPLY_NUM);
		return String.valueOf(randomNum);
	}
	
}
