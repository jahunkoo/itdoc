package dto;

import java.util.Arrays;

/**
 * 한의원 상세 정보를 담는 클래스
 * @author Administrator
 *	
 */
public class KmClinicDetailView {

	private int id;
	private String name;
	private String[] keywordArray;	//각각 한의원의 키워드 배열
	private String[] picturePathArray;
	private UserSimpleInfo[] userSimpleInfoArray;	//추천한 사람들의 간단한 정보들 (이메일, 사진, 이름)  
	private String details;
	private String linePhone;
	private String bigRegionCode;
	private String bigRegionName;
	private String middleRegionCode;
	private String middleRegionName;
	private String remainRegionName;
	private String mapPoint;		//한의원 위치정보
	private String homepage;
	private int type;				//한방병원, 한의원
	//private int userLikeNum;		//용해요 - 사용자가 한의원을 추천한 것 - 가본사람이 추천 누른 횟수   
	private int followNum;			// 해당 한의원이 팔로우 된 횟수
	private Review[] reviewArray;

	
	public KmClinicDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public KmClinicDetailView(int id, String name, String[] keywordArray,
			String[] picturePathArray, UserSimpleInfo[] userSimpleInfoArray,
			String details, String linePhone, String bigRegionCode,
			String bigRegionName, String middleRegionCode,
			String middleRegionName, String remainRegionName, String mapPoint,
			String homepage, int type, int followNum, Review[] reviewArray) {
		super();
		this.id = id;
		this.name = name;
		this.keywordArray = keywordArray;
		this.picturePathArray = picturePathArray;
		this.userSimpleInfoArray = userSimpleInfoArray;
		this.details = details;
		this.linePhone = linePhone;
		this.bigRegionCode = bigRegionCode;
		this.bigRegionName = bigRegionName;
		this.middleRegionCode = middleRegionCode;
		this.middleRegionName = middleRegionName;
		this.remainRegionName = remainRegionName;
		this.mapPoint = mapPoint;
		this.homepage = homepage;
		this.type = type;
		this.followNum = followNum;
		this.reviewArray = reviewArray;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getKeywordArray() {
		return keywordArray;
	}

	public void setKeywordArray(String[] keywordArray) {
		this.keywordArray = keywordArray;
	}

	public String[] getPicturePathArray() {
		return picturePathArray;
	}

	public void setPicturePathArray(String[] picturePathArray) {
		this.picturePathArray = picturePathArray;
	}

	public UserSimpleInfo[] getUserSimpleInfoArray() {
		return userSimpleInfoArray;
	}

	public void setUserSimpleInfoArray(UserSimpleInfo[] userSimpleInfoArray) {
		this.userSimpleInfoArray = userSimpleInfoArray;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLinePhone() {
		return linePhone;
	}

	public void setLinePhone(String linePhone) {
		this.linePhone = linePhone;
	}

	public String getBigRegionCode() {
		return bigRegionCode;
	}

	public void setBigRegionCode(String bigRegionCode) {
		this.bigRegionCode = bigRegionCode;
	}

	public String getBigRegionName() {
		return bigRegionName;
	}

	public void setBigRegionName(String bigRegionName) {
		this.bigRegionName = bigRegionName;
	}

	public String getMiddleRegionCode() {
		return middleRegionCode;
	}

	public void setMiddleRegionCode(String middleRegionCode) {
		this.middleRegionCode = middleRegionCode;
	}

	public String getMiddleRegionName() {
		return middleRegionName;
	}

	public void setMiddleRegionName(String middleRegionName) {
		this.middleRegionName = middleRegionName;
	}

	public String getRemainRegionName() {
		return remainRegionName;
	}

	public void setRemainRegionName(String remainRegionName) {
		this.remainRegionName = remainRegionName;
	}

	public String getMapPoint() {
		return mapPoint;
	}

	public void setMapPoint(String mapPoint) {
		this.mapPoint = mapPoint;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFollowNum() {
		return followNum;
	}

	public void setFollowNum(int followNum) {
		this.followNum = followNum;
	}

	public Review[] getReviewArray() {
		return reviewArray;
	}

	public void setReviewArray(Review[] reviewArray) {
		this.reviewArray = reviewArray;
	}


	@Override
	public String toString() {
		return "KmClinicDetailView [id=" + id + ", name=" + name
				+ ", keywordArray=" + Arrays.toString(keywordArray)
				+ ", picturePathArray=" + Arrays.toString(picturePathArray)
				+ ", userSimpleInfoArray="
				+ Arrays.toString(userSimpleInfoArray) + ", details=" + details
				+ ", linePhone=" + linePhone + ", bigRegionCode="
				+ bigRegionCode + ", bigRegionName=" + bigRegionName
				+ ", middleRegionCode=" + middleRegionCode
				+ ", middleRegionName=" + middleRegionName
				+ ", remainRegionName=" + remainRegionName + ", mapPoint="
				+ mapPoint + ", homepage=" + homepage + ", type=" + type
				+ ", followNum=" + followNum + ", reviewArray="
				+ Arrays.toString(reviewArray) + "]";
	}
	
	
}
