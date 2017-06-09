import stainless.annotation._
import stainless.lang._

object Mean {

  def meanOverflow(x: Int, y: Int): Int = {
    require(x <= y && x >= 0 && y >= 0)
    (x + y)/2
  } ensuring(m => m >= x && m <= y)

// Counterexample for postcondition violation in `meanOverflow`:
//   when y is:
//     1865154560
//   when x is:
//     1277440000

}