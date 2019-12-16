package fixtures

import com.h2.entities.Dollars
import com.h2.services.Currency
import matchers.UnitSpec

/**
 * Show by duplicate code and then refactoring into the fixture object
 */
class ScalaFixtureSpec extends UnitSpec {

  def fixture = new {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"
  }

  behavior of "Currency Equals"

  it should "match two 10 USD currencies as equal when using 'should equal' syntax" in {
    val f = fixture
    f.currency1 should equal(f.currency2)
  }

  it should "match two 10 USD currencies as equal when using 'should ===' syntax" in {
    val f = fixture
    f.currency1 should ===(f.currency2)
  }

  it should "add two dollars together" in {
    val f = fixture

    (f.currency1.costInDollars + f.currency2.costInDollars) should be >= Dollars(20)
  }
}
