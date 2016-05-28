package com.wyldkat.expman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public Greet greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greet(name);
    }

    private class Greet {
        String name;

        Greet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

