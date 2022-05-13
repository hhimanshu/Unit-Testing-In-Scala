package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarSpec extends AnyFlatSpec{

  behavior of "A Dollar"

  it should "create a Dollar object for number 10 as input" in {
    val tenDollars = Dollars(10)
    assert("$10" === tenDollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)
    // we extends the Ordered[Dollars] trait in 'Dollar' class and implemented the 'compare' method
    // this allowed us to use the comparison symbols '<' and '>'
    assert(tenDollars > fiveDollars)
  }

  it should "correctly identify that $2 < $10" in {
    val tenDollars = Dollars(10)
    val twoDollars = Dollars(2)
    // we extends the Ordered[Dollars] trait in 'Dollar' class and implemented the 'compare' method
    // this allowed us to use the comparison symbols '<' and '>'
    assert(twoDollars < tenDollars)
  }

  it should "correctly add two Dollar amounts" in {
    val tenDollars = Dollars(10)
    val twoDollars = Dollars(2)
    assertResult("$12"){
      (twoDollars + tenDollars).toString
    }
  }

  it should "correctly subtract two Dollar amounts" in {
    val tenDollars = Dollars(10)
    val twoDollars = Dollars(2)
    assertResult("$8"){
      (tenDollars - twoDollars).toString
    }
  }

  it should "correctly identify that $4 == $4" in {
    val fourDollars = Dollars(4)
    assertResult(true){
      fourDollars === fourDollars
    }
  }

  it should "throw an exception when an invalid integer is provided to create Dollars" in {
    // the type of error expected in []
    assertThrows[ArithmeticException]{
      // the input you expect to cause an exception to be thrown
      Dollars(10/0)
    }
  }

  it should "have every dollar more than 0" in {
    // assume api call
    val dollars: List[Dollars] = List.empty

    // PreConditions: The test would pass without this line. We want to cancel it as there are no dollars.
    assume(dollars.nonEmpty)

    dollars.foreach{ d =>
      assert(d.amount > 0)
    }
  }
}
