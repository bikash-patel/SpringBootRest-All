package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.JobSeekers;

public interface JobSeekerRepository extends JpaRepository<JobSeekers,Integer> {

}
