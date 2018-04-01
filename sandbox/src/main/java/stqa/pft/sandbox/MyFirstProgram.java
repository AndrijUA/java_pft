package stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Andrij");

    Squery s = new Squery(5);
    System.out.println("Kwadrat ze stroną " + s.l + " ma pole = " + s.area());


    Rectangle r = new Rectangle(4, 6);
    System.out.println("Prostokąt ze stronami " + r.a + " i " + r.b + " ma pole = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}