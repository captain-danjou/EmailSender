package com.davidweaver.emailsender.Model;

import org.springframework.stereotype.Component;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

import static javax.mail.Session.*;

/**
 * Created by david.weaver on 05/02/17.
 */
@Component
class SessionWrapperFactory {

    public static final String SMTP_RELAY_USERNAME = "danjou";
    public static final String SMTP_RELAY_PASSWORD = "Passport1!";
    public static final String SMTP_RELAY = "express-relay.jangosmtp.net";
    public static final String SMTP_RELAY_PORT = "2525";

    SessionWrapper buildAuthenticatedSession() {
        SessionWrapper session = new SessionWrapper();

        String host = SMTP_RELAY;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", SMTP_RELAY_PORT);

        session.setupAuthenticatedSession(props, SMTP_RELAY_USERNAME, SMTP_RELAY_PASSWORD);

        return session;
    }

    class SessionWrapper {

        private Session session;

        public void setupAuthenticatedSession(Properties props, String smtpUsername, String smtpPassword) {
            this.session = getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(smtpUsername, smtpPassword);
                        }
                    });
        }

        public Session getSession() {
            return session;
        }
    }
}
