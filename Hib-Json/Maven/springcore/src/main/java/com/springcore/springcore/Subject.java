package com.springcore.springcore;

public class Subject{
	private String maths;
	private String science;
	private String gujarati;
	
	
	@Override
	public String toString() {
		return "Subject [maths=" + maths + ", science=" + science + ", gujarati=" + gujarati + "]";
	}
	
	
	public Subject(String maths, String science, String gujarati) {
		super();
		this.maths = maths;
		this.science = science;
		this.gujarati = gujarati;
	}
	
	
	public String getMaths() {
		return maths;
	}
	public void setMaths(String maths) {
		this.maths = maths;
	}
	public String getScience() {
		return science;
	}
	public void setScience(String science) {
		this.science = science;
	}
	public String getGujarati() {
		return gujarati;
	}
	public void setGujarati(String gujarati) {
		this.gujarati = gujarati;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
