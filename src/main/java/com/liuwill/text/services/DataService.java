package com.liuwill.text.services;

import org.springframework.stereotype.Service;

@Service("dataService")
public class DataService {
    public String sayHello(String someone){
        return "hello "+someone;
    }
}
