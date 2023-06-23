package com.onerivet.deskbook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.onerivet.deskbook.models.payload.EmailDto;
import com.onerivet.deskbook.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

	 private final JavaMailSender javaMailSender;
	    private final TemplateEngine templateEngine;

	    @Autowired
	    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
	        this.javaMailSender = javaMailSender;
	        this.templateEngine = templateEngine;
	    }
	    
	@Override
	public void sendMailRequest(EmailDto emaiDto) throws  MessagingException {
		
		 // Create a Thymeleaf context and add variables
        Context context = new Context();
        context.setVariable("body", emaiDto.getBody());

        // Process the HTML template with Thymeleaf
        String htmlBody = templateEngine.process("requesttoseatowner", context);

        // Create a MimeMessage and set the content
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setFrom("DeskBook.1Rivet@outlook.com");
        helper.setTo(emaiDto.getTo());
        helper.setSubject(emaiDto.getSubject());
        helper.setText(htmlBody, true);

        // Send the email
        javaMailSender.send(message);
	}

	@Override
	public void sendMailApprove(EmailDto emaiDto) throws MessagingException {
		 // Create a Thymeleaf context and add variables
        Context context = new Context();
        context.setVariable("body", emaiDto.getBody());

        // Process the HTML template with Thymeleaf
        String htmlBody = templateEngine.process("seatacceptedofemployee", context);

        // Create a MimeMessage and set the content
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setFrom("DeskBook.1Rivet@outlook.com");
        helper.setTo(emaiDto.getTo());
        helper.setSubject(emaiDto.getSubject());
        helper.setText(htmlBody, true);

        // Send the email
        javaMailSender.send(message);
	}

	@Override
	public void sendMailReject(EmailDto emaiDto) throws MessagingException {
		 // Create a Thymeleaf context and add variables
        Context context = new Context();
        context.setVariable("body", emaiDto.getBody());

        // Process the HTML template with Thymeleaf
        String htmlBody = templateEngine.process("seatrejectionmailtoemployee", context);

        // Create a MimeMessage and set the content
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setFrom("DeskBook.1Rivet@outlook.com");
        helper.setTo(emaiDto.getTo());
        helper.setSubject(emaiDto.getSubject());
        helper.setText(htmlBody, true);

        // Send the email
        javaMailSender.send(message);
	}

	@Override
	public void sendMailCancel(EmailDto emaiDto) throws MessagingException {
		 // Create a Thymeleaf context and add variables
        Context context = new Context();
        context.setVariable("body", emaiDto.getBody());

        // Process the HTML template with Thymeleaf
        String htmlBody = templateEngine.process("seatcancellationmailtoowner", context);

        // Create a MimeMessage and set the content
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setFrom("DeskBook.1Rivet@outlook.com");
        helper.setTo(emaiDto.getTo());
        helper.setSubject(emaiDto.getSubject());
        helper.setText(htmlBody, true);

        // Send the email
        javaMailSender.send(message);
	}
}
