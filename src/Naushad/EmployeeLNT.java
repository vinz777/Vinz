package com.lnt.day20;

public class EmployeeLNT {
	private int id;
	private String name;
	
	public EmployeeLNT() {
			}
	public EmployeeLNT(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name+"]";
	}
}
