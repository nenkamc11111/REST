package com.thbingenws920.springspark.springsparkcode.model;

public class Application {

	private Integer id;
	private String name;

	public Application(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Application() {
	}

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

}
