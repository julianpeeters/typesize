package typesize

import typesize.SizeOf.Cardinality
export SizeOf.*

trait SizeOf[A]:
  def size: Cardinality

object SizeOf:

  sealed trait Cardinality
  case class Finite(i: BigInt) extends Cardinality
  case object NonFinite extends Cardinality
  case object TooBigToCompute extends Cardinality

  extension (c1: Cardinality)

    def +(c2: Cardinality): Cardinality =
      (c1, c2) match
        case (Finite(bigInt1), Finite(bigInt2)) => Finite(bigInt1 + bigInt2)
        case (Finite(bigInt1), NonFinite) => NonFinite
        case (Finite(bigInt1), TooBigToCompute) => TooBigToCompute
        case (NonFinite, Finite(bigInt2)) => NonFinite
        case (NonFinite, NonFinite) => NonFinite
        case (NonFinite, TooBigToCompute) => TooBigToCompute
        case (TooBigToCompute, Finite(bigInt2)) => TooBigToCompute
        case (TooBigToCompute, NonFinite) => TooBigToCompute
        case (TooBigToCompute, TooBigToCompute) => TooBigToCompute

    def *(c2: Cardinality): Cardinality =
      (c1, c2) match
        case (Finite(bigInt1), Finite(bigInt2)) => Finite(bigInt1 * bigInt2)
        case (Finite(bigInt1), NonFinite) => NonFinite
        case (Finite(bigInt1), TooBigToCompute) => TooBigToCompute
        case (NonFinite, Finite(bigInt2)) => NonFinite
        case (NonFinite, NonFinite) => NonFinite
        case (NonFinite, TooBigToCompute) => TooBigToCompute
        case (TooBigToCompute, Finite(bigInt2)) => TooBigToCompute
        case (TooBigToCompute, NonFinite) => TooBigToCompute
        case (TooBigToCompute, TooBigToCompute) => TooBigToCompute

    def pow(c2: Cardinality): Cardinality =
      (c1, c2) match
        case (Finite(bigInt1), Finite(bigInt2)) => if bigInt2.isValidInt then Finite(bigInt1.pow(bigInt2.toInt)) else TooBigToCompute
        case (Finite(bigInt1), NonFinite) => NonFinite
        case (Finite(bigInt1), TooBigToCompute) => TooBigToCompute
        case (NonFinite, Finite(bigInt2)) => NonFinite
        case (NonFinite, NonFinite) => NonFinite
        case (NonFinite, TooBigToCompute) => TooBigToCompute
        case (TooBigToCompute, Finite(bigInt2)) => TooBigToCompute
        case (TooBigToCompute, NonFinite) => TooBigToCompute
        case (TooBigToCompute, TooBigToCompute) => TooBigToCompute
      

