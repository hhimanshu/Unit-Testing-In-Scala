package matchers

import com.h2.services.Currency

class ContainerSpec extends UnitSpec {

  behavior of "Currencies in a wallet"

  it should "contain a currency that is added to a List wallet" in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"

    val wallet = List(oneUsd, twoEuros, tenCad)

    wallet should contain (oneUsd)
  }

  // NEGATIVE CONDITIONAL
  it should "not contain a currency that is not  added to a List wallet" in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"
    val tenNzd: Currency = "10 NZD"

    val wallet = List(oneUsd, twoEuros, tenCad)

    wallet should not contain (tenNzd)
  }

  it should "contain a currency that is added to a Set wallet" in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"

    val wallet = Set(oneUsd, twoEuros, tenCad)

    wallet should contain (oneUsd)
  }

  // NEGATIVE CONDITIONAL
  it should "not contain a currency that is not added to a Set wallet" in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"
    val tenNzd: Currency = "10 NZD"

    val wallet = Set(oneUsd, twoEuros, tenCad)

    wallet should not contain (tenNzd)
  }

  it should "contain a currency that is added to a Map wallet" in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"

    val wallet: Map[String, Currency] = Map("USD" -> oneUsd, "EUR" -> twoEuros, "CAD" -> tenCad)

    wallet should contain ("USD" -> oneUsd)
  }

  it should "contain a oneOf 1 USD that is added to a Set wallet" in {
    val oneUsd: Currency = "1 USD"
    val anotherOneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"
    val hundredCad: Currency = "100 CAD"

    val wallet = Set(oneUsd, anotherOneUsd, twoEuros, tenCad)

    // collection should contain exactly 'oneOf' oneUsd OR hundredCad
    wallet should contain oneOf (oneUsd, hundredCad)
    // for lists this must be 'oneElementOf' instead
    wallet should contain oneElementOf List(oneUsd, hundredCad)
  }

  it should "contain noneOf 1 USD and 100 INR that is added to a Set wallet" in {
    val oneUsd: Currency = "1 USD"
    val hundredInr: Currency = "100 INR"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"
    val hundredCad: Currency = "100 CAD"

    val wallet: Set[Currency] = Set(twoEuros, twoEuros, tenCad, hundredCad)

    wallet should contain noneOf(oneUsd, hundredInr)
    // Same thing for Lists
    wallet should contain noElementsOf List(oneUsd, hundredInr)
  }
}
