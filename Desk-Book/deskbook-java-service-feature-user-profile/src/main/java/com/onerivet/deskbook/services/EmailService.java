package com.onerivet.deskbook.services;

import jakarta.mail.MessagingException;

public interface EmailService {
	
	public String sendMailRequest(String to , String subject , String body) throws MessagingException;

}
