package com.bikash.repository.offeres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikash.entity.offeres.Offeres;

@Repository
public interface IRepoOfferes extends JpaRepository<Offeres,Integer> {

}
