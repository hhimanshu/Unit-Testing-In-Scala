package matchers

import com.h2.services.Currency

class LogicalSpec extends UnitSpec {
  behavior of "Currencies as logical and|or"

  it should "successfully match logical expression with 'and' condition for a currency" in {
    val tenNzd: Currency = "10 NZD"

    tenNzd.costInDollars.amount should (be > (0) and be <= (10))
  }

  it should "successfully match logical expression with 'or' condition for a currency" in {
    val tenNzd: Currency = "10 NZD"

    tenNzd.code should (have length (0) or equal ("NZD"))
  }
}
