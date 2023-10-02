package LLD.DesignPattern.Prototype;

public class Batch {
    private int batchId;
    private String batchName;
    private String batchInstructor;

    private Batch(Builder builder){
        this.batchId = builder.batchId;
        this.batchName = builder.batchName;
        this.batchInstructor = builder.batchInstructor;
    }

    public int getBatchId() {
        return batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public String getBatchInstructor() {
        return batchInstructor;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int batchId;
        private String batchName;
        private String batchInstructor;

        public int getBatchId() {
            return batchId;
        }

        private Builder(){};

        public Builder setBatchId(int batchId) {
            this.batchId = batchId;
            return this;
        }

        public String getBatchName() {
            return batchName;
        }

        public Builder setBatchName(String batchName) {
            this.batchName = batchName;
            return this;
        }

        public String getBatchInstructor() {
            return batchInstructor;
        }

        public Builder setBatchInstructor(String batchInstructor) {
            this.batchInstructor = batchInstructor;
            return this;
        }

        public boolean validator(){
            if(batchName == "april"){
                return false;
            }
            return true;
        }

        public Batch build() throws Exception {
            if(!validator()){
                throw new Exception("Not validated");
            }
            return new Batch(this);
        }
    }




}
