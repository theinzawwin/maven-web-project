package com.best.mtest;


public class Category {

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
