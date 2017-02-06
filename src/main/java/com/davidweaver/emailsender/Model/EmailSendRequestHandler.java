package com.davidweaver.emailsender.Model;

import com.davidweaver.emailsender.DataAccess.EmailSenderDAO;
import com.davidweaver.emailsender.Entities.DTO.EmailSendAck;
import com.davidweaver.emailsender.Entities.DTO.EmailSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by david.weaver on 05/02/17.
 */
@Service
public class EmailSendRequestHandler {
    @Autowired
    SMTPService smtpService;
    @Autowired
    @Qualifier("TestEmailSenderDAOImpl")
    private EmailSenderDAO dao;

    public EmailSendAck onRequest(EmailSendRequest sendRequest){
        smtpService.processEmailSendRequest(sendRequest);
        dao.recordSendEmailAckRequestId(sendRequest.getRequestId());
        return EmailSendAck.createAnEmailSendAck(sendRequest.getRequestId(), EmailSendAck.Status.OK);
    }

}
