import scala.io.Source

@main def day_1: Unit =
  // pt. 1
  println(calsPerElf(input).max)

  // pt. 2
  println(topThreeElves(calsPerElf(input)))

val input = Source.fromFile("input.txt").getLines.toList

def calsPerElf(
    input: List[String],
    sum: Int = 0,
    sumList: List[Int] = List()
): List[Int] =
  input match
    case Nil                    => sumList
    case hd :: tl if hd.isEmpty => calsPerElf(tl, 0, sum :: sumList)
    case hd :: tl               => calsPerElf(tl, hd.toInt + sum, sumList)

    // make classes someday
    // elves.calsPerElf.max
    // elves[elf].map(elf => elf.sum).max

def topThreeElves(elves: List[Int]): Int =
  elves.sorted.takeRight(3).sum
