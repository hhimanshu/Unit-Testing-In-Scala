package matchers

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

// TESTING EQUALITY
// note: works with all except arrays as arrays compare whether its the same instance

// uses our BaseTest
class EqualitySpec extends UnitSpec {

  behavior of "Currency Equals"
  it should "match two 10 USD currencies as equal when using 'should equal' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should equal(currency2)
  }

  behavior of "Currency Equals"
  it should "match two 10 USD currencies as equal when using 'should ===' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should === (currency2)
  }

  behavior of "Currency Equals"
  it should "match two 10 USD currencies as equal when using 'shouldEqual' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldEqual currency2
  }

  behavior of "Currency Equals"
  it should "match two 10 USD currencies as equal when using 'shouldBe' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldBe currency2
  }

  behavior of "Currency Equals"
  it should "match two 10 USD currencies as equal when using 'should be' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should be (currency2)
  }

  // NEGATIVE CONDITIONS
  behavior of "Currency Equals"
  it should "not match 10 USD and 100 USD currencies as equal when using 'should be' syntax" in {
    val tenUsd: Currency = "10 USD"
    val hundredUsd: Currency = "100 USD"

    tenUsd should not be (hundredUsd)
  }

  behavior of "Currency Equals"
  it should "not match 10 USD and 100 USD currencies as equal when using 'should equal' syntax" in {
    val tenUsd: Currency = "10 USD"
    val hundredUsd: Currency = "100 USD"

    tenUsd should not equal (hundredUsd)
  }

}
