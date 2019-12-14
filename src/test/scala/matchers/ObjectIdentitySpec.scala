package matchers

import com.h2.services.CustomerService

class ObjectIdentitySpec extends UnitSpec {
  val customerService: CustomerService = new CustomerService {}

  behavior of "CustomerService when creating new customers"

  it should "create one customer for a given email address" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/12/31")
    val customerId1 = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customerId2 = customerService.createNewCustomer(first, last, email, dateOfBirth)

    val customer1 = customerService.getCustomer(customerId1).get
    val customer2 = customerService.getCustomer(customerId2).get

    customer1 should be theSameInstanceAs customer2

  }
}
