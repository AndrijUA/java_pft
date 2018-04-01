package stqa.pft.sanbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Andrij");

    double l = 5;
    System.out.println("Kwadrat ze stroną " + l + " ma pole = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Prostokąt ze stronami " + a + " i " + b + " ma pole = " + area(a, b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double len) {
    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}