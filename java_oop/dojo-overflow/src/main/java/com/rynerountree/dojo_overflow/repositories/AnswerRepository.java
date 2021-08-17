package com.rynerountree.dojo_overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rynerountree.dojo_overflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

}