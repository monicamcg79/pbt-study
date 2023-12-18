error id: file://<WORKSPACE>/src/main/scala/Gen.scala:[577..578) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/Gen.scala", "import Gen._
import scala.util.Random

trait Gen[A] {
  def gen: A

  def map[B](f: A => B): Gen[B] = {
    Gen.from(f(gen))
  }

  def flatMap[B](f: A => Gen[B]): Gen[B] = {
    from(f(gen).gen)
  }
}

object Gen {
  def apply[A](implicit gen: Gen[A]): Gen[A] = gen

  def from[A](a: => A): Gen[A] = new Gen[A] {
    override def gen = a
  }

  def between(min: Int, max: Int): Gen[Int] = {
    from(Random.nextInt(max - min) + min)
  }

  def lowercase: Gen[Char] =
    between(65, 91).map(_.toChar)

  def uppercase: Gen[Char] =
    between(97, 123).map(_.toChar)

    def 
}
")
file://<WORKSPACE>/src/main/scala/Gen.scala
file://<WORKSPACE>/src/main/scala/Gen.scala:34: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace