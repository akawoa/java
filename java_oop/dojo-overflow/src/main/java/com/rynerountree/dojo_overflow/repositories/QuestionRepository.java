package com.rynerountree.dojo_overflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rynerountree.dojo_overflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	Optional<Question> findById(Long id);
}