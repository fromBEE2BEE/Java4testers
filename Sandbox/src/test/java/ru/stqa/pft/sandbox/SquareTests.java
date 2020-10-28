package ru.stqa.pft.sandbox;

import org.junit.Assert;
import org.junit.Test;

public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertNotEquals(s.area(),25.0);
  }
}
