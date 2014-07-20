package dto;

public class Week {
	private int weekCode;
	private String weekNameKor;

	public Week() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Week(int weekCode, String weekNameKor) {
		super();
		this.weekCode = weekCode;
		this.weekNameKor = weekNameKor;
	}

	public int getWeekCode() {
		return weekCode;
	}

	public void setWeekCode(int weekCode) {
		this.weekCode = weekCode;
	}

	public String getWeekNameKor() {
		return weekNameKor;
	}

	public void setWeekNameKor(String weekNameKor) {
		this.weekNameKor = weekNameKor;
	}

	@Override
	public String toString() {
		return "Week [weekCode=" + weekCode + ", weekNameKor=" + weekNameKor
				+ "]";
	}

}
