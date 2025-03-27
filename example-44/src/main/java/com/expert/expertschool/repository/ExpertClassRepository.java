package com.expert.expertschool.repository;

import com.expert.expertschool.model.ExpertClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertClassRepository extends JpaRepository<ExpertClass, Integer> {

}
