package dto;

public class Grade {
	
	private int gradeCode;
	private String gradeName;
	
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(int gradeCode, String gradeName) {
		super();
		this.gradeCode = gradeCode;
		this.gradeName = gradeName;
	}

	public int getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "Grade [gradeCode=" + gradeCode + ", gradeName="
				+ gradeName + "]";
	}


}
