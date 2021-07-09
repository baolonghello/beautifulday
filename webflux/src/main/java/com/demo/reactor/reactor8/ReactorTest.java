package com.demo.reactor.reactor8;

import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public class ReactorTest {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4).subscribe(System.out::print);
        Mono.just(1).subscribe(System.out::print);
    }
}
