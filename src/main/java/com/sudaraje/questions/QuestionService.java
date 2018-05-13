package com.sudaraje.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Questions> getAllQuestions(String topicId){
		List<Questions> questions = new ArrayList<>();		
		questionRepository.findByTopicId(topicId).forEach(questions::add);
		return questions;
	}
	
	public Questions getById(Long id) {
		//return topics.stream().filter(i -> i.getId().equals(id)).findFirst().get();
		return questionRepository.findOne(id);
	}

	public void addQuestion(Questions question) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		questionRepository.save(question);
		
	}

	public void addQuestion(String id, Questions question) {
		// TODO Auto-generated method stub
		questionRepository.save(question);
	}

	public void removeQuestion(Long id, Questions question) {
		// TODO Auto-generated method stub
		questionRepository.delete(question);
		
	}

}
