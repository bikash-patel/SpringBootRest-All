package com.bikash.service;

import java.util.Optional;

import com.bikash.entity.JobSeekers;

public interface IJobSeekersService {
	public String addJobSeekers(JobSeekers js);
	public Optional<JobSeekers> retriveJobSeekers(Integer id);
}
