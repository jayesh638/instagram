package com.example.instagram.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InstaFunctions {

    public String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
