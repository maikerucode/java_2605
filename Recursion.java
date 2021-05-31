// SARMIENTO, Michael Joshua P.
// ICS 2605 1CSA
// Lab Exercise 02
//
//
import java.util.*;
import java.io.*;

public class Recursion {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("SARMIENTO, MICHAEL JOSHUA P.");

    System.out.println("Enter your choice:(Choice of 1 or 2)");
    int t = Integer.parseInt(input.nextLine());

    System.out.println("Enter your sequence of strings: ");
    String s = input.nextLine();

    String[] testArray = s.split(" ");
    int arraycount = testArray.length;

    if (t == 1) {
      for (int i = 0; i < testArray.length; i++) {
        System.out.println(testArray[i]);
      }
      System.out.println("The reversal is: ");
      testArray = reverse(testArray, 0, (testArray.length - 1));
      for (int i = 0; i < testArray.length; i++) {
        System.out.println(testArray[i]);
      }
    }

    if (t == 2) {
      for (int i = 0; i < testArray.length; i++) {
        System.out.println(testArray[i]);
      }
        if (isPalindrome(testArray, 0, (testArray.length - 1))) {
          System.out.println("is a palindrome");
        }
        else {
          System.out.println("is not a palindrome");
      }
    }
  }

  public static String[] reverse(String[] a, int start, int end) {
    if (start < end) {
      String temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      reverse(a, start + 1, end - 1);
    }
    return a;
  }

  public static boolean isPalindrome(String[] a, int start, int end) {
    if (start < end) {
      if (a[start].compareTo(a[end]) != 0) {
        return false;
        }
      }
      else if (a[start].compareTo(a[end]) == 0) {
        isPalindrome(a, start + 1, end - 1);
    }
    return true;
  }
}
