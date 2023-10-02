package LLD.DesignPattern.Builder;

public class Student {
    private int id;
    private String name;
    private String gender;
    private double psp;

    //Make constructor private
    //No Setter
    private Student(StudentBuilder studentBuilder){
        this.id  = studentBuilder.id;
        this.name = studentBuilder.name;
        this.gender = studentBuilder.gender;
        this.psp = studentBuilder.psp;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getPsp() {
        return psp;
    }

    public static class StudentBuilder{
        private int id;
        private String name;
        private String gender;
        private double psp;

        private StudentBuilder(){};

        public int getId() {
            return id;
        }

        //method chaining
        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }
        //method chaining
        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getGender() {
            return gender;
        }
        //method chaining
        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public double getPsp() {
            return psp;
        }
        //method chaining
        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        private boolean validate() throws Exception{
            if(psp < 20){
                return false;
            }
            return true;
        }

        public Student build() throws Exception {
            if(!validate()){
                throw new Exception("Psp is so low");
            }
            return new Student(this);
        }
    }




}
