package dto;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.UserException;
import util.ItDocConstants;

public class User {
	
	private final int DEFAULT_NUM = 0;
	private final int MIN_PASSWORD_NUM = 6;
	private final int BIRTH_YEAR_MIN = 1900;
	private int currentYear;
	private final String EMAIL_PATTERN =
	            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String INPUT_EMPTY = "정보를 입력하세요";
	public static final String NOT_EMAIL_TYPE = "이메일 형식이 아닙니다.";
	public static final String PASSWORD_LENGTH_NEED_UP_TO_SIX = "비밀번호는 6자리 이상이어야 합니다.";
	public static final String NOT_CORRECT_BIRTH_YEAR = "올바른 연도를 입력하세요";
	private String email;
	private String password;
	private String name;
	private String cellPhone;
	private int birthYear;
	private int gender 	= DEFAULT_NUM;
	private int flag	= DEFAULT_NUM;
	
		
	//생성자 이전에 호출되는 부분
	{
		Calendar cal = Calendar.getInstance();
		currentYear = Calendar.getInstance().get ( cal.YEAR );
	}
	
	public User() {
		super();
	}

	public User(String email, String password, String name, String cellPhone,
			int birthYear, int gender, int flag) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.cellPhone = cellPhone;
		this.birthYear = birthYear;
		this.gender = gender;
		this.flag = flag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws UserException {
		if(email == null || email.isEmpty()){
			throw new UserException(INPUT_EMPTY);
		}else if(!isEmailAddress(email)){
			throw new UserException(NOT_EMAIL_TYPE);
		}
		
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws UserException {
		if(password == null || password.isEmpty()){
			throw new UserException(INPUT_EMPTY);
		}else if(password.length()<MIN_PASSWORD_NUM){
			throw new UserException(PASSWORD_LENGTH_NEED_UP_TO_SIX);
		}
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) throws UserException {
		if(birthYear>=BIRTH_YEAR_MIN && birthYear<=currentYear){
			this.birthYear = birthYear;
		}else{
			throw new UserException(NOT_CORRECT_BIRTH_YEAR);
		}
		
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}	
	
	   @Override
	public String toString() {
		return "User [DEFAULT_NUM=" + DEFAULT_NUM + ", MIN_PASSWORD_NUM="
				+ MIN_PASSWORD_NUM + ", EMAIL_PATTERN=" + EMAIL_PATTERN
				+ ", email=" + email + ", password=" + password + ", name="
				+ name + ", cellPhone=" + cellPhone + ", birthYear="
				+ birthYear + ", gender=" + gender + ", flag=" + flag + "]";
	}

	public boolean isEmailAddress(String email) {
	        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
	        Matcher emailMatcher = emailPattern.matcher(email);

	        return emailMatcher.matches();
	    }
	   
}
