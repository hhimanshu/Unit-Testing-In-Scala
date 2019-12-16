package async

import com.h2.entities.Dollars
import org.scalatest.ParallelTestExecution
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.Future

class AsyncDollarSpec extends AsyncFlatSpec with Matchers with ParallelTestExecution {

  def addDollars(dollars: Dollars*): Future[Dollars] = Future {
    val totalAmount = dollars.map(dollar => dollar.amount).sum
    Dollars(totalAmount)
  }

  def multiplyDollars(dollars: Dollars*): Future[Dollars] = Future {
    val totalAmount = dollars.map(dollar => dollar.amount).product
    Dollars(totalAmount)
  }

  behavior of "Async Dollars"

  it should "correctly add dollars in Future" in {
    val total: Future[Dollars] = addDollars(Dollars.Zero, Dollars(10), Dollars(2))
    total.map(dollars => dollars.amount shouldBe 12)
  }

  it should "correctly multiply dollars in Future" in {
    val total: Future[Dollars] = multiplyDollars(Dollars(1), Dollars(10), Dollars(2))
    total.map(dollars => dollars.amount shouldBe 20)
  }
}
