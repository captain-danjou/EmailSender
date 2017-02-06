package com.davidweaver.emailsender.DataAccess;

/**
 * Created by david.weaver on 05/02/17.
 */
public interface EmailSenderDAO {
    String retrieveSendEmailAckRequestId(String requestId);

    void recordSendEmailAckRequestId(String requestId);
}
