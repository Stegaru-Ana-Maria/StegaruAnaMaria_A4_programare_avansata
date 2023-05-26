package org.example;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassAnalyzer {

    public static void main(String[] args) {
        // Specify the path to the Calculator.class file
        String classFilePath = "C:/Users/stega/IdeaProjects/Test/target/classes/org/example/Calculator.class";

        // Load and analyze the class
        loadAndAnalyzeClass(classFilePath);
    }

    private static void loadAndAnalyzeClass(String classFilePath) {
        try {

            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new URL("file://" + classFilePath)});


            Class clazz = classLoader.loadClass("org.example.Calculator");


            String packageName = clazz.getPackage().getName();
            Method[] methods = clazz.getDeclaredMethods();


            System.out.println("Class: " + clazz.getCanonicalName());
            System.out.println("Package: " + packageName);

            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println("Name: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType().getSimpleName());
                System.out.println("Modifiers: " + method.getModifiers());
                System.out.println();


                if (method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0 && method.getReturnType().equals(void.class)) {
                    System.out.println("Running test: " + method.getName());
                    method.invoke(null);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
