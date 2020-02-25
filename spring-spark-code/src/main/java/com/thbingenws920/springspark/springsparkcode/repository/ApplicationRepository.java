package com.thbingenws920.springspark.springsparkcode.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.thbingenws920.springspark.springsparkcode.model.Application;

public interface ApplicationRepository extends CassandraRepository<Application, Integer>{

}
