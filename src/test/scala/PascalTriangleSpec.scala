import org.scalatest._
import org.scalatest.prop.Checkers
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import com.tyler.coursera.PascalTriangle

import org.scalacheck.Prop
import org.scalatest.prop.Checkers._

class PascalTriangleSpec extends FlatSpec with Checkers {
  "Pascal's Triangle" should "have all 1's along the left edge" in {
    assert((0 to 100).forall(PascalTriangle.pos(0, _) == 1))
  }

  it should "have all 1's along the right edge" in {
    assert((0 to 100).forall(x => PascalTriangle.pos(x,x) == 1))
  }

  it should "have all 1's along the left edge according to scalaCheck" in {
    check(Prop.forAll((n: Int) => PascalTriangle.pos(0, n) == 1))
  }

  it should "have all 1's along the right edge according to scalaCheck" in {
    check(Prop.forAll((n: Int) => PascalTriangle.pos(n, n) == 1))
  }

  // this is slower because it is generating the whole triangle
  it should "have all 1's along the right edge again" in {
    assert((0 to 10).forall(x => PascalTriangle.triangle(x)(x) == 1))
  }


  it should "have a 3rd row" in {
    assert(Array(1,2,1) === PascalTriangle.row(2))
  }

  it should "have a 4th row" in {
    assert(Array(1,3,3,1) === PascalTriangle.row(3))
  }

  it should "have a 5th row" in {
    assert(Array(1,4, 6,4,1) === PascalTriangle.row(4))
  }

 it should "have compute the triangle" in {
    assert(Array(
      Seq(1),
      Seq(1,1),
      Seq(1,2,1),
      Seq(1,3,3,1),
      Seq(1,4, 6,4,1)) === PascalTriangle.triangle.take(5).toArray)
  }

}


