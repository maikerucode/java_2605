// SARMIENTO, Michael Joshua P.
// ICS 2605 1CSA
// Lab Exercise 04
//
//
import java.util.*;
import java.io.*;

public class SearchAndSort {

  static int linearCount = 0, binaryCount = 0, insertionCount = 0, mergeCount = 0;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("SARMIENTO, Michael Joshua P.");

    System.out.println("Enter an integer: ");
    int max = input.nextInt();

    String[] first = new String[max];
    String[] second = new String[max];

    input.nextLine();

    File text = new File("/DSA/ioc2020.txt");
    int index = 0;
     try {
         Scanner scan = new Scanner(text);

         while(scan.hasNextLine() && index < max)
         {
           String k = scan.nextLine();
             first[index] = k;
             second[index] = k;
             index++;
         }
         scan.close();
     } catch (IOException e) {
         System.out.println("Problem with file");
         e.printStackTrace();
     }

    System.out.println("Array 1:");
    for (int i = 0; i < max; i++) {
      System.out.println((i + 1) + ": " + first[i]);
    }
    System.out.println("Array 2:");
    for (int i = 0; i < max; i++) {
      System.out.println((i + 1) + ": " + second[i]);
    }
    System.out.println("Enter a search key: ");
    String key = input.nextLine();

    linearSearch(key, linearCount, first);

    String[] firstSort = mergeSort(first, 0, first.length - 1);
    for (int i = 0; i < firstSort.length; i++) {
      System.out.println((i + 1) + ": " + firstSort[i]);
    }

    System.out.println("Merge Sort Counter Variable: " + mergeCount);

    System.out.println("Enter a search key: ");
    key = input.nextLine();

    int indexBinary = binarySearch(firstSort, 0, first.length - 1, key);
    System.out.println("The index is: " + (indexBinary + 1));
    System.out.println("Binary Search Counter Variable: " + binaryCount);

    String[] secondSort = insertionSort(second, 0, second.length - 1);
    for (int i = 0; i < secondSort.length; i++) {
      System.out.println((i + 1) + ": " + secondSort[i]);
    }

    System.out.println("Insertion Sort Counter Variable: " + insertionCount);

}
  public static void linearSearch(String x, int y, String[] a) {
    int i = a.length;
      while (x.compareTo(a[i - 1]) != 0) {
        linearCount++;
        y++;
        i--;
      }
    System.out.println("The index is: " + i);
    System.out.println("Linear Search Counter Variable: " + y);
    }

  public static String[] mergeSort(String[] a, int start, int end) {
    if (start == end) {
        return a;
    }
    int middle = (start + end) / 2;

    mergeSort(a, start, middle);
    mergeSort(a, middle + 1, end);
    merge(a, start, middle, end);

    return a;
    }

  public static void merge(String[] a, int start, int middle, int end) {
    int n = end - start + 1;
    String[] b = new String[n];
    int i1 = start;
    int i2 = middle + 1;
    int j = 0;


    while (i1 <= middle && i2 <= end) {
        if (a[i1].compareTo(a[i2]) < 0) {
            b[j] = a[i1];
            i1++;
        } else {
            b[j] = a[i2];
            i2++;
        }
        mergeCount++;
        j++;
    }

    while (i1 <= middle) {
        b[j] = a[i1];
        i1++;
        j++;
    }

    while (i2 <= end) {
        b[j] = a[i2];
        i2++;
        j++;
    }

    for (j = 0; j < n; j++) {
        a[start + j] = b[j];
    }
}

  public static int binarySearch(String[] a, int start, int end, String x) {
    int middle = (end + start) / 2;
      if (end >= start) {

            if (x.compareTo(a[middle]) == 0) {
              binaryCount++;
              return middle;
              }

            if (x.compareTo(a[middle]) < 0) {
              binaryCount++;
              return binarySearch(a, start, middle - 1, x);
              }
              else {
              binaryCount++;
            return binarySearch(a, middle + 1, end, x);
          }
      }
      else {
        return -1;
      }
  }

  public static String[] insertionSort(String[] a, int start, int end) {
    for (int i = 1; i <= end; i++) {
      int j = (i - 1);
      String n = a[i];
      while (j >= 0 && a[j].compareTo(n) < n.compareTo(a[j])) {
        insertionCount++;
        a[j + 1] = a[j];
        j -= 1;
      }
      a[j + 1] = n;
    }
    return a;
  }
}
