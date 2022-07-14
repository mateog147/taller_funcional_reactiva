package org.sofkau.email.services;


import org.junit.Test;
import org.sofkau.email.models.Email;
import org.sofkau.email.utils.EmailUtils;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;


public class EmailServiceTest {

    @Test
    public void delete_duplicates_success(){
        Flux<Email> emails = EmailUtils.getEmailsWithDuplicates();
        StepVerifier.create(EmailService.deleteDuplicates(emails))
                .expectNextCount(3)
                .expectComplete()
                .verify();
    }

    @Test
    public void verify_domains_true(){
        Flux<Email> emails = EmailUtils.getEmails();

        StepVerifier.create(EmailService.validateDomain(emails, "hotmail"))
                .expectNext(Boolean.TRUE)
                .thenCancel()
                .verify();

        StepVerifier.create(EmailService.validateDomain(emails, "gmail"))
                .expectNext(Boolean.TRUE)
                .thenCancel()
                .verify();

        StepVerifier.create(EmailService.validateDomain(emails, "outlook"))
                .expectNext(Boolean.TRUE)
                .thenCancel()
                .verify();
    }

    @Test
    public void verify_domains_false(){
        Flux<Email> emails = EmailUtils.getEmails();

        StepVerifier.create(EmailService.validateDomain(emails, "dominionovalido"))
                .expectNext(Boolean.FALSE)
                .thenCancel()
                .verify();
    }

    @Test
    public void validate_email_format_all_ok(){
        Flux<Email> emails = EmailUtils.getEmails();
        StepVerifier.create(EmailService.checkValidEmails(emails))
                .expectNext(Boolean.TRUE)
                .expectComplete()
                .verify();
    }

    @Test
    public void validate_email_format_not_valid(){
        Flux<Email> emails = Flux.fromIterable(Arrays.asList(new Email("test#error.com"), new Email("test@valid.com")));
        StepVerifier.create(EmailService.checkValidEmails(emails))
                .expectNext(Boolean.FALSE)
                .expectComplete()
                .verify();
    }

    @Test
    public void count_emails_success(){
        Flux<Email> emails = EmailUtils.getEmails();
        StepVerifier.create(EmailService.numberOfEmails(emails))
                .expectNext(33L)
                .expectComplete()
                .verify();
    }

    @Test
    public void count_emails_by_domain(){
        Flux<Email> emails = EmailUtils.getEmails();
        StepVerifier.create(EmailService.countByDomain(emails,"hotmail"))
                .expectNext(11L)
                .expectComplete()
                .verify();

        StepVerifier.create(EmailService.countByDomain(emails,"gmail"))
                .expectNext(11L)
                .expectComplete()
                .verify();

        StepVerifier.create(EmailService.countByDomain(emails,"outlook"))
                .expectNext(11L)
                .expectComplete()
                .verify();
    }

    @Test
    public void verify_send_success(){
        Flux<Email> emails = EmailUtils.getEmails();
        StepVerifier.create(EmailService.verifySent(emails))
                .expectNextMatches(email -> email.getSended().equals(Boolean.TRUE))
                .thenCancel()
                .verify();

    }

}