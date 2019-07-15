package com.rentocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rentocar.model.Email;
import com.rentocar.model.Message;
import com.rentocar.model.User;

@RestController
public class CustomMailSender 	{
    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
    private RestTemplate restTemplate;
    
	private String baseURL = "http://rentocar-rest-service/";
    
    @PostMapping("/mail")
    public Message sendEmail(@RequestBody Email email)	{
    	SimpleMailMessage message = new SimpleMailMessage();
    	message.setTo(email.getTo());
    	message.setSubject(email.getSubject());
    	message.setText(email.getText());
    	
    	try	{
    		emailSender.send(message);
    		return new Message("Mail Sent to: " + email.getTo(), "success");
    	}
    	catch(MailException me)	{
    		System.out.println(me);
    		return new Message("Mail was not sent to " + email.getTo(), "failure");
    	}
    }	
    
	@RequestMapping("/account_recovery/{drivingLicenseNum}")
	public Message sendRecoveryMail(@PathVariable("drivingLicenseNum") String drivingLicenseNum)	{
		User user = restTemplate.getForObject(this.baseURL + "/user/forgot_password/" + drivingLicenseNum , User.class);
		
		if(user.getEmail() != null)	{
			String text = "Hi " + user.getFirstName() + " we got a request of account recovery with driving License id: " +
						user.getDrivingLicenseNum() + " and your password is: " + user.getPassword() + " , please change your " +
						"password when you log in next time";
			Email email = new Email(user.getEmail(), "Account Recovery mail", "");
			
			email.setText(text);
			
			// Send Mail logic
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			
			try	{
				emailSender.send(message);
				return new Message("Mail sent for account recovery", "success");
			}
			catch(MailException me)	{
				return new Message("Mail is not sent, account email might be wrong", "failure");
			}
		}
		else	{
			return new Message("Mail can't be sent, no user account found with this driving license id", "failure");
		}
	}
}
