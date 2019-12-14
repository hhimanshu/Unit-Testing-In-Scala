package matchers

import com.h2.entities.Dollars
import com.h2.services.Currency
import org.scalatest.Inside

class PatternMatchingSpec extends UnitSpec with Inside {

  behavior of "Currency when pattern matching"
  it should "be able to assert on the values of a currency" in {
    val tenUsd: Currency = "10 USD"

    inside(tenUsd) { case Currency(code, amount, costInDollars) =>
      code should equal ("USD")
      amount should equal (10.0 +- 0.5)
      costInDollars should be > Dollars(12)
    }
  }

  it should "be able to 'matchPattern' on the currency code" in {
    val tenUsd: Currency = "10 USD"
    tenUsd should matchPattern {case Currency("USD", _, _) => }
  }
}
