package dto;

import java.sql.Date;
import java.util.Arrays;

/**
 * 리뷰페이지에 필요한 정보를 담고 있는 클래스 
 * @author Administrator
 *
 */
public class Review {
	
	private String userEmail;
	private String userName;
	private int overAll;			//별점	
	private int userWishType;		// 가봤어요 , 가고싶어요(이 경우는 없음)
	private int userFavoriteType;	// 추천,괜찮아요,비추천
	private String comment;			//실제 리뷰 글
	private String userPicturePath;	//사진 경로
	private int[] prices;			//사용자가 선택한 가격의 범주
	
	private Date reviewDate;
	private int kmClinicId;
	private String kmClinicName;
	private int userLikeNum; 				//용해요 - 사용자가 한의원을 추천한 것 - 가본사람이 추천 누른 횟수
	private String kmClinicPicturePath;
	private String[] keywordArray;
	private UserSimpleInfo[] userSimpleInfoArray;	//추천한 사람들의 간단한 정보들 (이메일, 사진, 이름)
	
	private String bigRegionCode;
	private String bigRegionName;
	private String middleRegionCode;
	private String middleRegionName;

	
}
