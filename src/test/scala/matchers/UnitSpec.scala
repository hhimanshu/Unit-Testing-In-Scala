package matchers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

// CREATING A BASE TEST -
// TO AVOID REPEATING THE ANY-FLATSPEC WITH MATCHERS IN ALL TESTS

abstract class UnitSpec extends AnyFlatSpec with Matchers
