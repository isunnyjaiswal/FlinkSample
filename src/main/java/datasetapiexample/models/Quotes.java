package datasetapiexample.models;

import java.util.Date;

public class Quotes {

	int quoteid;
	String quote;
	int authorid;
	Date quotecreatedate;
	public int getQuoteid() {
		return quoteid;
	}
	public void setQuoteid(int quoteid) {
		this.quoteid = quoteid;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public Date getQuotecreatedate() {
		return quotecreatedate;
	}
	public void setQuotecreatedate(Date quotecreatedate) {
		this.quotecreatedate = quotecreatedate;
	}
	public Quotes(int quoteid, String quote, int authorid, Date quotecreatedate) {
		super();
		this.quoteid = quoteid;
		this.quote = quote;
		this.authorid = authorid;
		this.quotecreatedate = quotecreatedate;
	}
	@Override
	public String toString() {
		return "Quotes [quoteid=" + quoteid + ", quote=" + quote + ", authorid=" + authorid + ", quotecreatedate="
				+ quotecreatedate + "]";
	}
	
	
}
