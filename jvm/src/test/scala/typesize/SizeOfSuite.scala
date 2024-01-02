package typesize

import munit.FunSuite

class SizeOfSuite extends FunSuite:

  test("Some[Boolean] == 3"):
    val obtained: Cardinality = summon[SizeOf[Option[Boolean]]].size
    val expected: Cardinality = Finite(3)
    assertEquals(obtained, expected)