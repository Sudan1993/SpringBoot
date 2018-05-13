package com.sudaraje.questions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sudaraje.topics.Topic;

@Entity
public class Questions {

	@Id
	private Long id;
	private String question;
	
	@ManyToOne
	private Topic topic;
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Questions(Long id, String question, String description,String topicId) {
		super();
		this.id = id;
		this.question = question;
		this.topic = new Topic(topicId,"","");
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Questions() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", question=" + question + "]";
	}	

	
}
