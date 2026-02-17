package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApp {
    private MyComponent component;

    @Autowired
    public MyApp(MyComponent component) {
        this.component = component;
    }
    public void run()
    {
        component.getMessage();
    }
}
