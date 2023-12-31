package com.onerivet.deskbook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.onerivet.deskbook.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;
	
	@Override
	public String sendMailRequest(String to, String subject, String body) throws MessagingException {
		
//		MimeMessage message = javaMailSender.createMimeMessage();
//		
//        MimeMessageHelper helper;
//        
//        helper = new MimeMessageHelper(message, true);//true indicates multipart message
//
//        helper.setFrom("DeskBook.1rivet@outlook.com"); // <--- THIS IS IMPORTANT
//        
//        helper.setSubject(subject);
//        helper.setTo(to);
//        helper.setText(body, true);//true indicates body is html
//        javaMailSender.send(message);
	
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setFrom("");
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);
		
		javaMailSender.send(mail);
		return "Send";
		
	}

}
