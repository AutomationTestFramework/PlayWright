package utils;

import org.junit.Assert;

public class SoftAssert {

    public static void assertEqual(String actual, String expected, String message){
        if (!actual.equals(expected)){
            System.out.println(message);
        }
    }

    public static void assertContains(String actual, String expected, String message){
        if (!actual.contains(expected)){
            System.out.println(message);
        }
    }

    public static void assertTrue(Boolean actual, String message){
        if (!actual){
            System.out.println(message);
        }
    }


}
