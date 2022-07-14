package org.sofkau.email.services;

import org.sofkau.email.models.Email;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Utility class, whit static methods for process Email Flux.
 */
public class EmailService {

    private EmailService(){}
    /**
     *Delete de duplicated elements in a flux o emails.
     * @param flux flux of emails
     * @return Flux emails
     */
    public static Flux<Email> deleteDuplicates(Flux<Email> flux){
        return flux.distinct(Email::getValue);
    }

    /**
     * Method to validate if a flux contains elements with a specific domain.
     * the domain is given by parameters, not include the @.
     * @param flux Flux of emails
     * @param domain String with the domain to validate, do not include @
     * @return Mono<Boolean> true if the flux contains at least an element with the domain.
     */
    public static Mono<Boolean> validateDomain(Flux<Email> flux, String domain){
        return  flux.map(Email::getValue)
                .filter(element -> element.toLowerCase(Locale.ROOT).contains("@"+ domain.toLowerCase(Locale.ROOT)))
                .hasElements();
    }

    /**
     * Validate if all the emails of a Flux has a xxxx@xxxx.com format.
     * Validate the attribute .value.
     * @param flux Flux of emails
     * @return Mono<Boolean> true if all the elements has a valid format.
     */
    public static Mono<Boolean> checkValidEmails(Flux<Email> flux){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return flux
                .map(Email::getValue)
                .map(str -> str.matches(emailRegex))
                .filter(flag -> flag.equals(Boolean.FALSE))
                .hasElements()
                .map(response -> !response);
    }

    /**
     * Count the number of elements of a FLux.
     * return a Mono with a Long Value with the number of Elements.
     * @param flux Flux<Email>
     * @return Mono<Long>
     */
    public static Mono<Long> numberOfEmails(Flux<Email> flux){
        return flux.count();
    }

    /**
     * Method tha count the numbers o emails that has a specific domain.
     * @param flux Flux<Email>
     * @param domain String with the domain to count.
     * @return Mono<Long>
     */
    public static Mono<Long> countByDomain(Flux<Email> flux, String domain){
        return  flux.map(Email::getValue)
                .filter(element -> element.toLowerCase(Locale.ROOT).contains("@"+ domain.toLowerCase(Locale.ROOT)))
                .count();
    }

    /**
     * Validate if each element of a Flux is present y a Set of mails.
     * If is present change the state of isSended to true.
     * @param flux Flux<Email>
     * @return Flux<Email>
     */
    public static Flux<Email> verifySent(Flux<Email> flux){
        Set<String> mailRecipients = new HashSet<>();
        mailRecipients.add("test0@hotmail.com");
        mailRecipients.add("test2@hotmail.com");
        mailRecipients.add("test1@gmail.com");
        mailRecipients.add("test2@gmail.com");

        return flux
                .map(email ->{
                    if(mailRecipients.contains(email.getValue())){
                        return new Email(email.getValue(),Boolean.TRUE);
                    }
                    return new Email(email.getValue());
                });
    }
}
