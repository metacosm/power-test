package org.acme;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.Duration;
import java.util.Random;

@Path("/app")
public class GreetingResource {
    @GET
    @Path("start")
    public Multi<String> hello() {
        return Multi.createFrom().ticks().every(Duration.ofMillis(500)).map(value -> {
            int randomInt = new Random().nextInt(20);
            return String.format("%s\n", fib(randomInt));
        });
    }

    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
