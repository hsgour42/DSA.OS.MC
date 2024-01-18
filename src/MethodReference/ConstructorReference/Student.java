package MethodReference.ConstructorReference;

import java.util.Stack;

public class Student {
    private final String name;
    public Student(String name) {
        System.out.println("Student constructor call");
        this.name = name;
    }

    public void displayName(){
        System.out.println("Display name call with name : " + name);
    }

}
