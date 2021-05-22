package tojeju;

//일기에 쓸 내용을 저장하는 자바빈즈 클래스

public class MypageDTO {
	
	private String daytime ; //날짜
	private String whether ; //날씨 (맑음, 비, 흐림, 눈, 바람)
	private String place ; //장소
	private String title ; //제목
	private String text ; //내용
	private String feel ; //평가(매우만족, 만족, 보통, 별로, 최악)
	
	public MypageDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MypageDTO(String daytime, String whether, String place, String title, String text,
			String feel) {
		super();
		this.daytime = daytime;
		this.whether = whether;
		this.place = place;
		this.title = title;
		this.text = text;
		this.feel = feel;
	}

	public MypageDTO(String daytime, String place, String title, String text) {
		super();
		this.daytime = daytime;
		this.place = place;
		this.title = title;
		this.text = text;
	}
	
	public MypageDTO(String daytime, String whether, String title) {
		super();
		this.daytime = daytime;
		this.whether = whether;
		this.title = title;
	}

	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	public String getWhether() {
		return whether;
	}

	public void setWhether(String whether) {
		this.whether = whether;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFeel() {
		return feel;
	}

	public void setFeel(String feel) {
		this.feel = feel;
	}
	
	

}
