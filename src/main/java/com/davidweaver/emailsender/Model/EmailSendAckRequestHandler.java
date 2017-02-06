package com.davidweaver.emailsender.Model;

import com.davidweaver.emailsender.DataAccess.EmailSenderDAO;
import com.davidweaver.emailsender.Entities.DTO.EmailSendAck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by david.weaver on 05/02/17.
 */
@Service
public class EmailSendAckRequestHandler {
    @Autowired
    @Qualifier("TestEmailSenderDAOImpl")
    private EmailSenderDAO dao;

    public EmailSendAck retrieveEmailSendAck(String requestId){
        EmailSendAck ack;

        String returnedRequestId = dao.retrieveSendEmailAckRequestId(requestId);
        if(returnedRequestId == null){
            ack = EmailSendAck.createAnEmailSendAck(requestId, EmailSendAck.Status.ERROR);
        } else {
            ack = EmailSendAck.createAnEmailSendAck(requestId, EmailSendAck.Status.OK);
        }

        return ack;
    }
}
