package com.davidweaver.emailsender.Model;

import com.davidweaver.emailsender.DataAccess.EmailSenderDAO;
import com.davidweaver.emailsender.Entities.DTO.EmailSendAck;
import com.davidweaver.emailsender.Entities.DTO.EmailSendRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by david.weaver on 05/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailSendRequestHandlerTest {
    @Mock
    SMTPService smtpService;

    @Mock
    EmailSenderDAO dao;

    @InjectMocks
    EmailSendRequestHandler handlerUnderTest = new EmailSendRequestHandler();

    @Test
    public void verifyOnRequestReturnsAckWithCorrectIdAndStatus(){
        EmailSendRequest requestWithId1 = createAnEmailSendRequest();

        assertEquals(handlerUnderTest.onRequest(requestWithId1), EmailSendAck.createAnEmailSendAck("1", EmailSendAck.Status.OK));

    }

    @Test
    public void verifySMTPServiceAndAckDAOCalls(){
        EmailSendRequest requestWithId1 = createAnEmailSendRequest();

        handlerUnderTest.onRequest(requestWithId1);

        verify(dao,times(1)).recordSendEmailAckRequestId("1");
        verify(smtpService,times(1)).processEmailSendRequest(requestWithId1);
    }

    private EmailSendRequest createAnEmailSendRequest() {
        EmailSendRequest requestWithId1 = new EmailSendRequest();
        requestWithId1.setRequestId("1");
        return requestWithId1;
    }


}
