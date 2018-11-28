package testframework;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class RunTest {

    public static void invokeAMethod(Object instance, String[] args)
    {
        // Method method = instance.getClass().getMethod(args[1], ? );
        // Non terminé...
    }

    public static void instantiateClass(Class aClass, String[] args)
    {
        Object instance = null;
        try{
            instance = aClass.newInstance();
            System.out.println("Instantiation : OK");
            invokeAMethod(instance, args);
        }
        catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Instantiation KO : " );
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        if(args.length < 1){return;}
        String className = args[0];
        try{
            Class aClass = Class.forName(className);
            System.out.println(aClass.getName() + " has the following methods :");
            for(Method method : aClass.getDeclaredMethods() )
            {
                System.out.print(" - " + method.getReturnType() + " "+ method.getName() + "(");
                for(Parameter parameter : method.getParameters()){
                    System.out.print(parameter.getType().getName() + " ," );
                }
                System.out.println(")");
            }
            System.out.println("Now trying to instantiate...");
            instantiateClass(aClass, args);
        }
        catch(ClassNotFoundException e){
            System.out.println(className + " not found ! Are you sure of typing correctly the name ?");
        }
        System.out.println("Press enter to exit.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
