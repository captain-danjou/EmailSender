package com.davidweaver.emailsender.DataAccess;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by david.weaver on 05/02/17.
 */
@Repository
@Qualifier("TestEmailSenderDAOImpl")
public class TestEmailSenderDAOImpl implements EmailSenderDAO {
    private Set<String> sendEmailAcks = new HashSet<String>();

    @Override
    public String retrieveSendEmailAckRequestId(String requestId){
        if(sendEmailAcks.contains(requestId)){
            return requestId;
        } else {
            return null;
        }
    }

    @Override
    public void recordSendEmailAckRequestId(String requestId) {
        sendEmailAcks.add(requestId);
    }


}
