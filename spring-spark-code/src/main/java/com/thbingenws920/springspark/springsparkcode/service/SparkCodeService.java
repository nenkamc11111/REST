package com.thbingenws920.springspark.springsparkcode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbingenws920.springspark.springsparkcode.model.Application;
import com.thbingenws920.springspark.springsparkcode.model.Job;
import com.thbingenws920.springspark.springsparkcode.repository.ApplicationRepository;
import com.thbingenws920.springspark.springsparkcode.repository.JobRepository;

@Service
public class SparkCodeService {

	@Autowired
	private JavaSparkContext sc;
	@Autowired
	private JobRepository jobRepo;
	@Autowired
	private ApplicationRepository appRepo;
	
	// Example
	public Map<String, Long> getCount(List<String> wordList) {

		JavaRDD<String> words = sc.parallelize(wordList);
		Map<String, Long> wordCounts = words.countByValue();
		return wordCounts;
	}

	// SPARK PROCESSING AND GET DATA FROM 
	public List<Application> getApplicationsSpark() {
		// processing with spark...
		// JavaRDD<String> words = sc.textFile("fileName");
		List<Application> apps = new ArrayList<>();
		apps.add(new Application(1, "App-1"));
		apps.add(new Application(2, "App-2"));
		apps.add(new Application(3, "App-3"));
		return apps;
	}

	public List<Job> getAllJobsSpark(Integer appId) {
		// Processing with spark
		// JavaRDD<String> words = ...;
		List<Job> jobs = null;
		// jobs = Get data from spark...;
		return jobs;
	}

	public Job getJobByIdSpark(Integer appId, Integer jobId) {
		// Processing with spark
		// JavaRDD<String> words = ...;
		List<Job> listJob = this.getAllJobsSpark(appId);
		for (Job job : listJob) {
			if (job.getId() == jobId) {
				return job;
			}
		}
		return null;
	}
	
	// CASSANDRA DATA GET POST DELETE OR PUT
	// JOBS
	public List<Job> getJobsCassandra(){
		List<Job> jobs = this.jobRepo.findAll();
		return jobs;
	}
	
	public Optional<Job> getJobByIdCassandra(Integer id) {
		return this.jobRepo.findById(id);
	}
	
	public void addJobCassandra(Job job) {// Add or Update
		this.jobRepo.save(job);
	}
	
	public void deleteJobCassandra(Job job) {
		this.jobRepo.delete(job);
	}
	
	public void deleteJobByIdCassandra(Integer id) {
		this.jobRepo.deleteById(id);
	}
	
	// APPLICATIONS
	public List<Application> getApplicationsCassandra(){
		List<Application> apps = this.appRepo.findAll();
		return apps;
	}
	
	public Optional<Application> getApplicationByIdCassandra(Integer id) {
		return this.appRepo.findById(id);
	}
	
	public void addApplicationCassandra(Application app) {// Add or Update
		this.appRepo.save(app);
	}
	
	public void deleteAppCassandra(Application app) {
		this.appRepo.delete(app);
	}
	
	public void deleteAppByIdCassandra(Integer id) {
		this.appRepo.deleteById(id);
	}
}
