package LLD.OOPS.inheritance;

public class User {
    private int userId = 6;
    String name;
    int age;
    String gender;

    void changeNameInUser(String name){
        this.name = name;
    }

    //this method is override by student class
    void setNameOverrideByStudent(String name){
        this.name = name;
    }

    void printUserId(){
        System.out.println("Print userId : " + userId);
    }
}
