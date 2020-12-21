package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {

    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";

    //String[] langs = {"Java", "C#", "Python", "PHP"};
    //Эта запись эквивалентна предыдущей.

    //for (int i = 0; i < langs.length; i++) {
    //  System.out.println("Я хочу выучить " + langs[i]);

//////////////////////////////////////////////////////////////////

    //for (String l : langs) {
    //  System.out.println("Я хочу выучить " + l);
     //Это особая конструкция цикла, предназначенная для перебора
      // элементов коллекций, l уже не индекс, а ссылка
      //непосредственно на элемент массива. Последовательно
      // указывает на все элементы этой коллекции. Искусственная
      //переменная-счетчик не создается,она не нужна.

//////////////////////////////////////////////////////////////////

     // List<String> languages = new ArrayList<String>();
     // languages.add("Java");
      //languages.add("C#");
     // languages.add("Python");
     // languages.add("PHP");

     // for (String l : languages) {
        //System.out.println("Я хочу выучить " + l);
///////////////////////////////////////////////////////////////////

      //List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

      //for (String l : languages) {
      //System.out.println("Я хочу выучить " + l);
//Самая удобная конструкция цикла, которая пробегает по элементам массива
///////////////////////////////////////////////////////////////////
        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (int i = 0; i < languages.size(); i++) {
          System.out.println("Я хочу выучить " + languages.get(i));
 //Итерации по элементам списка с помощью вспомогательной переменной-счетчика
 ///////////////////////////////////////////////////////////////////////
 //Список элементов произвольного типа:
          //List languages = Arrays.asList("Java", "C#", "Python", "PHP");

          //for (Object l : languages) {
            //System.out.println("Я хочу выучить " + l);
 //Менее удобно, лучше всего работать с элементами конкретных типов.

    }
  }
}
