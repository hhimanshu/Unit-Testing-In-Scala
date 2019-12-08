package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {

  behavior of "An Email"

  it should "return an Email object for a valid String" in {
    val email = Email("howdy@google.com")

    assert(email.localPart === "howdy")
    assert(email.domain === "google.com")
  }

  it should "return another Email object for another valid String" in {
    assertResult("jim") {
      Email("jim@google.com").localPart
    }
  }

  it should "throw an exception when an email does not contain '@' symbol" in {
    assertThrows[IllegalArgumentException] { Email("jim.com") }
  }

  it should "throw an exception when an email contains more than one '@' symbol" in {
    assertThrows[IllegalArgumentException] { Email("jim2@2@google.com") }
  }

  it should "intercept the correct error message when no '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] { Email("google.com") }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@'"))
  }

  it should "intercept the correct error message when more than one '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] { Email("reach@larry@google.com") }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("should not contain '@'"))
  }
}
