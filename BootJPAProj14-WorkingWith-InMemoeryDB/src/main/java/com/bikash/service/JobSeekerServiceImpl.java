package com.bikash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.JobSeeker;
import com.bikash.repository.JobSeekerRepo;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService {

	@Autowired
    private	JobSeekerRepo jobRepo;
	
	@Override
	public String jobSeekerSaveInGroup(List<JobSeeker> jobSeek) {
		List<JobSeeker> list=jobRepo.saveAll(jobSeek);
		return list.size()+" Job Seeker saved";
	}

	@Override
	public Iterable<JobSeeker> getAllJobSeeker() {
		List<JobSeeker> opt=jobRepo.findAll();
		return opt;
	}

	@Override
	public String getJobSeekerById(Integer id) {
		Optional<JobSeeker> js=jobRepo.findById(id);
		if(js.isPresent())
		{
			JobSeeker jobSeeker=js.get();
			return "Job Seeker Details : "+jobSeeker;
		}
			return "Id not found";
	}
	
}
