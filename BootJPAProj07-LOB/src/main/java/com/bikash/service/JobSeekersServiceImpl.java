package com.bikash.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.JobSeekers;
import com.bikash.repository.JobSeekerRepository;

@Service
public class JobSeekersServiceImpl implements IJobSeekersService {

	@Autowired
	private JobSeekerRepository seekerRepo;
	
	@Override
	public String addJobSeekers(JobSeekers js) {
		int id=seekerRepo.save(js).getJsId();
		return "Job Seekers details saved with id : "+id;
	}

	@Override
	public Optional<JobSeekers> retriveJobSeekers(Integer id) {
		Optional<JobSeekers> jobSeeker=seekerRepo.findById(id);
		return jobSeeker;
	}

}
