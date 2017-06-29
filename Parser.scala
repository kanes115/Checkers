object Parser {
  /**
   * example: C1,D3
   * move: from C1 to D3
   */
  def checkLetter(c: Char) = {
    if(c >= 65 && c <=72)
      true
    else
      false
  }
  def checkNumber(c: Char) = {
    if(c >= 49 && c <=56)
      true
    else
      false
  }
  def checkComma(c: Char) = {
    if(c == 44)
      true
    else
      false
  }

  def isCorrect(line: String) = {
    var correct = true
    if(!checkLetter(line(0))) correct = false
    if(!checkNumber(line(1))) correct = false
    if(!checkComma(line(2))) correct = false
    if(!checkLetter(line(3))) correct = false
    if(!checkNumber(line(4))) correct = false
    correct
  }

  def parse(line: String) = {
    if(!isCorrect(line)) println("Wrong argument")
    else{
      //zwrócenie funkcji
      val start = new Position(line(0).toInt - 64, line(1).toInt - 48)
      val end = new Position(line(3).toInt - 64, line(4).toInt - 48)
      val moveIt = new Move(start, end)
      // println(moveIt.start)
      moveIt
      // println(end.y)
      // println(line(0).toInt - 64)
      // println(line(1).toInt - 48)
      //new Move(line(0) + line(1), line(3) + line(4))
    }
  }

  def main(args: Array[String]): Unit = {
    // if(isCorrect("C1,D3")) println("Tak")
    // else println("Nie")
    var qwe = parse("C1,D3")
    println(qwe)
    // println(qwe.start.x)
  }

}
