package org.sofkau.chat;

import junit.framework.TestCase;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class ChatTest{

    @Test
    public void replace_bad_word(){
        Chat chat = Chat.getChat();
        String testInput = "puta and maricon are bad words";
        List<String> testList = Arrays.asList(testInput.split(" "));
        Flux<String> flux = Flux.fromIterable(testList);

        StepVerifier.create(chat.replaceBadWords(flux))
                .expectNext("****")
                .expectNext("and")
                .expectNext("****")
                .thenCancel()
                .verify();
    }

}