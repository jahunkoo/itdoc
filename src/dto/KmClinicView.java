package dto;

import java.util.List;

/**
 * 한의원리스트 페이지에 필요한 정보를 담고 있는 클래스 
 * @author Administrator
 *
 */
public class KmClinicView {
	
	private int id;
	private String name;			
	private String mapPoint;		//한의원 위치정보
	private int bigRegionCode;
	private String bigRegionName;
	private int middleRegionCode;
	private String middleRegionName;
	private String remainRegion;
	private int followNum;			// 해당 한의원이 팔로우 된 횟수
	private int ratingNum;			// 알고리즘 미정 
	private String picturePath;
	private int userLikeNum;		//용해요 - 사용자가 한의원을 추천한 것 - 가본사람이 추천 누른 횟수   
	private List<String> keywordList;	//각각 한의원의 키워드 배열
	private List<UserSimpleInfo> userSimpleInfoList;	//추천한 사람들의 간단한 정보들 (이메일, 사진, 이름) -> *지인을 우선으로*  
	
	public KmClinicView() {
		super();
	}

	public KmClinicView(int id, String name, String mapPoint,
			List<String> keywordList, int bigRegionCode, String bigRegionName,
			int middleRegionCode, String middleRegionName, String remainRegion,
			int userLikeNum, int followNum, int ratingNum, String picturePath,
			List<UserSimpleInfo> userSimpleInfoList) {
		super();
		this.id = id;
		this.name = name;
		this.mapPoint = mapPoint;
		this.keywordList = keywordList;
		this.bigRegionCode = bigRegionCode;
		this.bigRegionName = bigRegionName;
		this.middleRegionCode = middleRegionCode;
		this.middleRegionName = middleRegionName;
		this.remainRegion = remainRegion;
		this.userLikeNum = userLikeNum;
		this.followNum = followNum;
		this.ratingNum = ratingNum;
		this.picturePath = picturePath;
		this.userSimpleInfoList = userSimpleInfoList;
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

	public String getMapPoint() {
		return mapPoint;
	}

	public void setMapPoint(String mapPoint) {
		this.mapPoint = mapPoint;
	}

	public List<String> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}

	public int getBigRegionCode() {
		return bigRegionCode;
	}

	public void setBigRegionCode(int bigRegionCode) {
		this.bigRegionCode = bigRegionCode;
	}

	public String getBigRegionName() {
		return bigRegionName;
	}

	public void setBigRegionName(String bigRegionName) {
		this.bigRegionName = bigRegionName;
	}

	public int getMiddleRegionCode() {
		return middleRegionCode;
	}

	public void setMiddleRegionCode(int middleRegionCode) {
		this.middleRegionCode = middleRegionCode;
	}

	public String getMiddleRegionName() {
		return middleRegionName;
	}

	public void setMiddleRegionName(String middleRegionName) {
		this.middleRegionName = middleRegionName;
	}

	public String getRemainRegion() {
		return remainRegion;
	}

	public void setRemainRegion(String remainRegion) {
		this.remainRegion = remainRegion;
	}

	public int getUserLikeNum() {
		return userLikeNum;
	}

	public void setUserLikeNum(int userLikeNum) {
		this.userLikeNum = userLikeNum;
	}

	public int getFollowNum() {
		return followNum;
	}

	public void setFollowNum(int followNum) {
		this.followNum = followNum;
	}

	public int getRatingNum() {
		return ratingNum;
	}

	public void setRatingNum(int ratingNum) {
		this.ratingNum = ratingNum;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public List<UserSimpleInfo> getUserSimpleInfoList() {
		return userSimpleInfoList;
	}

	public void setUserSimpleInfoList(List<UserSimpleInfo> userSimpleInfoList) {
		this.userSimpleInfoList = userSimpleInfoList;
	}

	@Override
	public String toString() {
		return "KmClinicView [id=" + id + ", name=" + name + ", mapPoint="
				+ mapPoint + ", keywordList=" + keywordList
				+ ", bigRegionCode=" + bigRegionCode + ", bigRegionName="
				+ bigRegionName + ", middleRegionCode=" + middleRegionCode
				+ ", middleRegionName=" + middleRegionName + ", remainRegion="
				+ remainRegion + ", userLikeNum=" + userLikeNum
				+ ", followNum=" + followNum + ", ratingNum=" + ratingNum
				+ ", picturePath=" + picturePath + ", userSimpleInfoList="
				+ userSimpleInfoList + "]";
	}

	
}
