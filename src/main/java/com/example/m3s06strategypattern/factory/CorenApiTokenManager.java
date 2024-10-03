package com.example.m3s06strategypattern.factory;

import org.springframework.stereotype.Component;

@Component
public class CorenApiTokenManager {
    public String getTemporaryToken() {
        return "Token 123";
    }
}
