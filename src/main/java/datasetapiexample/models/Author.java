package datasetapiexample.models;

public class Author {
	
	int authorid;
	String authorname;
	int authorage;
	String authoraddress;
	Boolean retired;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public int getAuthorage() {
		return authorage;
	}
	public void setAuthorage(int authorage) {
		this.authorage = authorage;
	}
	public String getAuthoraddress() {
		return authoraddress;
	}
	public void setAuthoraddress(String authoraddress) {
		this.authoraddress = authoraddress;
	}
	public Boolean getRetired() {
		return retired;
	}
	public void setRetired(Boolean retired) {
		this.retired = retired;
	}
	public Author(int authorid, String authorname, int authorage, String authoraddress, Boolean retired) {
		super();
		this.authorid = authorid;
		this.authorname = authorname;
		this.authorage = authorage;
		this.authoraddress = authoraddress;
		this.retired = retired;
	}
	@Override
	public String toString() {
		return "\n Author [authorid=" + authorid + ", authorname=" + authorname + ", authorage=" + authorage
				+ ", authoraddress=" + authoraddress + ", retired=" + retired + "]";
	}
	
	

}
