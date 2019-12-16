package fixtures

import com.h2.services.Currency
import matchers.UnitSpec
import org.scalatest.BeforeAndAfter

import scala.util.Random

class BeforeAndAfterSpec extends UnitSpec with BeforeAndAfter {
  private val random = new Random
  private var currencies: List[Currency] = List.empty
  private val currencyCodes = List("CAD", "USD", "EUR", "SGD")

  before {
    currencies = (1 to random.between(100, 201)).map(_ => {
      val randomAmount = random.between(10, 101)
      val randomCurrencyCode = currencyCodes(random.between(0, currencyCodes.length))
      val currency: Currency = s"$randomAmount $randomCurrencyCode"
      currency
    }).toList
  }

  after {
    currencies = List.empty
  }

  behavior of "Testing Random Currencies with BeforeAndAfter"
  it should "have totalCost of Dollars more than $10" in {
    // info(currencies.mkString(","))
//     info(currencies.size.toString)
    currencies.map(_.costInDollars.amount).sum should be > 10
  }

  it should "not have any currency with code INR or NZD" in {
//     info(currencies.size.toString)
    currencies should contain noneOf ("INR", "NZD")
  }
}
