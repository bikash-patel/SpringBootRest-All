package com.bikash.service;

import java.util.List;

import com.bikash.entity.JobSeeker;

public interface IJobSeekerService {
	public String jobSeekerSaveInGroup(List<JobSeeker> jobSeek);
	public Iterable<JobSeeker> getAllJobSeeker();
	public String getJobSeekerById(Integer id);
}
