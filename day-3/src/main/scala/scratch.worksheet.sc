import scala.io.Source

extension (s: String)
  def splitAtMiddle: (String, String) = s.splitAt(s.size >> 1)

  def charToVal: Int =
    if s(0).isUpper then s.codePointAt(0) - 38
    else s.codePointAt(0) - 96

extension (s: (String, String))
  def findIntersect: String = s match { case (a, b) => a.intersect(b) }

extension (s: Seq[String])
  def findTripleIntersect: Set[Char] =
    s(0).intersect(s(1).intersect(s(2))).toSet

// pt. 1
val input = Source
  .fromFile("input.txt")
  .getLines
  .map(_.splitAtMiddle.findIntersect.charToVal)
  .sum

// pt. 2
val input2 = Source
  .fromFile("input.txt")
  .getLines
  .grouped(3)
  .flatMap(ls => ls.findTripleIntersect)
  .map(_.toString.charToVal)
  .sum
