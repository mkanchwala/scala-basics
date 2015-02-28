package com.mkanchwala

import scala.util.control.Breaks

/**
 * Difference between App and def main()
 * Objects inheriting the App trait instead make use of Scala 2.9’s delayed initialization feature to execute the whole body
 * as part of an inherited main method.
 * Another new feature of the App scheme is that command line arguments are now accessible via the args value
 * (which is inherited from trait App)
 */
object ForL extends App {
  var a = 0;
  var b = 0;
  val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

  // With Range
  for (a <- 1 to 10) {
    println("Value of a: " + a);
  }

  // With Until
  for (a <- 1 until 10) {
    println("Value of a: " + a);
  }

  // With Multiple Ranges
  for (a <- 1 to 3; b <- 1 to 3) {
    println("Value of a: " + a);
    println("Value of b: " + b);
  }

  // With Collections     
  for (a <- numList) {
    println("Value of a: " + a);
  }

  // With Multiple Filters in Collection     
  for (a <- numList if a != 3; if a < 8) {
    println("Value of a: " + a);
  }

  // With Yield     
  var retVal = for {
    a <- numList
    if a != 3; if a < 8
  } yield a
  // Now print returned values using another loop.       
  for (a <- retVal) {
    println("Value of a: " + a);
  }

  // With Breaks
  val loop = new Breaks;
  loop.breakable {
    for (a <- numList) {
      println("Value of a: " + a);
      if (a == 4) {
        loop.break;
      }
    }
  }
  println("After the loop");
}