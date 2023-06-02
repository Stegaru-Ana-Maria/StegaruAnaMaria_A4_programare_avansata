package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Lab12 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Not enough arguments.");
            return;
        }

        for (String filePath : args) {
            try {
                Class clazz = Class.forName(filePath);

                String className = clazz.getName();
                Package classPackage = clazz.getPackage();
                String packageName = (classPackage != null) ? classPackage.getName() : "(default package)";

                System.out.println("Class: " + className);
                System.out.println("Package: " + packageName);

                Constructor[] constructors = clazz.getDeclaredConstructors();
                System.out.println("Constructors:");
                for (Constructor constructor : constructors) {
                    System.out.println(constructor.getName());
                }
                System.out.println();

                Method[] methods = clazz.getDeclaredMethods();
                System.out.println("Methods:");
                for (Method method : methods) {
                    System.out.println(method.getName());
                    if (method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0) {
                        try {
                            method.invoke(null);
                            System.out.println("Test passed.\n");
                        } catch (Exception e) {
                            System.out.printf("Test %s failed: %s %n", method, e.getCause());
                        }
                    }
                }

                System.out.println();

            } catch (ClassNotFoundException e) {
                System.out.println("Class not found.");
            } catch (Exception e) {
                System.out.println("An error has occurred");
            }
        }
    }
}
