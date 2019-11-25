package com.h2.entities

object Email {
  def apply(value: String): Either[IllegalArgumentException, Email] = {
    val strings: Array[String] = value.split("@")
    if (strings.length < 2) {
      Left(new IllegalArgumentException("invalid email: does not contain '@' symbol"))
    }
    if (strings.length > 2) {
      Left(new IllegalArgumentException("invalid email: should not contain '@' symbol more than once"))
    }
    Right(new Email(strings(0), strings(1)))
  }
}

class Email(val localPart: String, val domain: String) {
  override def toString: String = s"$localPart@$domain"
}