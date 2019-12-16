package fixtures


import com.h2.services.Currency
import org.scalatest.Outcome
import org.scalatest.flatspec.FixtureAnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Random

class WithFixtureParamSpec extends FixtureAnyFlatSpec with Matchers {
  private val random = new Random
  private var currencies: List[Currency] = List.empty
  private val currencyCodes = List("CAD", "USD", "EUR", "SGD")

  override protected def withFixture(test: OneArgTest): Outcome = {
    currencies = (1 to random.between(100, 201)).map(_ => {
      val randomAmount = random.between(10, 101)
      val randomCurrencyCode = currencyCodes(random.between(0, currencyCodes.length))
      val currency: Currency = s"$randomAmount $randomCurrencyCode"
      currency
    }).toList

    try {
      withFixture(test.toNoArgTest(FixtureParam(currencies)))
    } finally {
      info("Removing all currencies")
      currencies = List.empty
    }
  }

  case class FixtureParam(currencies: List[Currency])

  behavior of "Testing Random Currencies with withFixture"
  it should "have totalCost of Dollars more than $10" in { f =>
    // info(f.currencies.mkString(","))
//    info(f.currencies.size.toString)
     f.currencies.map(_.costInDollars.amount).sum should be > 10
  }

  it should "not have any currency with code INR or NZD" in { f =>
//     info(f.currencies.size.toString)
    f.currencies should contain noneOf ("INR", "NZD")
  }
}

