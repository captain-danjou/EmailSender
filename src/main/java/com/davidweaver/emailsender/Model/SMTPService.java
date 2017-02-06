package com.davidweaver.emailsender.Model;

import com.davidweaver.emailsender.Entities.DTO.EmailSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by david.weaver on 05/02/17.
 */
@Service
public class SMTPService {

    private SessionWrapperFactory.SessionWrapper session;
    @Autowired
    private TransportWrapper transportWrapper;
    @Autowired
    private SessionWrapperFactory sessionWrapperFactory;

    public void processEmailSendRequest(EmailSendRequest sendRequest) {
        try{
            processEmailSendRequestExposingMessage(sendRequest);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    Message processEmailSendRequestExposingMessage(EmailSendRequest sendRequest) throws MessagingException {
        String to = sendRequest.getToEmailAddress();
        String from = sendRequest.getFromEmailAddress();
        String subject = sendRequest.getSubject();
        String body = sendRequest.getBody();

        session = sessionWrapperFactory.buildAuthenticatedSession();
        Message message = buildMessage(to, from, subject, body, session.getSession());
        transportWrapper.callStaticSendMethod(message);

        return message;

    }


    private Message buildMessage(String to, String from, String subject, String body, Session session) throws MessagingException {
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        return message;
    }
}
