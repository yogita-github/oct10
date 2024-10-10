package com.demo.beans;
import java.time.LocalDate;

public class Person {
	private int pid;
	private String pname;
	private String address;
	private LocalDate bdate;
	public Person() {
		super();
		//System.out.println("in Person default constructor");
	}
	public Person(int pid, String pname, String address, LocalDate bdate) {
		super();
		//System.out.println("in person parametrized constructor");
		//change the code to autogenerate ID, 
		// faculty Id should start with f, masterStudent id should starts with m
		//and graduate student id should start with g
		this.pid = pid;
		this.pname = pname;
		this.address = address;
		this.bdate = bdate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getBdate() {
		return bdate;
	}
	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", address=" + address + ", bdate=" + bdate + "]";
	}
	

}
