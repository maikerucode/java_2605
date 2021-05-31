// SARMIENTO, MICHAEL JOSHUA
// ICS 2605 1CSA
// Lab Exercise 01
// This lab exercise was made using Netbeans 12.2
//

import java.util.*;

public class MultTable {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String intline = "";

    System.out.println("Sarmiento, Michael Joshua P.");
    System.out.print("How many numbers do you want to multiply?: ");
    int count = input.nextInt();
    int[] table = new int[count];

    System.out.print("Please enter an integer: ");
    int num = input.nextInt();
    if (num <= 0) {
      System.out.print("Please enter a positive integer: ");
    num = input.nextInt();
    }
    table[0] = num;
    System.out.println(num);
    intline = "\t" + num;

    for (int i = 1; i < table.length; i++) {
      System.out.print("Please enter an integer: ");
      num = input.nextInt();

      if (num <= 0) {
        System.out.print("Please enter a positive integer: ");
        num = input.nextInt();
      }

      table[i] = num;
      if (i == table.length) {
        System.out.println("\n");
      }
      intline = intline.concat(" \t" + num);
      System.out.println(intline);
    }
    long start = System.nanoTime();
    System.out.print(multiples(table));
    long end = System.nanoTime();

    long elapsed = ((end - start) / 1000000);
    System.out.println();
    System.out.println("The elapsed time (in milliseconds) is: " + elapsed);

  }

  public static String multiples(int[] x) {
    String tableline = "";
      for (int i = 0; i < x.length; i++) {
        tableline = tableline.concat("\n" + x[i] + ":\t");
        for (int j = 0; j < x.length; j++) {
          tableline = tableline.concat((x[i] * x[j]) + " \t");
        }
      }
      // System.out.print("\n");
      return tableline;
    }
  }
