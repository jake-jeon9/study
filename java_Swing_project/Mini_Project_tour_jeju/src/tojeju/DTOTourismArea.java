package tojeju;

public class DTOTourismArea {

	private String subject;
	private String id;
	private String rating;
	private String time;
	private String review;
	
	
	public DTOTourismArea() {
		super();
	}
	
	
	public DTOTourismArea(String subject, String id, String rating, String time, String review) {
		super();
		this.subject = subject;
		this.id = id;
		this.rating = rating;
		this.time = time;
		this.review = review;
	}
	

	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	
	
	
	
	
	}
