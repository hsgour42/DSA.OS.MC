package Scalar_OS.Synchronization.Object;

public class Count {
     public int value;
     public Count(int value){
         this.value = value;
     }

     synchronized public void adder(int val){
         this.value += val;
     }

    synchronized public void subtractor(int val){
        this.value -= val;
    }
}
