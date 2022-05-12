import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFlatSpec{

  // FlatSpec style - the specification text and test are in a flat structure no nesting
  behavior of "Hello World"

    it should "start with 'Hello'" in {
      assert("Hello World".startsWith("Hello"))
    }
    it should "end with 'World'" in {
      assert("Hello World".endsWith("World"))
    }
}