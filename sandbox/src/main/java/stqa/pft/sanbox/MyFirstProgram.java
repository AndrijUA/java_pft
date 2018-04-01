package stqa.pft.sanbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Andrij");

    Squery s = new Squery(5);
    System.out.println("Kwadrat ze stroną " + s.l + " ma pole = " + area(s));


    Rectangle r = new Rectangle(4,6);
    System.out.println("Prostokąt ze stronami " + r.a + " i " + r.b + " ma pole = " + area(r));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Squery s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }
}