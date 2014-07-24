package dto;

import java.util.Arrays;
import java.util.List;

/**
 * 한의원 상세 정보를 담는 클래스
 * @author Administrator
 *	
 */
public class KmClinicDetailView {

	private int id;
	private String name;
	private String mapPoint;		//한의원 위치정보
	private String bigRegionCode;
	private String bigRegionName;
	private String middleRegionCode;
	private String middleRegionName;
	private String remainRegion;
	private int followNum;			// 해당 한의원이 팔로우 된 횟수
	private String homepage;
	private String linePhone;
	private String details;			//한의원 소개글 
	private int type;				//0:default, 1:한방병원, 2:한의원
	//private int userLikeNum;		//용해요 - 사용자가 한의원을 추천한 것 - 가본사람이 추천 누른 횟수    -> userSimpleList의 size()로 얻을 수 있다. 
	private List<String> keywordList;	//한의원의 키워드 배열
	private List<UserSimpleInfo> userSimpleInfoList;	//추천한 사람들의 간단한 정보들 (이메일, 사진, 이름)  
	private List<Review> reviewList; // 현재 review 미구현 상태
	private List<String> picturePathList;
	
	public KmClinicDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KmClinicDetailView(int id, String name, String mapPoint,
			String bigRegionCode, String bigRegionName,
			String middleRegionCode, String middleRegionName,
			String remainRegion, int followNum, String homepage,
			String linePhone, String details, int type,
			List<String> keywordList, List<UserSimpleInfo> userSimpleInfoList,
			List<Review> reviewList, List<String> picturePathList) {
		super();
		this.id = id;
		this.name = name;
		this.mapPoint = mapPoint;
		this.bigRegionCode = bigRegionCode;
		this.bigRegionName = bigRegionName;
		this.middleRegionCode = middleRegionCode;
		this.middleRegionName = middleRegionName;
		this.remainRegion = remainRegion;
		this.followNum = followNum;
		this.homepage = homepage;
		this.linePhone = linePhone;
		this.details = details;
		this.type = type;
		this.keywordList = keywordList;
		this.userSimpleInfoList = userSimpleInfoList;
		this.reviewList = reviewList;
		this.picturePathList = picturePathList;
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

	public String getRemainRegion() {
		return remainRegion;
	}

	public void setRemainRegion(String remainRegion) {
		this.remainRegion = remainRegion;
	}

	public int getFollowNum() {
		return followNum;
	}

	public void setFollowNum(int followNum) {
		this.followNum = followNum;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getLinePhone() {
		return linePhone;
	}

	public void setLinePhone(String linePhone) {
		this.linePhone = linePhone;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<String> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}

	public List<UserSimpleInfo> getUserSimpleInfoList() {
		return userSimpleInfoList;
	}

	public void setUserSimpleInfoList(List<UserSimpleInfo> userSimpleInfoList) {
		this.userSimpleInfoList = userSimpleInfoList;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public List<String> getPicturePathList() {
		return picturePathList;
	}

	public void setPicturePathList(List<String> picturePathList) {
		this.picturePathList = picturePathList;
	}

	@Override
	public String toString() {
		return "KmClinicDetailView [id=" + id + ", name=" + name
				+ ", mapPoint=" + mapPoint + ", bigRegionCode=" + bigRegionCode
				+ ", bigRegionName=" + bigRegionName + ", middleRegionCode="
				+ middleRegionCode + ", middleRegionName=" + middleRegionName
				+ ", remainRegion=" + remainRegion + ", followNum=" + followNum
				+ ", homepage=" + homepage + ", linePhone=" + linePhone
				+ ", details=" + details + ", type=" + type + ", keywordList="
				+ keywordList + ", userSimpleInfoList=" + userSimpleInfoList
				+ ", reviewList=" + reviewList + ", picturePathList="
				+ picturePathList + "]";
	}
	
	
	
}
