package by.dfr0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class testedClass = TestedClass.class;
        GoTest.start(testedClass);
    }

    static class GoTest {
        public static void start(Class<?> testedClass) {
            Object goObject = new TestedClass();
            Method[] l_methods = testedClass.getDeclaredMethods();
            int count = 0;
            for (Method method : l_methods) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    try {
                        if (count >= 1) {
                            throw new RuntimeException("Аннотаций @BeforeSuite больше одной");
                        }
                        method.invoke(goObject);
                        count += 1;
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

            for (Method method : l_methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    String methods = method.getClass().getSimpleName();
                    if (method.getAnnotation(Test.class).i() > 0) {
                        System.out.println(methods + "\t" + method.getAnnotation(Test.class).i());
                        try {
                            method.invoke(goObject);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            count = 0;
            for (Method method : l_methods) {
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    try {
                        if (count >= 1) {
                            throw new RuntimeException("Аннотаций @AfterSuite больше одной");
                        }
                        method.invoke(goObject);
                        count += 1;
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

