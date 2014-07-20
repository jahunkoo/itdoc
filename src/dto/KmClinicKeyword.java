package dto;

public class KmClinicKeyword {
	private int kmClinicId;
	private String keyword;
	
	public KmClinicKeyword() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KmClinicKeyword(int kmClinicId, String keyword) {
		super();
		this.kmClinicId = kmClinicId;
		this.keyword = keyword;
	}

	public int getKmClinicId() {
		return kmClinicId;
	}
	public void setKmClinicId(int kmClinicId) {
		this.kmClinicId = kmClinicId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "KmClinicKeyword [kmClinicId=" + kmClinicId + ", keyword="
				+ keyword + "]";
	}
	
	
}
