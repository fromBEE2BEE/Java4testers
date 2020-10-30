package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;
import org.testng.Assert;

public class SquareTests {

  @Test

 public void testArea() {
 Square s = new Square(5);
 assert s.area() == 25.0;

  }

  //@Test

  //public void testArea() {
    //Square s = new Square(5);
    //Assert.assertEquals(s.area(), 25.0);

  //}




  //@Test

  //public void testArea() {
    //Square s = new Square(5);
    //Assert.assertEquals(s.area(), 24.0);

  //}



  //@Test
  //public void testArea() {
    //Square s = new Square(5);
    //Assert.assertNotEquals(s.area(), 25.0);

  //}
}


