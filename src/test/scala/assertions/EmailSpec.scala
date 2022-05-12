package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec{

  behavior of "An Email"

  it should "return an Email object for a valid string" in {
    val email = Email("howdy@google.com")

    assert(email.localPart === "howdy")
    assert(email.domain === "google.com")

  }


}
