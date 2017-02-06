package com.davidweaver.emailsender; /**
 * Created by david.weaver on 05/02/17.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSender {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmailSender.class, args);
    }

}
