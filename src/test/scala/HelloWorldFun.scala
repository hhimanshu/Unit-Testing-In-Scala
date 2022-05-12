import org.scalatest.funsuite.AnyFunSuite

class HelloWorldFun extends AnyFunSuite{
  test("A String 'Hello World' should start with 'Hello'"){
    assert("Hello World".startsWith("Hello"))
  }
}
