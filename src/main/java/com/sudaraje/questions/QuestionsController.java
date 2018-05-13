package com.sudaraje.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudaraje.topics.Topic;

@RestController
public class QuestionsController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/topics/{id}/questions")
	public List<Questions> getAllQuestions(@PathVariable("id") String id){
		return questionService.getAllQuestions(id);
	}
	
	@RequestMapping("/topics/{topicId}/questions/{id}")
	public Questions getQuestionById(@PathVariable("id") Long id) {
		return questionService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/questions")
	public void addQuestion(@RequestBody Questions question,@PathVariable String topicId) {
		question.setTopic(new Topic(topicId,"",""));
		questionService.addQuestion(question);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/questions/{id}")
	public void updateQuestion(@RequestBody Questions question , @PathVariable String topicId,@PathVariable String id) {
		question.setTopic(new Topic(topicId,"",""));
		questionService.addQuestion(id,question);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}//questions/{id}")
	public void removeQuestion(@RequestBody Questions question , @PathVariable Long id) {
		questionService.removeQuestion(id,question);
	}
};