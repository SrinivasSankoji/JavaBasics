package com.jio.ngo.noteit.api;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.noteit.api.viewmodel.FeedbackViewModel;
import com.jio.ngo.noteit.mail.FeedbackSender;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController 
{
	@Autowired
	FeedbackSender feedbackSender;

	@PostMapping
	public void sendFeedback(@RequestBody FeedbackViewModel feedbackViewModel, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Feedback has errors; Can not send feedback;");
		}

		feedbackSender.sendFeedback(feedbackViewModel.getEmail(), feedbackViewModel.getName(),
				feedbackViewModel.getFeedback());
	}
}
