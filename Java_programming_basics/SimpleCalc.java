import java.util.Scanner;

public class SimpleCalc {
  private static Scanner scanner = new Scanner(System.in);
    
  private static String option;
  private static String params;
  private static Float result;

  private static void showWelcomeMessages() {
    result = 0f;
    System.out.println("\n---------------------------------------------");
    System.out.println("  Welcome to larrystone's simple calculator  ");
    System.out.println("---------------------------------------------");
    System.out.println("Press 'A' for Addition, 'S' for subtraction, 'M' for multiplication, 'D' for Division");
    System.out.println("Press 'X' to exit\n");
    
    option = scanner.next();
  }

  private static void doAddition(String params) {
    String[] numbers = params.split(",");

    for (int i = 0; i < numbers.length; i++) {
      result += Float.parseFloat(numbers[i]);
    }
    
    System.out.println("Result ==> " + result);
  }

  private static void doSubtraction(String params) {
    String[] numbers = params.split(",");

    result = Float.parseFloat(numbers[0]);
    for (int i = 1; i < numbers.length; i++) {
      result -= Float.parseFloat(numbers[i]);
    }
    
    System.out.println("Result ==> " + result);
  }

  private static void doMultiplication(String params) {
    String[] numbers = params.split(",");
    
    result = 1f;
    for (int i = 0; i < numbers.length; i++) {
      result *= Float.parseFloat(numbers[i]);
    }
    
    System.out.println("Result ==> " + result);
  }

  private static void doDivision(String params) {
    String[] numbers = params.split(",");
    
    if (numbers.length != 2) {
      System.out.println("\nSorry... I can only find the quotient of two numbers for now");
      return;
    }
    
    float numerator = Float.parseFloat(numbers[0]);
    float denominator = Float.parseFloat(numbers[1]);
    
    if (denominator == 0f) {
      System.out.println("\nDivision by 0 is impossible");
      return;
    }

    result = numerator / denominator;

    System.out.println("Result ==> " + result);
  }

  private static void checkUserInput(String option) {
    switch(option.toUpperCase()) {
      case "A": {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("  Enter a list of comma separated numbers to add\n");
        params = scanner.next();
        doAddition(params);

        break;
      }
      case "S": {
        System.out.println("--------------------------------------------------------");
        System.out.println("  Enter a list of comma separated numbers to subtract\n");
        params = scanner.next();
        doSubtraction(params);

        break;
      }
      case "M": {
        System.out.println("********************************************************");
        System.out.println("  Enter a list of comma separated numbers to multiply\n");
        params = scanner.next();
        doMultiplication(params);

        break;
      }

      case "D": {
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("  Enter two numbers to divide separated by comma \n");
        params = scanner.next();
        doDivision(params);

        break;
      }
      case "X": {
        return;
      }
      default: {
        System.out.println();
        System.out.println("Invalid entry, please try again or Press 'X' to exit");
        showWelcomeMessages();
      }
    }
  }

  private static boolean doExit() {
    boolean exit = option.compareToIgnoreCase("X") != 0;

    return exit;
  }

  public static void main (String[] args) {
    do {
      showWelcomeMessages();
      checkUserInput(option);
    } while (doExit());
  }
}