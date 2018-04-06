package stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iwona Zajac on 06.04.2018.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

//    List<String> languages = new ArrayList<String>();
//    languages.add("Java");
//    languages.add("C#");
//    languages.add("Python");
//    languages.add("PHP");


    for (int i = 0; i < langs.length; i++) {
      System.out.println("Chcę się nauczyć " + langs[i]);
    }

    for (String l : langs) {
      System.out.println("Chcę się nauczyć " + l);
    }

    for (String l : languages) {
      System.out.println("Chcę się nauczyć (languages):" + l);
    }

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Chcę język: " + languages.get(i));
    }
  }
}
