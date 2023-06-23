package com.springcore.springcore;

public class Student1 {
	private int studentId;
	private String studentName;
	private String studentAddress;
	private Subject subject;
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Student1(int studentId, String studentName, String studentAddress, Subject subject) {
		super();
		this.subject = subject;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
