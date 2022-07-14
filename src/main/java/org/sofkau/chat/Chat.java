package org.sofkau.chat;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Class that manage an input of string in a chat.
 */
public class Chat {
    private static final Chat chat = new Chat();
    private  Set<String> badWords;

    private Chat(){
        this.badWords  = new HashSet<>();
        this.badWords.addAll(Arrays.asList("puta", "maricon", "hijo de puta", "malparido", "mierda"));
    }

    /**
     * Return an instance of chat.
     * @return Chat
     */
    public static Chat getChat(){
        return chat;
    }

    /**
     * Replace the bad words with '****'.
     * The bad words are in a list.
     *
     * @param flux FLux<String>
     * @return FLux<String>
     */
    public Flux<String> replaceBadWords(Flux<String> flux){
        return flux.map(word ->{
            if(isBadWord(word.toLowerCase(Locale.ROOT))){
                return "****";
            }
            return word;
        });
    }

    private boolean isBadWord(String word) {
        boolean contains;
        contains = this.badWords.contains(word);
        return contains;
    }
}
