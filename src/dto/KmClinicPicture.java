package dto;

public class KmClinicPicture {
	
	private int id;
	private int kmClinicId;
	private String picturePath;
	private int order;
	
	public KmClinicPicture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KmClinicPicture(int id, int kmClinicId, String picturePath, int order) {
		super();
		this.id = id;
		this.kmClinicId = kmClinicId;
		this.picturePath = picturePath;
		this.order = order;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKmClinicId() {
		return kmClinicId;
	}
	public void setKmClinicId(int kmClinicId) {
		this.kmClinicId = kmClinicId;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "KmClinicPicture [id=" + id + ", kmClinicId=" + kmClinicId
				+ ", picturePath=" + picturePath + ", order=" + order + "]";
	}
	
	
	
	
}
