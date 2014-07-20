package dto;

public class Time {
	
	private int timeCode;
	private String timeHalf;
	
	public Time(){
		super();
	}
	
	public Time(int timeCode, String timeHalf)
	{
		super();
		this.timeCode = timeCode;
		this.timeHalf = timeHalf;
	}
	
	public int getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(int timeCode) {
		this.timeCode = timeCode;
	}
	public String getTimeHalf() {
		return timeHalf;
	}
	public void setTimeHalf(String timeHalf) {
		this.timeHalf = timeHalf;
	}
	
	@Override
	public String toString() {
		return "Time [timeCode=" + timeCode + ", timeHalf=" + timeHalf
				+ "]";
	}

}
