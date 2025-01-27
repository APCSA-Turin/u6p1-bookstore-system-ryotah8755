package com.example.project;
public class Tester { 
    public static void main(String[] args) {
        IdGenerate.reset();
       
        IdGenerate.generateID(); //100
        IdGenerate.generateID(); //101
        IdGenerate.generateID(); //102
        IdGenerate.generateID(); //103
        IdGenerate.getCurrentId();
    }
}
