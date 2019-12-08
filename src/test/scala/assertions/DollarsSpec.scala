package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec {

  behavior of "A Dollar"

  it should "create a correct Dollar object for number 10 as input" in {
    val tenDollars = Dollars(10)

    assert("$10" === tenDollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)

    assert(tenDollars > fiveDollars)
  }

  it should "correctly identify that $2 < $10" in {
    val tenDollars = Dollars(10)
    val twoDollars = Dollars(2)

    assert(twoDollars < tenDollars)
  }
}
