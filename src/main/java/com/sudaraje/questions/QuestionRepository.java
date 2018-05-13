package com.sudaraje.questions;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Questions, Long>{

	public List<Questions> findByTopicId(String topicId);
}
