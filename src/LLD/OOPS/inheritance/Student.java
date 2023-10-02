package LLD.OOPS.inheritance;

public class Student extends User{
    int userId = 4;
    String name;
    String batch;
    double psp;

    void batchPaused(){
         System.out.println(name + " is paused the Batch");
        batch = null;
    }

    @Override
    public void setNameOverrideByStudent(String name) {
        this.name = name;
    }

    //    void printUserId(){
//        System.out.println("userId : " + userId);
//    }



}
