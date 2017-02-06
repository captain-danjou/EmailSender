package com.davidweaver.emailsender.RestResources;

import com.davidweaver.emailsender.Entities.DTO.EmailSendAck;
import com.davidweaver.emailsender.Entities.DTO.EmailSendRequest;
import com.davidweaver.emailsender.Model.EmailSendRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by david.weaver on 05/02/17.
 */
@RestController
@RequestMapping("/SendEmailRequests")
public class SendEmailRequestsResource {


    @Autowired
    private EmailSendRequestHandler sendHandler;

    @RequestMapping(method = RequestMethod.POST,value = "/")
    public @ResponseBody
    EmailSendAck getSendEmailRequestStatus(@RequestBody EmailSendRequest request){
        return sendHandler.onRequest(request);
    }
}
