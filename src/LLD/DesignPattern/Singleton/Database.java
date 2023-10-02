package LLD.DesignPattern.Singleton;

public class Database {
    private String url;
    private String userName;
    private String password;
    private String role;
    private static Database instance;

    private Database(){};

    //playing with class level no object will create here
    //using double-checking method
    public static Database getInstance(){
        if(instance == null){
            synchronized (Database.class){
                if(instance == null){
                    instance = new Database();
                }
            }
        }
        return instance;
    }

}
