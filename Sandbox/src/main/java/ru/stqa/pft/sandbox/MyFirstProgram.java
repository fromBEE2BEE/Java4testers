package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Point p1 = new Point(3,3);
        Point p2 = new Point(7.0, 6.0);
        //System.out.println("The dictance from Point p1 to Point p2 is " + p1.distance(p1, p2) + ".");
        System.out.println("The dictance from Point p1 to Point p2 is " + p1.distance(p2));
        }

}
