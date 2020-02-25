package com.thbingenws920.springspark.springsparkcode.model;

import java.io.Serializable;
import java.time.LocalTime;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("job")
public class Job implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	@Column("id")
	private Integer id;
	@Column("status")
	private String status;
	@Column("start")
	private LocalTime start;
	@Column("end")
	private LocalTime end;

	
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}

}
