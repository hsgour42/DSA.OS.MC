package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        String s1 ="Hello";
        System.out.println(s1);

        Class BaClass = Class.forName("Reflection.BA");

        System.out.println(BaClass.getName());
        System.out.println(BaClass.getDeclaredMethods().length);
        System.out.println(BaClass.getDeclaredFields().length);

        Method[] methods = BaClass.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        Field[] fields = BaClass.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
    }

}
