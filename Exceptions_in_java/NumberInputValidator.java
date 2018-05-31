import java.util.Scanner;

public class NumberInputValidator {
  private static String input = "";
  private static Scanner scanner = new Scanner(System.in);

  private static void validate(String input) {
    try {
      float result = Float.parseFloat(input);
      System.out.println("\nYou entered a valid Number ==> " + result);
    } catch(Exception e) {
      System.out.println("\nERROR: We told you to enter a Number, but you entered an invalid input!!!");
    } finally {
      System.out.println();
    }
  }

  private static void printInstruction() {
    System.out.println("\nWelcome to our Number Input validator");
    System.out.println("Please enter a number. Decimal fractions are allowed");
    System.out.println("Enter 'Q' to exit this program\n");
    input = scanner.next();
  }

  public static void main (String[] args) {
    while(input.compareToIgnoreCase("Q") != 0) {
      printInstruction();
      validate(input);    
    }
  }
}