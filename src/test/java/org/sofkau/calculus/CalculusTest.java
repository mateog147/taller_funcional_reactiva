package org.sofkau.calculus;

import junit.framework.TestCase;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class CalculusTest {

        @Test
        public void derivatives_success(){
            Calculus cal = Calculus.getCalculus();
            Flux<String> flux = Flux.just("sen(x)","cos(x)","tan(x)");
            StepVerifier.create(cal.derivatives(flux))
                    .expectNext("cos(x)")
                    .expectNext("(-sen(x))")
                    .expectNext("sec2(x)")
                    .expectComplete()
                    .verify();
        }

    @Test
    public void integrals_success(){
        Calculus cal = Calculus.getCalculus();
        Flux<String> flux = Flux.just("sen(x)","cos(x)");
        StepVerifier.create(cal.integrals(flux))
                .expectNext("(-cos(x))")
                .expectNext("sen(x)")
                .expectComplete()
                .verify();
    }

}