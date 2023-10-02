package LLD.DesignPattern.Builder;

import java.util.Locale;

public class Client {
    public static void main(String[] args) throws Exception {
         Student himanshu = Student.builder()
                 .setId(1)
                 .setName("Himanshu")
                 .setGender("Male")
                 .setPsp(50.2)
                 .build();

        Student harsh = Student.builder()
                .setId(2)
                .setName("harsh")
                .setGender("Male")
                .setPsp(90.2)
                .build();

        System.out.println();




    }
}
