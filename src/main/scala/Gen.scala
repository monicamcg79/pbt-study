import Gen._
import scala.util.Random
import org.scalactic.Bool

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

  def lowerOrUpperCase: Gen[Char] = {
    Gen[Boolean].flatMap {
      case true  => lowercase
      case false => uppercase
    }
  }

  def list[A: Gen]: Gen[List[A]] = {
    listOfLength(between(0, 20).gen)
  }

  def listOfLength[A: Gen](length: Int): Gen[List[A]] = {
    from(Stream.fill(length)(Gen.apply[A].gen).toList)
  }

  implicit val bool: Gen[Boolean] = {
    between(0, 2).map {
      case 1 => true
      case 0 => false
    }
  }

  implicit val int: Gen[Int] = between(0, Int.MaxValue)

  def name: Gen[String] = list(lowerOrUpperCase).map(_.mkString)
  def age: Gen[Int] = from(between(0, 100).gen)
  def user: Gen[User] = from(User(name = name.gen, age = age.gen))

}
