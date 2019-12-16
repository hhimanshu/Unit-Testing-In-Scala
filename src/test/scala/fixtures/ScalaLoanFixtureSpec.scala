package fixtures

import com.h2.services.Currency
import matchers.UnitSpec

import scala.util.Random

object RandomCurrencies {
  private val random = new Random
  private var currencies: List[Currency] = List.empty
  private val currencyCodes = List("CAD", "USD", "EUR", "SGD")

  def createRandomCurrencies: List[Currency] = {
    currencies = (1 to random.between(100, 201)).map(_ => {
      val randomAmount = random.between(10, 101)
      val randomCurrencyCode = currencyCodes(random.between(0, currencyCodes.length))
      val currency: Currency = s"$randomAmount $randomCurrencyCode"
      currency
    }).toList
    currencies
  }

  def removeRandomCurrencies(): Unit = {
    currencies = List.empty
  }
}


class ScalaLoanFixtureSpec extends UnitSpec {
  import RandomCurrencies._

  def withRandomCurrencies(testCode: List[Currency] => Any): Unit = {
    val currencies = createRandomCurrencies
    try {
      testCode(currencies)
    }
    finally removeRandomCurrencies()
  }

  behavior of "Testing Random Currencies With Loan Pattern"
  it should "have totalCost of Dollars more than $10" in withRandomCurrencies { currencies =>
    // info(currencies.mkString(","))
//     info(currencies.size.toString)

     currencies.map(_.costInDollars.amount).sum should be > 10
  }

  it should "not have any currency with code INR or NZD" in withRandomCurrencies { currencies =>
//     info(currencies.size.toString)

     currencies should contain noneOf ("INR", "NZD")
  }
}
