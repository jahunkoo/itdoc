package com.example.util;


public class DataTypeTranslatorUtil {
	

	


//------------------------------------------ gender related ------------------------------------------------//
	public String[] genders = {"남자", "여자"};
	
	public String genderIntToStr(int genderInt) {
		String genderStr = "";
		if(genderInt == 0){
			 genderStr = "성별";
		}else if(genderInt == 1){
			genderStr = "남자";
		}else if(genderInt == 2){
			genderStr = "여자";
		}
		return genderStr;
	}
	
	public int genderStrToInt(String genderStr){
		int genderInt = 0;
		if(genderStr == "성별"){
			genderInt = 0;
		}else if(genderStr == "남자"){
			genderInt = 1;
		}else if(genderStr == "여자"){
			genderInt = 2;
		}
		return genderInt;
	}
	
	
}
