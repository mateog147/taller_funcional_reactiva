package org.sofkau.chat;

import org.sofkau.email.models.Email;
import org.sofkau.email.services.EmailService;
import org.sofkau.email.utils.EmailUtils;
import reactor.core.publisher.Flux;

import java.util.*;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger("logger");

        Chat chat = Chat.getChat();

        while (Boolean.TRUE){
            logger.info("Bienvenido ingrese su mensaje [s para salir]");
            String input = scanner.nextLine();

            if(input.toLowerCase(Locale.ROOT).equals("s")){
                break;
            }

            Flux<String> flux = Flux.fromIterable(Arrays.asList(input.split(" ")));

            String response = chat.replaceBadWords(flux)
                    .reduce((a, w) -> a + " " + w)
                    .onErrorReturn("Error")
                    .block().toString();

            logger.info(response);

        }
    }
}
