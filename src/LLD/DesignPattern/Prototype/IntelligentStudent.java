package LLD.DesignPattern.Prototype;

public class IntelligentStudent extends Student{

    private int iq;

    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }
    public IntelligentStudent(Batch batch){
        super(batch);
    }

    @Override
    public IntelligentStudent copy() {
        return new IntelligentStudent(this);
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
