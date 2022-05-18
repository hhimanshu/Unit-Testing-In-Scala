package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec{

  behavior of "An Email"

  it should "return an Email object for a valid string" in {
    val email = Email("howdy@google.com")

    // you can add a 'clue' as a second arg to 'assert'
    assert(email.localPart === "howdy", "expected localPart to be 'howdy'")
    assert(email.domain === "google.com")
  }

  it should "return another Email object for another valid String" in {
    assertResult("jim"){
      Email("jim@google.com").localPart
    }
    // if a test is not complete, leave this for colleague.
    // also means you can tests/build tests one at at time
    // fail("Test all properties of Email object")
  }

  // if you want a test to be ignored, replace 'it' with 'ignore'
  it should "throw an exception when an email does not contain the '@' symbol" in {
    withClue("expected IllegalArgumentException since email does not have '@' symbol"){
    assertThrows[IllegalArgumentException] {
      Email("jim.com")
      }
    }
  }
  it should "throw an exception when an email contains more than one '@' symbol" in {
    assertThrows[IllegalArgumentException]{
      Email("jim@@gmail.com")
    }
  }

  it should "intercept the correct error message when email contains no '@' symbol" in {
    val exception = intercept[IllegalArgumentException]{
      Email("jim.com")
    }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@'"))
  }

  it should "intercept the correct error message when email contains more than one '@' symbol" in {
    val exception = intercept[IllegalArgumentException]{
      Email("jim@larry@email.com")
    }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("should not contain '@'"))
  }


}
