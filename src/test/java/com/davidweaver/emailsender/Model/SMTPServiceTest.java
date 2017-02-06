package com.davidweaver.emailsender.Model;

import com.davidweaver.emailsender.Entities.DTO.EmailSendRequest;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.*;

/**
 * Created by david.weaver on 05/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class SMTPServiceTest {
    @Mock
    private SessionWrapperFactory sessionFactory;
    @Mock
    private TransportWrapper transportWrapper;

    @InjectMocks
    SMTPService serviceUnderTest = new SMTPService();

    private SessionWrapperFactory.SessionWrapper sessionWrapper;

    @Test
    public void verifyEmailSendRequestAttributesPassedToMessageCorrectly() throws MessagingException, IOException {
        setupTheSessionFactoryMock();
        EmailSendRequest sendRequest = createAnEmailSendRequest();


        Message messageSent = serviceUnderTest.processEmailSendRequestExposingMessage(sendRequest);
        assertEquals( messageSent.getFrom()[0], new InternetAddress("2"));
        assertEquals(messageSent.getAllRecipients()[0], new InternetAddress("3"));
        assertEquals(messageSent.getSubject(), "4");
        assertEquals(messageSent.getContent(), "5");

    }

    private void setupTheSessionFactoryMock() {
        sessionWrapper = new SessionWrapperFactory().buildAuthenticatedSession();

        when(sessionFactory.buildAuthenticatedSession()).thenReturn(sessionWrapper);
    }

    private EmailSendRequest createAnEmailSendRequest() {
        EmailSendRequest sendRequest = new EmailSendRequest();
        sendRequest.setRequestId("1");
        sendRequest.setFromEmailAddress("2");
        sendRequest.setToEmailAddress("3");
        sendRequest.setSubject("4");
        sendRequest.setBody("5");
        return sendRequest;
    }

    private Message createAMessage() throws MessagingException {
        Message message = new MimeMessage(sessionWrapper.getSession());

        message.setFrom(new InternetAddress("2"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("3"));
        message.setSubject("4");
        message.setText("5");
        return message;
    }


}
