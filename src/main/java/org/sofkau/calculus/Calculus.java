package org.sofkau.calculus;

import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

public class Calculus {

    private static Map<String, String> derivatives = new HashMap<>();
    private static Map<String, String> integrals = new HashMap<>();
    private static Calculus calculus = new Calculus();

    public static Calculus getCalculus(){
        return calculus;
    }

    private Calculus(){
        derivatives.put("sen(x)","cos(x)");
        derivatives.put("cos(x)","(-sen(x))");
        derivatives.put("tan(x)","sec2(x)");
        derivatives.put("cot(x)","(-csc2(x))");
        derivatives.put("sec(x)","sec(x)tan(x)");

        integrals.put("sen(x)","(-cos(x))");
        integrals.put("cos(x)","sen(x)");
    }

    public Flux<String> derivatives(Flux<String> flux){
        return flux.map(fun -> derivativeOf(fun));
    }

    public Flux<String> integrals(Flux<String> flux){
        return flux.map(fun -> integralOf(fun));
    }

    private String derivativeOf(String fun) {
        if(derivatives.containsKey(fun)){
            return derivatives.get(fun);
        }
        return "n/a";
    }

    private String integralOf(String fun) {
        if(integrals.containsKey(fun)){
            return integrals.get(fun);
        }
        return "n/a";
    }
}
