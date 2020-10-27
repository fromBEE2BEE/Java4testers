package ru.stqa.pft.sandbox;
  public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("user");
        hello("Alexei");
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 = new Point();
        Point p2 = new Point();
        System.out.println("Distance between p1 and p2 = "  + distance(p1, p2));
    }
    public static void hello(String somebody) {
      System.out.println("Hello," + somebody + "!");
    }
    public static double distance(Point p1, Point p2) {
      double x1 = 3;
      double x2 = 7;
      double y1 = 3;
      double y2 = 6;
      double a = x2 - x1;
      double b = y2 - y1;
      return Math.sqrt((b) * (b) + (a) * (a));
    }
}