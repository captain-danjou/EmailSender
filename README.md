# EmailSender

Service which forwards email to an smtp server.

Implemented as a SpringBoot project. So you should be able to compile and run it with `mvn spring-boot:run`.

I've implemented the sender as a REST service, with 2 resources:

- SendEmailRequests/
- SendEmailAcks/

You can POST to SendEmailRequests/, and this will forward an email message to an SMTP server, and write an Ack (returning it in the response body).

You can GET the SendEmailAcks/{id} to return the ack you're interested in.

I've just been using a chrome plugin called "postman" as my test client (https://www.getpostman.com/docs/introduction), since there's no point reinventing the wheel. So once you're running the project with `mvn spring-boot:run`, then you can just hit eg. http://localhost:8080/SendEmailAcks/1 in your browser.

The SendEmailRequests/ POST requires a body of the form, eg:

{
	"requestId":"6",
  "fromEmailAddress":"from@gmail.com",
  "toEmailAddress":"to@gmail.com",
  "subject":"A test",
  "body":"Hi, Just a quick test"
}

I've been using JangoSMTP as my SMTP relay. I've set-up a trial account (config is all in the SessionWrapperFactory class), which should be good for the next 30 days (from 05/02/2017).

Improvements:
  
  - Sequential, so will block on unresponsive smtp server (client will wait for response from SMTP)
  - Extra coverage needed on SMTPServer (Eg. Exception thrown still needs to be covered; Need to verify session created, message sent to Transport)
  - Exceptions returned in http response. We should instead return emailack with status.ERROR, and log the stacktrace.
  - Some nice way of handling configuration (for the smtp session)
  - Secure the service for client (https)
  - Secure the service with auth
  - Persist the Acks properly (Currently just in memory)
  - Round out the REST resources a bit
