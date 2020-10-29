package ru.stqa.pft.sandbox;

  public class Point{
   public double x, y;

    public Point(double x1, double y1){
      this.x = x1;
      this.y = y1;
    }
    //public double distance(Point p1, Point p2){
     //double dx = p1.x - p2.x;
     //double dy = p1.y - p2.y;
     //return Math.sqrt(dx * dx + dy * dy);
    //}
    public double distance(Point p2){
        return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }
  }
