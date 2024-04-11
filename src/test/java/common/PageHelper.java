package common;

import java.lang.annotation.Annotation;

import keywords.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.internal.TestNGMethod;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import Page.RegisterPage;
import TCs.RegisterTCs;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.testng.ITestClass;
import org.testng.ITestNGMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestNGMethod;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Page.RegisterPage;

public class PageHelper {
//    @Test
//    public void testLocator() {
//        RegisterPage registerPage = new RegisterPage();
//        registerPage.
//
//        By by = By.xpath("//input[@placeholder='First Name']");
//
//        WebElement ele = DriverManager.getDriver().findElement(by);
//        ele.click();
//        Assert.assertTrue(ele.isDisplayed() && ele.isEnabled(), "Not Display n Enabled");
//    }


    public void printmethod() {
        Class<RegisterPage> myClass = RegisterPage.class;
        Method[] methods = myClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

//    @Test
//    public void print() {
//        Class<RegisterTCs> testClass = RegisterTCs.class;
//
//        // Get all test methods within the test class
//        ITestClass iTestClass = new TestNGMethod(testClass);
//        ITestNGMethod[] allMethods = iTestClass.getTestMethods();
//
//        // Set to store methods in the group
//        Set<Method> groupMethods = new HashSet<>();
//
//        // Iterate over all methods and filter based on group
//        for (ITestNGMethod method : allMethods) {
//            String[] groups = method.getGroups();
//            for (String group : groups) {
//                if (group.equals("myGroup")) {
//                    Method javaMethod = method.getConstructorOrMethod().getMethod();
//                    groupMethods.add(javaMethod);
//                }
//            }
//        }
//
//        // Print the methods in the group
//        for (Method method : groupMethods) {
//            System.out.println(method.getName());
//        }
//
//
//        @Test
//        public void printGroup () {
//            Class<RegisterTCs> myClass = RegisterTCs.class;
//            String myGroup = "Firstname";
//            // Provide the class containing the methods
//
//            // Retrieve the methods in the specified group
//            List<Method> groupMethods = getMethodsInGroup(myClass, myGroup);
//
//            // Print the methods in the group
//            for (Method method : groupMethods) {
//                System.out.println(method.getName());
//            }
//        }
//
//        private List<Method> getMethodsInGroup (Class < ? > clazz, String groupName){
//            List<Method> groupMethods = new ArrayList<>();
//
//            // Get all methods declared in the class
//            Method[] methods = clazz.getDeclaredMethods();
//
//            // Iterate over the methods
//            for (Method method : methods) {
//                // Check if the method has the specified group annotation
//                if (isMethodInGroup(method, groupName)) {
//                    groupMethods.add(method);
//                }
//            }
//
//            return groupMethods;
//        }
//
//        private boolean isMethodInGroup (Method method, String groupName){
//            // Get the annotations on the method
//            Annotation[] annotations = method.getDeclaredAnnotations();
//
//            // Iterate over the annotations
//            for (Annotation annotation : annotations) {
//                // Check if the annotation has the specified group name
//                if (annotation instanceof Group && ((Group) annotation).getName().equals(groupName)) {
//                    return true;
//                }
//            }
//
//            return false;
//        }
//    }
}