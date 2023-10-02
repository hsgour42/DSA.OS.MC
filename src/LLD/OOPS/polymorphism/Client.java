package LLD.OOPS.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        User user = new Student();
        user.setName("Himanshu");
        user.setAge(29);

//        System.out.println(user.getName());
        List<Integer> ls = new ArrayList<>();
        List<User> list = List.of(
                new Student(),
                new TA(),
                new Mentor(),
                new User(),
                new Student()
        );



        for(User u : list){
            u.setName("Himanshu");
            System.out.println();
        }


    }
}
