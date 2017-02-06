package com.davidweaver.emailsender.Model;

import com.davidweaver.emailsender.DataAccess.EmailSenderDAO;
import com.davidweaver.emailsender.Entities.DTO.EmailSendAck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by david.weaver on 05/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailSendAckRequestHandlerTest {
    @Mock
    EmailSenderDAO dao;

    @InjectMocks
    EmailSendAckRequestHandler handlerUnderTest = new EmailSendAckRequestHandler();

    @Test
    public void verifyAckStatusOK(){
        setupEmailSenderDAOMock();

        assertEquals(handlerUnderTest.retrieveEmailSendAck("1"), EmailSendAck.createAnEmailSendAck("1", EmailSendAck.Status.OK));

    }

    @Test
    public void verifyAckStatusError(){
        setupEmailSenderDAOMock();

        assertEquals(handlerUnderTest.retrieveEmailSendAck("2"), EmailSendAck.createAnEmailSendAck("2", EmailSendAck.Status.ERROR));

    }

    private void setupEmailSenderDAOMock() {
        when(dao.retrieveSendEmailAckRequestId("1")).thenReturn("1");
        when(dao.retrieveSendEmailAckRequestId("2")).thenReturn(null);

    }


}
