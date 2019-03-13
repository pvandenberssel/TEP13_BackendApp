package com.example.TEP13.Backend.Application;

import java.util.Optional;

public class Demo {

    public static void main(String[] args) {


        Optional<Integer> optionalResult = echteDeler(3);

        if(optionalResult.isPresent()) {
            int result = optionalResult.get();
            System.out.println(result);
        }
        else {
            System.out.println("Geen deler gevonden voor 3");
        }

    }

    public static Optional<Integer> echteDeler(int getal) {
        if(getal == 6) {
            return Optional.of(3);
        }

        if(getal == 3) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}
