package com.example.demo;

import org.springframework.stereotype.Component;


public class MyComponent {
    public MyComponent() {
        System.out.println("Result for My Component");
        System.out.println(add(5,10));
    }
    public int add(int no1, int no2){
        return no1+no2;
    }
    public void getMessage()
    {
        System.out.println("Result for My Component");
        System.out.println(add(5,10));
    }
}
