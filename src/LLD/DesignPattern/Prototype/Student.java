package LLD.DesignPattern.Prototype;

public class Student {
    private String name;
    private Batch batch;
    private double psp;
    private int age;

    public Student(Student student){
        this.name = student.name;
        this.batch = student.batch;
        this.psp = student.psp;
        this.age = student.age;
    }

    public Student(Batch batch){
        this.batch = batch;
    }

    public Student copy(){
        return new Student(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
