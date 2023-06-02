package org.example;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class JavaClassAnalyzer {

    private static int totalTests = 0;
    private static int passedTests = 0;
    private static int failedTests = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Not enough arguments.");
            return;
        }

        for (String path : args) {
            File file = new File(path);
            exploreFiles(file);
        }

        printStatistics();
    }

    private static void exploreFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    exploreFiles(f);
                }
            }
        } else if (file.isFile() && file.getName().endsWith(".class")) {
            analyzeClassFile(file);
        }
    }

    private static void analyzeClassFile(File file) {
        try {
            String className = file.getName().replace(".class", "");
            String packageName = file.getParent().replace(File.separator, ".");
            Class<?> clazz = Class.forName(packageName + "." + className);

            System.out.println("Class: " + className);
            System.out.println("Package: " + packageName);

            analyzeConstructors(clazz);
            analyzeMethods(clazz);

            System.out.println();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        } catch (Exception e) {
            System.out.println("An error has occurred");
        }
    }

    private static void analyzeConstructors(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println();
    }

    private static void analyzeMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method.getName());
            if (method.isAnnotationPresent(Test.class) && Modifier.isPublic(method.getModifiers())) {
                invokeTestMethod(method);
            }
        }
    }

    private static void invokeTestMethod(Method method) {
        try {
            Object instance = null;
            if (!Modifier.isStatic(method.getModifiers())) {
                instance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
            }

            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] args = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                if (parameterType == int.class || parameterType == Integer.class) {
                    args[i] = 0; // Mock integer value
                } else if (parameterType == String.class) {
                    args[i] = "Mock"; // Mock string value
                } else {
                    args[i] = null; // Mock null value for other parameter types
                }
            }

            method.setAccessible(true);
            Object result = method.invoke(instance, args);
            System.out.println("Test passed. Result: " + result + "\n");
            passedTests++;
        } catch (Exception e) {
            System.out.printf("Test %s failed: %s%n", method, e.getCause());
            failedTests++;
        }
        totalTests++;
    }

    private static void printStatistics() {
        System.out.println("Test Statistics:");
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed Tests: " + passedTests);
        System.out.println("Failed Tests: " + failedTests);
        System.out.println("Passed Tests Percentage: " + calculatePercentage(passedTests) + "%");
        System.out.println("Failed Tests Percentage: " + calculatePercentage(failedTests) + "%");
    }

    private static double calculatePercentage(int value) {
        return (double) value / totalTests * 100;
    }

    @Retention(RetentionPolicy.RUNTIME)
    private @interface Test {
    }
}
