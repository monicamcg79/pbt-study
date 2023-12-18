import org.scalatest.freespec.AnyFreeSpec

final class GenSpec extends AnyFreeSpec {
    "between" in {
        val gen = Gen.between(0, 100).gen
        println("hey")
        info(gen.toString)
    }
     "lowercase" in {
        val gen = Gen.lowercase.gen
        info(gen.toString)
    }
     "uppercase" in {
        val gen = Gen.uppercase.gen
        info(gen.toString)
    }
     "lower and upper case" in {
        val gen = Gen.lowerOrUpperCase.gen
        info(gen.toString)
    }
     "list of length " in {
        implicit val i = Gen.int
        val gen = Gen.listOfLength(length = 20).gen
        info(gen.toString)
    }
     "list" in {
        implicit val i = Gen.int
        val gen = Gen.list.gen
        info(gen.toString)
    }
     "user" in {
        val gen = Gen.user.gen
        info(gen.toString)
    }
}