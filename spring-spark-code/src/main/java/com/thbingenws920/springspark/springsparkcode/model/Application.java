package com.thbingenws920.springspark.springsparkcode.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("application")
public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	@Column("id")
	private Integer id;
	@Column("name")
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
