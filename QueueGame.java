// SARMIENTO, Michael Joshua P.
// ICS 2605 1CSA
// Lab Exercise 07
//
//
import java.util.*;

public class QueueGame {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("SARMIENTO, MICHAEL JOSHUA P.");

    System.out.println("Enter an integer: ");
    int s = input.nextInt();
    System.out.println("Enter an integer: ");
    int n = input.nextInt();

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String output = "";
    Queue<Character> queue = new Queue<Character>(n);

    System.out.print("children: ");
    for (int i = 0; i < n; i++) {
      queue.enqueue(alphabet.charAt(i));
      System.out.print(alphabet.charAt(i) + " ");
    }

    System.out.println();


      for (int i = n; i > 0; i--) {
        for (int j = s; j > 1; j--) {
            queue.enqueue(queue.dequeue());
          }
          output += queue.dequeue() + " ";
        }

      System.out.println("elimination order: " + output);
      }
    }
