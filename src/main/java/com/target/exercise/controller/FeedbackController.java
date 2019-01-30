package com.target.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.target.exercise.model.GenericServiceResponse;
import com.target.exercise.model.GetFeedbackResponse;
import com.target.exercise.model.Message;
import com.target.exercise.service.FeedbackService;


@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;


	@RequestMapping(value = "/feedback", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericServiceResponse<GetFeedbackResponse> getFeedback(
			@RequestParam(name = "message", required = false) String messageString){
		GenericServiceResponse<GetFeedbackResponse> genericServiceResponse = new GenericServiceResponse<GetFeedbackResponse>();
		Message message = new Message();
		message.setMessage(messageString);

		GetFeedbackResponse getFeedbackResponse = feedbackService.getFeedback(message);
		genericServiceResponse.setPayload(getFeedbackResponse);
		genericServiceResponse.setStatus("SUCCESS");
		return genericServiceResponse;
	}

}
