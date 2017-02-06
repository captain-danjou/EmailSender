package com.davidweaver.emailsender.Model;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

/**
 * Created by david.weaver on 05/02/17.
 */
@Component
class TransportWrapper {

    void callStaticSendMethod(Message message) throws MessagingException {
        Transport.send(message);
    }
}
