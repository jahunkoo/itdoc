package dto;

public class MiddleRegion {
	private int regionCode;
	private String regionName;
	private int bigRegionCode;
	
	public MiddleRegion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MiddleRegion(int regionCode, String regionName, int bigRegionCode) {
		super();
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.bigRegionCode = bigRegionCode;
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


	public int getBigRegionCode() {
		return bigRegionCode;
	}


	public void setBigRegionCode(int bigRegionCode) {
		this.bigRegionCode = bigRegionCode;
	}

	@Override
	public String toString() {
		return "MiddleRegion [regionCode=" + regionCode + ", regionName="
				+ regionName + ", bigRegionCode=" + bigRegionCode + "]";
	}
	
	
	
}
