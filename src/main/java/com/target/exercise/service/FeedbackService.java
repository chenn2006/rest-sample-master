package com.target.exercise.service;

import com.target.exercise.model.GetFeedbackResponse;
import com.target.exercise.model.Message;


public interface FeedbackService {

	GetFeedbackResponse getFeedback(Message message);

}