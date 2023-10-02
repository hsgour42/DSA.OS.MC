package LLD.DesignPattern.Prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    Map<String ,Student> map = new HashMap<>();

    public void addStudent(String name , Student student){
        map.put(name , student);
    }

    public Student getStudent(String name){
        return map.get(name);
    }
}
