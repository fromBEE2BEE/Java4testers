package ru.stqa.pft.sandbox;

public class Equality {
  public static void main(String[] args) {
    // Ситуация 1.
    //String s1 = "firefox";
    //String s2 = s1; - ссылается на старый объект
    // все равны
    //System.out.println(s1 == s2);
    //System.out.println(s1.equals(s2));
   ///////////////////////////////////////////////////////
    // Ситуация 2.
    // результат: не равны:
    // String s1 = "firefox";
    //результат: равны. Ссылается на новый объект,который физически другой и ссылается на другой адрес:
    // String s2 = new String (s1);
    // ==  - это проверка,что обе переменные ссылаются на один и тот же объект
    // System.out.println(s1 == s2);
    // System.out.println(s1.equals(s2));
// метод equals сравнивает не ссылки, а содержимое объекта(логическое сравнение)
  ////////////////////////////////////////////////////////
  //Ситуация 3.
    String s1 = "firefox";
    String s2 = "firefox";
    // или String s2 = "fire" + "fox"; - компилятор догадается,что объект один и тот же


    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));


  }
}
