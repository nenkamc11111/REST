package com.thbingenws920.springspark.springsparkcode.service;

import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbingenws920.springspark.springsparkcode.model.Application;
import com.thbingenws920.springspark.springsparkcode.model.Job;

@Service
public class SparkCodeService {

	@Autowired
	JavaSparkContext sc;

	public Map<String, Long> getCount(List<String> wordList) {

		JavaRDD<String> words = sc.parallelize(wordList);
		Map<String, Long> wordCounts = words.countByValue();
		return wordCounts;
	}

	public List<Application> getApplications() {
		// processing with spark...
		// JavaRDD<String> words = ...;
		return null;
	}

	public List<Job> getAllJobs(Integer appId) {
		// Processing with spark
		// JavaRDD<String> words = ...;
		List<Job> jobs = null;
		// jobs = Get data from spark...;
		return jobs;
	}

	public Job getJobById(Integer appId, Integer jobId) {
		// Processing with spark
		// JavaRDD<String> words = ...;
		List<Job> listJob = this.getAllJobs(appId);
		for (Job job : listJob) {
			if (job.getId() == jobId) {
				return job;
			}
		}
		return null;
	}
}
