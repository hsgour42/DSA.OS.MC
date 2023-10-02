package LLD.OOPS.accessmodifiers.differentfolder;

import LLD.OOPS.accessmodifiers.samefolder.Student;

public class ChildDiffFolder extends Student {
    public static void  main(String[] args){
        ChildDiffFolder student = new ChildDiffFolder();
        student.batch  = "April 22";
        student.parent = "Rekha Singh";
    }

}
