package LLD.DesignPattern.Prototype;

public class Client {
    public static void main(String[] args) throws Exception {

        Batch aprilBatch  = Batch.builder()
                .setBatchId(1)
                .setBatchName("april 2022")
                .setBatchInstructor("Naman")
                .build();

        Batch mayBatch  = Batch.builder()
                .setBatchId(1)
                .setBatchName("may 2022")
                .setBatchInstructor("Omansh")
                .build();



        StudentRegistry studentRegistry = new StudentRegistry();
        studentRegistry.addStudent( "april",new Student(aprilBatch));
        studentRegistry.addStudent( "april",new Student(aprilBatch));
        studentRegistry.addStudent( "may",new IntelligentStudent(mayBatch));

        Student himanshu = studentRegistry.getStudent("april").copy();
        himanshu.setName("Himanshu");

        Student harsh = studentRegistry.getStudent("april").copy();
        harsh.setName("harsh");

        Student vijay = studentRegistry.getStudent("may").copy();
        vijay.setName("vijay");

        System.out.println(vijay.getBatch().getBatchInstructor());


    }
}
