package tojeju;

public class DTOInsertToServer {
	
	private String subject;
	private String review;
	private String rating;
	private String id;
	private String rootPhoto;
	Login login;
	


	public DTOInsertToServer() {}
	
	public DTOInsertToServer(String subject, String review, String rating) {
		super();
		this.subject = subject;
		this.review = review;
		this.rating = rating;
		this.id = login.getMyId();
	}
	public DTOInsertToServer(String subject, String rootPhoto) {
		super();
		this.subject = subject;
		this.rootPhoto = rootPhoto;
	}
	
	
	public String getRootPhoto() {
		return rootPhoto;
	}

	public void setRootPhoto(String rootPhoto) {
		this.rootPhoto = rootPhoto;
	}

	public String getid() {
		return id;
	}

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
	

}
