package MethodReference.ConstructorReference;

public class Client {
    public static void main(String[] args) {
        GetStudentFI student = Student::new;

        //Constructor reference = className ::  new

        //Generated in different address in heap
        Student s1 = student.getStudent("Himanshu");
        s1.displayName();

        Student s2 = student.getStudent("Harsh");
        s2.displayName();

        Student s3 = student.getStudent("Vijay");
        s3.displayName();

        System.out.println();
    }
}
