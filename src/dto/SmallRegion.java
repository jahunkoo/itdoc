package dto;

public class SmallRegion {
	
	private int regionCode;
	private String regionName;
	private int middleRegionCode;
	public SmallRegion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SmallRegion(int regionCode, String regionName, int middleRegionCode) {
		super();
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.middleRegionCode = middleRegionCode;
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
	public int getMiddleRegionCode() {
		return middleRegionCode;
	}
	public void setMiddleRegionCode(int middleRegionCode) {
		this.middleRegionCode = middleRegionCode;
	}
	@Override
	public String toString() {
		return "SmallRegion [regionCode=" + regionCode + ", regionName="
				+ regionName + ", middleRegionCode=" + middleRegionCode + "]";
	}
	
	
}
