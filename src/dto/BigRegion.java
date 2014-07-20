package dto;

public class BigRegion {
	private int regionCode;
	private String regionName;
	
	
	public BigRegion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigRegion(int regionCode, String regionName) {
		super();
		this.regionCode = regionCode;
		this.regionName = regionName;
	}

	public int getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(int regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "BigRegion [regionCode=" + regionCode + ", regionName="
				+ regionName + "]";
	}


	
	
}
