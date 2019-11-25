package com.h2.services

import java.time.LocalDate
import java.util.UUID

import com.h2.entities.{Customer, Email}

trait CustomerService extends CustomersDb {
  /**
    * // todo: (challenge?) how to disallow customer with same details?
    *
    * @param first       : first name for the customer
    * @param last        : last name for the customer
    * @param email       : email for the customer in 'value@domain' format
    * @param dateOfBirth : : date of birth for the customer in 'yyyy/mm/dd' format
    * @return the customer id for the new customer
    */
  def createNewCustomer(first: String, last: String,
                        email: String, dateOfBirth: String): UUID = {

    def getDateOfBirth: LocalDate = {
      val Array(year: String, month: String, day: String) = dateOfBirth.split("/")
      LocalDate.of(year.toInt, month.toInt, day.toInt)
    }

    val customer = new Customer(first, last, Email(email).toOption.head, getDateOfBirth)
    saveCustomer(customer)
    customer.id
  }
}
