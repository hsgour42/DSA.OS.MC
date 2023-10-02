package LLD.DesignPattern.Singleton;

public class Client {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        Database db3 = Database.getInstance();

        System.out.println();
    }
}
