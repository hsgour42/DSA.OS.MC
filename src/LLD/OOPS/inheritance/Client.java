package LLD.OOPS.inheritance;

public class Client {
    public static void main(String[] args){
        TA ta = new TA();
        ta.name ="Naman";

        //accessing name of user class from mentor call object
        Mentor mentor = new Mentor();
        mentor.name="Ayush";



        Student st = new Student();
        //only update the name of student class not change in user class
        st.name = "Himanshu";
        st.psp = 88.8;
        st.batch = "April 22";

        //System.out.println(st.batch);
        // st.batchPaused();
        //System.out.println(st.batch);

        //changing the name of user class only using method of user class
        st.changeNameInUser("Sudhanshu");

        //if both student and user have same method then method are override by child class and run only chlid method
        //else if no same method available in child class then parent method is printed or run
        st.printUserId();

        //set the name of student only because this method is orderide
        st.setNameOverrideByStudent("Vijay");

        System.out.println();

    }
}
