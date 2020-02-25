package com.thbingenws920.springspark.springsparkcode.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thbingenws920.springspark.springsparkcode.model.Application;
import com.thbingenws920.springspark.springsparkcode.model.Job;
import com.thbingenws920.springspark.springsparkcode.service.SparkCodeService;

@RestController
public class SparkController {

	@Autowired
	SparkCodeService service;

	// EXEMPLE
	@PostMapping(path = "/wordcount")
	public Map<String, Long> count(@RequestParam(required = true) String words) {
		List<String> wordList = Arrays.asList(words.split("\\|"));
		return service.getCount(wordList);
	}

	// GET DATA FROM SPARK...
	@GetMapping("/applications/spark")
	List<Application> getApplicationsSpark() {// Der passende Datentyp anpassen...		
		return service.getApplicationsSpark();
	}

	@GetMapping("/applications/{app-id}/jobs")
	public List<Job> getAllJobsSpark(@PathVariable("app-id") Integer appId) {// Der passende Datentyp anpassen...
		List<Job> jobs = this.service.getAllJobsSpark(appId);
		return jobs;
	}

	@GetMapping("/applications/{app-id}/jobs/{job-id}")
	public Job getJobByIdSpark(@PathVariable("app-id") Integer appId, @PathVariable("job-id") Integer jobId) {// Der passende
																											// Datentyp																						// anpassen...
		Job job = this.service.getJobByIdSpark(appId, jobId);
		return job;
	}
	
	// CRUD ENDPOINTS FOR CASSANDRA
	// JOBS
	@GetMapping("/jobs")
	public List<Job> getJobsCassandra(){
		List<Job> jobs = this.service.getJobsCassandra();
		return jobs;
	}
	
	@GetMapping("/jobs/{id}")
	public Optional<Job> getJobByIdCassandra(Integer id) {
		return this.service.getJobByIdCassandra(id);
	}
	
	@PostMapping("/jobs")
	public void addJobCassandra(@RequestBody Job job) {// Add or Update
		this.service.addJobCassandra(job);
	}
	
	@DeleteMapping("/jobs")
	public void deleteJobCassandra(@RequestBody Job job) {
		this.service.deleteJobCassandra(job);
	}
	
	@DeleteMapping("/jobs/{id}")
	public void deleteByIdCassandra(@PathVariable Integer id) {
		this.service.deleteJobByIdCassandra(id);
	}
	
	// APPLICATIONS
	@GetMapping("/applications/cassandra")
	public List<Application> getAppsCassandra(){
		List<Application> apps = this.service.getApplicationsCassandra();
		return apps;
	}
	
	@GetMapping("/applications/{id}")
	public Optional<Application> getAppByIdCassandra(Integer id) {
		return this.service.getApplicationByIdCassandra(id);
	}
	
	@PostMapping("/applications/cassandra")
	public void addApplicationCassandra(@RequestBody Application app) {// Add or Update
		this.service.addApplicationCassandra(app);
	}
	
	@DeleteMapping("/applications/cassandra")
	public void deleteApplicationCassandra(@RequestBody Application app) {
		this.service.deleteAppCassandra(app);
	}
	
	@DeleteMapping("/applications/{id}")
	public void deleteApplicationByIdCassandra(@PathVariable Integer id) {
		this.service.deleteAppByIdCassandra(id);
	}
}
