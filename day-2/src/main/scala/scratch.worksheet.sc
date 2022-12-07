import scala.io.Source

val input = Source.fromFile("input.txt").getLines.map(s => (s(0), s(2))).toList

val s1 = ('A', 'Y')
val s2 = ('B', 'X')
val s3 = ('C', 'Z')

def rockPaperScissors(input: (Char, Char)) =
  val winMap = Map('A' -> 'Y', 'B' -> 'Z', 'C' -> 'X')
  val drawMap = Map('A' -> 'X', 'B' -> 'Y', 'C' -> 'Z')
  val pointMap = Map('X' -> 1, 'Y' -> 2, 'Z' -> 3)

  input match
    case (a, b) if (b == winMap(a)) => 6 + pointMap(b) // win
    case (a, b) if b == drawMap(a)  => 3 + pointMap(b) // draw
    case (_, b)                     => pointMap(b) // loss

// pt. 1
input.map(rockPaperScissors).sum

def rockPaperScissors_2(input: (Char, Char)) =
  val winMap = Map('A' -> 'Y', 'B' -> 'Z', 'C' -> 'X')
  val drawMap = Map('A' -> 'X', 'B' -> 'Y', 'C' -> 'Z')
  val lossMap = Map('A' -> 'Z', 'B' -> 'X', 'C' -> 'Y')
  val pointMap = Map('X' -> 1, 'Y' -> 2, 'Z' -> 3)

  input match
    case (a, b) if b == 'Z' => 6 + pointMap(winMap(a)) // win  Z
    case (a, b) if b == 'Y' => 3 + pointMap(drawMap(a)) // draw Y
    case (a, b) if b == 'X' => pointMap(lossMap(a)) // loss X

// pt. 2
input.map(rockPaperScissors_2).sum
