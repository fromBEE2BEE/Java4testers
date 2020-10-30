package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;



public class PointTests {
  @Test

  public void testDistance() {

     Point p1 = new Point(3,3);
     Point p2 = new Point(7.0, 6.0);
     Assert.assertEquals((p1.distance(p2)), 5);

  }

  //public void testDistance() {

    //Point p1 = new Point(3,3);
    //Point p2 = new Point(7.0, 6.0);
    //Assert.assertEquals((p1.distance(p2)), 4);

  //}



  //public void testDistance() {

    //Point p1 = new Point(3,3);
    //Point p2 = new Point(7.0, 6.0);
    //assert p1.distance(p2) == 5;

  //}

}
