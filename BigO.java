// SARMIENTO, MICHAEL JOSHUA
// ICS 2605 1CSA
// Lab Exercise 03
// This lab exercise was made using Netbeans 12.2
//  Note: print statements to identify the largest n is commented out, used in testing the code.

import java.util.*;

public class BigO {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("SARMIENTO, MICHAEL JOSHUA P.");

    System.out.println("Enter a non-negative integer");
    int maxTime = input.nextInt();
    if (maxTime < 0) {
      maxTime = input.nextInt();
    }

    int n;
    long elapsedTime;
    long startTime;
    long currentTime;
  //  int m1count, m2count, m3count;

    n = 1;
    startTime = System.nanoTime();
    do {
    MultTable(n);
    currentTime = System.nanoTime();
    elapsedTime = ((currentTime - startTime)/1000000000);
    System.out.println();
    n++;
  } while (elapsedTime <= maxTime);
  System.out.println("\nThe elapsed time (in seconds) is: " + elapsedTime);
  // m1count = (n - 1);

    n = 1;
    startTime = System.nanoTime();
    do {
    iterativeFibonacci(n);
    currentTime = System.nanoTime();
    elapsedTime = ((currentTime - startTime)/1000000000);
    System.out.println();
    n++;
  } while (elapsedTime <= maxTime);
  System.out.println("\nThe elapsed time (in seconds) is: " + elapsedTime);
//  m2count = (n - 1);

    n = 1;
    startTime = System.nanoTime();
    do {
    System.out.print(n + ":");
    System.out.print(recursiveFibonnacci(n));
    currentTime = System.nanoTime();
    elapsedTime = ((currentTime - startTime)/1000000000);
    System.out.println();
    n++;
  } while (elapsedTime <= maxTime);
  System.out.println("\nThe elapsed time (in seconds) is: " + (elapsedTime));
//  m3count = (n - 1);
/*
  System.out.println("The number of calls for method 1 is: " + m1count);
  System.out.println("The number of calls for method 2 is: " + m2count);
  System.out.print("The number of calls for method 3 is: " + m3count);
*/

  }

  public static void MultTable(int n) {
    System.out.println(n + ":");
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (j % n == 0) {
            System.out.printf("%-10d\n", i*j);
          }
          else {
            System.out.printf("%-10d", i*j);
          }
        }
      }
    }

  public static void iterativeFibonacci(int n) {
    System.out.print(n + ":");
      if (n <= 1) {
      System.out.print(1);
    }
      int fibo = 1;
      int prevFibo = 1;

      for (int i = 2; i < n; i++) {
        int temp = fibo;
        fibo += prevFibo;
        prevFibo = temp;
      }
    System.out.print(fibo + " ");
    }

  public static int recursiveFibonnacci(int n) {
    if(n <= 1) {
			return n;
		}
		return recursiveFibonnacci(n - 1) + recursiveFibonnacci(n - 2);
  }
}
