package test.org.cvogt.action
import org.cvogt.constraints._

import org.scalatest._
import org.scalautils.TypeCheckedTripleEquals

class ConstraintsTest extends FunSuite with TypeCheckedTripleEquals{
  test("constraints"){
    trait C
    implicitly[String =:= String]
    implicitly[Int =:= Int]
    implicitly[Unit =:= Unit]
    implicitly[Nothing =:= Nothing]
    implicitly[C =:= C]
    implicitly[Any =:= Any]

    assertTypeError("implicitly[Nothing !=:= Nothing]")

    assertTypeError("implicitly[String =:= Nothing]")

//    conforms_!=:=[String,Nothing]//(allow_!=:=[String,Nothing])

    implicitly[String !=:= Int]
//    implicitly[String !=:= Nothing]
    implicitly[String !=:= C]
    implicitly[String !=:= Unit]
    implicitly[String !=:= Any]

    implicitly[Int !=:= String]
//    implicitly[Int !=:= Nothing]
    implicitly[Int !=:= C]
    implicitly[Int !=:= Unit]
    implicitly[Int !=:= Any]

    implicitly[Unit !=:= String]
    implicitly[Unit !=:= Int]
//    implicitly[Unit !=:= Nothing]
    implicitly[Unit !=:= C]
    implicitly[Unit !=:= Any]
/*
    implicitly[Nothing !=:= String]
    implicitly[Nothing !=:= Int]
    implicitly[Nothing !=:= C]
    implicitly[Nothing !=:= Unit]
    implicitly[Nothing !=:= Any]
*/
    implicitly[C !=:= String]
    implicitly[C !=:= Int]
//    implicitly[C !=:= Nothing]
    implicitly[C !=:= Unit]
    implicitly[C !=:= Any]

    implicitly[Any !=:= String]
    implicitly[Any !=:= Int]
//    implicitly[Any !=:= Nothing]
    implicitly[Any !=:= C]
    implicitly[Any !=:= Unit]
  }
}
