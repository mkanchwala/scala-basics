package com.mkanchwala

import java.util.Date

object Functs extends App {

  //Normal Functions
  println("Returned Value : " + addInt(5, 7));
  def addInt(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum = a + b
    sum
  }

  //Functions Call By Name
  delayed(time());
  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }
  def delayed(t: => Long) = {
    println("In delayed method")
    println("Param: " + t)
    t
  }

  // Functions with Named Parameters
  printInt(b = 5, a = 7);
  def printInt(a: Int, b: Int) = {
    println("Value of a : " + a);
    println("Value of b : " + b);
  }

  // Functions with Variable Parameters
  printStrings("Hello", "Scala", "Python");
  def printStrings(args: String*) = {
    var i: Int = 0;
    for (arg <- args) {
      println("Arg value[" + i + "] = " + arg);
      i = i + 1;
    }
  }

  //Recursions
  for (i <- 1 to 10)
    println("Factorial of " + i + ": = " + factorial(i))

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }

  //Default Parameter Values 
  println("Returned Value : " + addInt2());
  def addInt2(a: Int = 5, b: Int = 7): Int = {
    var sum: Int = 0
    sum = a + b
    sum
  }

  //Higher-Order Functions
  //These are functions that take other functions as parameters, or whose result is a function. 
  //For example in the following code, apply() function takes another function f and a value v and applies function f to v
  println(apply(layout, 10))
  def apply(f: Int => String, v: Int) = f(v)
  def layout[A](x: A) = "[" + x.toString() + "]"

  //Nested Functions 
  println(factorial(0))
  println(factorial(1))
  println(factorial(2))
  println(factorial(3))
  def factorial(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }

  //Anonymous Functions
  var inc = (x: Int) => x + 1
  println(inc(7) - 1)

  //Partially Applied Functions
  val date = new Date
  //instead of normal calling
  logWithDateBound("message1")       
  logWithDateBound("message2")       
  logWithDateBound("message3")
  val logWithDateBound = log(new Date, _ : String) 
  def log(date: Date, message: String) = {
    println(date + "----" + message)
  }

  //Currying Functions 
  val str1: String = "Hello, "
  val str2: String = "Scala!"
  println("str1 + str2 = " + strcat(str1)(str2))
  def strcat(s1: String)(s2: String) = {
    s1 + s2
  }
}