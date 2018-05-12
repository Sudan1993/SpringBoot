package com.sudaraje.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getById(String id) {
		//return topics.stream().filter(i -> i.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
//		for(int i =0 ; i< topics.size() ; i ++ ) {
//			Topic temp = topics.get(i);
//			if(temp.getId().equals(id)) {
//				topics.set(i,topic);
//			}	
//		}
		topicRepository.save(topic);
	}

	public void removeTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
//		for(int i =0 ; i< topics.size() ; i ++ ) {
//			Topic temp = topics.get(i);
//			if(temp.getId().equals(id)) {
//				topics.remove(i);
//			}
//		}
		topicRepository.delete(topic);
		
	}
}
