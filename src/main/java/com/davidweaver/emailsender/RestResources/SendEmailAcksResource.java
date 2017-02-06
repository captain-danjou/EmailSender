package com.davidweaver.emailsender.RestResources;

import com.davidweaver.emailsender.Entities.DTO.EmailSendAck;
import com.davidweaver.emailsender.Model.EmailSendAckRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by david.weaver on 05/02/17.
 */


@RestController
@RequestMapping("/SendEmailAcks")
public class SendEmailAcksResource {

    @Autowired
    private EmailSendAckRequestHandler ackHandler;

    @RequestMapping(method = RequestMethod.GET,value = "/{requestId}")
    public @ResponseBody
    EmailSendAck getSendEmailRequestStatus(@PathVariable String requestId){
        return ackHandler.retrieveEmailSendAck(requestId);
    }


}
