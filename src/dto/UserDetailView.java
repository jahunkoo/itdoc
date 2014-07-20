package dto;

import java.util.Arrays;

/**
 * 사용자 프로필 상세정보에 필요한 정보를 담고 있는 클래스 
 * @author Administrator
 *
 */
public class UserDetailView {
	private String email;
	private String name;
	private String picturePath;
	private KmClinicSimpleInfo[] wantToVisitArray;//가고싶다
	private KmClinicSimpleInfo[] visitLikeArray;//가봤다에서 추천 
	private UserSimpleInfo[] followingUserArray;//빨로잉
	private UserSimpleInfo[] followerUserArray;//빨로워
	
	public UserDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailView(String email, String name, String picturePath,
			KmClinicSimpleInfo[] wantToVisitArray,
			KmClinicSimpleInfo[] visitLikeArray,
			UserSimpleInfo[] followingUserArray,
			UserSimpleInfo[] followerUserArray) {
		super();
		this.email = email;
		this.name = name;
		this.picturePath = picturePath;
		this.wantToVisitArray = wantToVisitArray;
		this.visitLikeArray = visitLikeArray;
		this.followingUserArray = followingUserArray;
		this.followerUserArray = followerUserArray;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public KmClinicSimpleInfo[] getWantToVisitArray() {
		return wantToVisitArray;
	}

	public void setWantToVisitArray(KmClinicSimpleInfo[] wantToVisitArray) {
		this.wantToVisitArray = wantToVisitArray;
	}

	public KmClinicSimpleInfo[] getVisitLikeArray() {
		return visitLikeArray;
	}

	public void setVisitLikeArray(KmClinicSimpleInfo[] visitLikeArray) {
		this.visitLikeArray = visitLikeArray;
	}

	public UserSimpleInfo[] getFollowingUserArray() {
		return followingUserArray;
	}

	public void setFollowingUserArray(UserSimpleInfo[] followingUserArray) {
		this.followingUserArray = followingUserArray;
	}

	public UserSimpleInfo[] getFollowerUserArray() {
		return followerUserArray;
	}

	public void setFollowerUserArray(UserSimpleInfo[] followerUserArray) {
		this.followerUserArray = followerUserArray;
	}

	@Override
	public String toString() {
		return "UserDetailView [email=" + email + ", name=" + name
				+ ", picturePath=" + picturePath + ", wantToVisitArray="
				+ Arrays.toString(wantToVisitArray) + ", visitLikeArray="
				+ Arrays.toString(visitLikeArray) + ", followingUserArray="
				+ Arrays.toString(followingUserArray) + ", followerUserArray="
				+ Arrays.toString(followerUserArray) + "]";
	}
	
	
	
}
