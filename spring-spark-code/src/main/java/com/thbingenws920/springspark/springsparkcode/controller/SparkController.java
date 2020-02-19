package com.thbingenws920.springspark.springsparkcode.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thbingenws920.springspark.springsparkcode.model.Application;
import com.thbingenws920.springspark.springsparkcode.model.Job;
import com.thbingenws920.springspark.springsparkcode.service.SparkCodeService;

@RestController
public class SparkController {

	@Autowired
	SparkCodeService service;

	@PostMapping(path = "/wordcount")
	public Map<String, Long> count(@RequestParam(required = true) String words) {
		List<String> wordList = Arrays.asList(words.split("\\|"));
		return service.getCount(wordList);
	}

	@GetMapping("/applications")
	List<Application> getApplications() {// Der passende Datentyp anpassen...
		//List<Application> apps = service.getApplications();
		List<Application> apps = new ArrayList<>();
		apps.add(new Application(1, "App-1"));
		apps.add(new Application(2, "App-2"));
		apps.add(new Application(3, "App-3"));
		return apps;
	}

	@GetMapping("/applications/{app-id}/jobs")
	public List<Job> getAllJobs(@PathVariable("app-id") Integer appId) {// Der passende Datentyp anpassen...
		List<Job> jobs = this.service.getAllJobs(appId);
		return jobs;
	}

	@GetMapping("/applications/{app-id}/jobs/{job-id}")
	public Job getJobById(@PathVariable("app-id") Integer appId, @PathVariable("job-id") Integer jobId) {// Der passende
																											// Datentyp																						// anpassen...
		Job job = this.service.getJobById(appId, jobId);
		return job;
	}
}
