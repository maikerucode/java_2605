// SARMIENTO, Michael Joshua P.
// ICS 2605 1CSA
// Lab Exercise 05
//
//
import java.util.*;
import java.lang.Math.*;

public class StackExpression extends Stack {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("SARMIENTO, MICHAEL JOSHUA P.");
    System.out.println("Enter an integer (1 or 2):");
    int t = input.nextInt();
    input.nextLine();
    System.out.println("Enter a postfix expression:");
    String s = input.nextLine();

    if (t == 1) {
      System.out.println("Postfix: " + s);
      System.out.println("Infix: " + postfixToInfix(s));
      System.out.println("Value: " + evalPostfix(s));
    }
    if (t == 2) {
      System.out.println("Infix: " + s);
      String y = infixToPostfix(s);
      System.out.println("Postfix: " + y);
      System.out.println("Value: " + evalPostfix(y));
    }
}

  public static String infixToPostfix(String s) {
    Stack<String> stack = new Stack<String>();
    String[] postfixString = s.split("\\s+");
    String inFixoutString = "";

    for (int i = 0; i < postfixString.length; i++) {
      String a = postfixString[i];

      if (incomingValue(a.charAt(0)) == -1 && a.charAt(0) != ')'){
        inFixoutString += a + " ";
			}
      else {
        if (a.charAt(0) == ')') {
          while (stack.peek().charAt(0) != '('){
            inFixoutString += stack.pop() + " ";
          }
          stack.pop();
        }

        else {
          while (!stack.isEmpty() && compareOper(a.charAt(0), stack.peek().charAt(0))) {
            inFixoutString += stack.pop() + " ";
          }
          stack.push(a);
        }
      }
    }
    while (!stack.isEmpty()) {
      inFixoutString += stack.pop() + " ";
    }
    return inFixoutString;
  }

  public static String postfixToInfix(String e) {
    Stack<String> stack = new Stack<String>();
    String[] postfixString = e.split(" ");

    for (int i = 0; i < postfixString.length; i++) {
      String a = postfixString[i];

      if (a.charAt(0) != '+' && a.charAt(0) != '-' && a.charAt(0) != '*' && a.charAt(0) != '/' && a.charAt(0) != '^' && a.charAt(0) != '%' && a.charAt(0) != '(' && a.charAt(0) != ')') {
        stack.push(postfixString[i]);
      }
      else {
        String c = stack.pop();
        String b = stack.pop();
        stack.push("(" + " "  + b + " " + postfixString[i] + " " + c + " " + ")");
      }
    }
    return stack.pop();
  }

  public static double evalPostfix(String e) {
    Stack<String> stack = new Stack<String>();
    String[] postfixString = e.split(" ");

    for (int i = 0; i < postfixString.length; i++) {
      String a = postfixString[i];

      if (a.charAt(0) != '+' && a.charAt(0) != '-' && a.charAt(0) != '*' && a.charAt(0) != '/' && a.charAt(0) != '^' && a.charAt(0) != '%') {
        stack.push(postfixString[i]);
      }
      else {
        String b = stack.pop();
        String c = stack.pop();

        double first = Double.parseDouble(c);
        double second = Double.parseDouble(b);
        double result = 0;

        switch(a.charAt(0)) {
          case '+':
          result = first + second;
          String output = Double.toString(result);
          stack.push(output);
          break;

          case '-':
          result = first - second;
          output = Double.toString(result);
          stack.push(output);
          break;

          case '*':
          result = first * second;
          output = Double.toString(result);
          stack.push(output);
          break;

          case '/':
          result = first / second;
          output = Double.toString(result);
          stack.push(output);
          break;

          case '^':
          result = Math.pow(first, second);
          output = Double.toString(result);
          stack.push(output);
          break;

          case '%':
          result = first % second;
          output = Double.toString(result);
          stack.push(output);
          break;
        }
      }
    }
    double finaloutput = Double.parseDouble(stack.pop());
    return finaloutput;
  }

  public static boolean compareOper(char a, char b){
		if (incomingValue(a) < inStackValue(b))
			return true;
		else
			return false;
	}
  public static int inStackValue(char a){
		int x;
		switch (a) {
			case '^':
			x = 5;
      break;
			case '/':
			x = 4;
      break;
      case '%':
			x = 3;
      break;
			case '*':
			x = 4;
      break;
			case '+':
			x = 2;
      break;
			case '-':
			x = 2;
      break;
			case '(':
			x = 0;
      break;
			default:
			x = -1;
       break;
		}
		return x;
	}

	public static int incomingValue(char a){
		int x;
		switch (a) {
			case '^':
			x = 6;
      break;
			case '/':
			x = 3;
      break;
      case '%':
			x = 2;
      break;
			case '*':
			x = 3;
      break;
			case '+':
			x = 1;
      break;
			case '-':
			x = 1;
      break;
			case '(':
			x = 9;
      break;
			default:
			x = -1;
       break;
		}
		return x;
	}
}
