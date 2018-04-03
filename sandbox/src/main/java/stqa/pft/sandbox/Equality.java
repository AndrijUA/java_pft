package stqa.pft.sandbox;

/**
 * Created by Iwona Zajac on 03.04.2018.
 */
public class Equality {

  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = s1;

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

    System.out.println("Jako nowy objekt");
    s2 = new String(s1);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

    System.out.println("Jako nowy tekst => tu optymizuje kompilator. Jednakowe znaczenie zmiennych odsyła do tego samego obnośnika");
    s2 = "firefox";

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

    System.out.println("Również");
    s2 = "fire" + "fox";

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

    System.out.println("Tego kompilator nie wylicza");
    s1 = "firefox" + 2.0;
    s2 = "firefox" + Math.sqrt(4.0);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
