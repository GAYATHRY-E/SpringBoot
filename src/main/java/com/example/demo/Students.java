package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
	@Id
	private int sid;
	private String sname;
	private String stopic;
	private int smark;
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStopic() {
		return stopic;
	}
	public void setStopic(String stopic) {
		this.stopic = stopic;
	}
	public int getSmark() {
		return smark;
	}
	public void setSmark(int smark) {
		this.smark = smark;
	}
	
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", stopic=" + stopic + ", smark=" + smark + "]";
	}
	

}
