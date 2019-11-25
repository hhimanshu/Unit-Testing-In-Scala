package com.h2.entities

import java.time.LocalDate
import java.util.UUID

class Customer(val first: String, val last: String,
               val email: Email, val dateOfBirth: LocalDate) {
  val id: UUID = UUID.randomUUID()

  override def toString: String = s"$id -> $first,$last,$email"
}

/** M2 - Example of customer creation exception because of invalid date */
object Run extends App {
  val Jim = new Customer("Jim", "Ben", Email("jim@ben.com"), LocalDate.parse("a/b/c"))
}