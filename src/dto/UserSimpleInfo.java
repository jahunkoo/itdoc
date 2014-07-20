package dto;

/**
 * 리스트 상에서 사용자의 정보를 보여주기 위한 간단한 클래스
 * (이메일,이름,사용자사진)
 * @author Administrator
 *
 */
public class UserSimpleInfo {
	private String email;
	private String name;
	private String picturePath;
	
	
	public UserSimpleInfo() {
		super();
	}

	public UserSimpleInfo(String email, String name, String picturePath) {
		super();
		this.email = email;
		this.name = name;
		this.picturePath = picturePath;
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

	@Override
	public String toString() {
		return "UserSimpleInfo [email=" + email + ", name=" + name
				+ ", picturePath=" + picturePath + "]";
	}
	
	
	
}
