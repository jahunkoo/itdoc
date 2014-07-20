package dto;

/**
 * 리스트 상에서 한의원의 정보를 보여주기 위한 간단한 클래스 
 * (아이디,이름,키워드,한의원사진) 
 * @author Administrator
 *
 */
public class KmClinicSimpleInfo {
	private int id;
	private String name;
	private String[] keywordArray;	//각각 한의원의 키워드 배열
	private String picturePath;
}
