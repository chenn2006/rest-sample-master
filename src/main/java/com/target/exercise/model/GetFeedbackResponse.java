package com.target.exercise.model;

import java.io.Serializable;


public class GetFeedbackResponse implements Serializable {

	public GetFeedbackResponse() {
		super();
	}

	Feedback feedback;
	
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetFeedbackResponse other = (GetFeedbackResponse) obj;
		if (feedback == null) {
			if (other.feedback != null)
				return false;
		} else if (!feedback.equals(other.feedback))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
}
