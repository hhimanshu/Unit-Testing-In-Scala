package matchers

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class EqualitySpec extends AnyFlatSpec with Matchers{

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

}
