package com.target.exercise.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.target.exercise.model.Feedback;
import com.target.exercise.model.GetFeedbackResponse;
import com.target.exercise.model.Message;
import com.target.exercise.service.FeedbackService;


@Component
public class FeedbackServiceImpl implements FeedbackService {
	
	static Set<String> objectionableWords = new HashSet<>();
	
	static{
		objectionableWords.add("objcont1");
		objectionableWords.add("objcont2");
		objectionableWords.add("objcont3");
		objectionableWords.add("objcont4");

	}


	@Override
	public GetFeedbackResponse getFeedback(Message message)  {
		GetFeedbackResponse getFeedbackResponse = new GetFeedbackResponse();
		Feedback feedback = new Feedback();

		if(message != null && message.getMessage() != null) {
			String[] split = message.getMessage().split(" ");
			for(int i=0 ;i<split.length;i++) {
				if(split[i] != null) {
					String curString = split[i].toLowerCase(); 
					if(objectionableWords.contains(curString)) {
						feedback.setMessage("Objectionable Content Found");
						getFeedbackResponse.setFeedback(feedback);
						return getFeedbackResponse;
					}
				}
			}
		}
		
		feedback.setMessage("objectionable Content Not Found");
		getFeedbackResponse.setFeedback(feedback );
		return getFeedbackResponse;
	}
}
