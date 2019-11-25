package com.h2.entities

import org.scalatest.FlatSpec

class EmailSpec extends FlatSpec{

  behavior of "An Email"
  it should "return an Email object for a valid string" in {
    val email = Email("howdy@google.com")

  }
}
