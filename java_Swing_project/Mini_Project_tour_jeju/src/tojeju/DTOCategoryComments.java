package tojeju;

public class DTOCategoryComments {

	private String subject;
	private String id;
	private String comments;
	
	
	
	public DTOCategoryComments() {
		super();
	}
	public DTOCategoryComments(String subject, String id, String comments) {
		super();
		this.subject = subject;
		this.id = id;
		this.comments = comments;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
