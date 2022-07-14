package org.sofkau.email.utils;

import org.sofkau.email.models.Email;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmailUtils {
    /**
     * Return a Flux from a list of 33 emails.
     * 11 with domain @hotmail, @gmail and @outlook.
     *
     * @return Flux Email
     */
    public static Flux<Email> getEmails(){
        List<Email> emails= new ArrayList<>();

        for(int i = 0; i <=10; i++){
            emails.add(new Email("test"+i+"@hotmail.com"));
            emails.add(new Email("test"+i+"@gmail.com"));
            emails.add(new Email("test"+i+"@outlook.com"));
        }

        return Flux.fromIterable(emails);
    }

    /**
     * Return  a Flux with repeated elements from a HashSet o 9 elements.
     * @return Flux email
     */
    public static Flux<Email> getEmailsWithDuplicates(){
        Set<Email> emails= new HashSet<>();

        for(int i = 0; i <=2; i++){
            emails.add(new Email("test@hotmail.com"));
            emails.add(new Email("test@gmail.com"));
            emails.add(new Email("test@outlook.com"));
        }

        return Flux.fromIterable(emails);
    }
}
