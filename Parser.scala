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

  def correctness(line: String) = {
    var correct = true
    if(!checkLetter(line(0))) correct = false
    if(!checkNumber(line(1))) correct = false
    if(!checkComma(line(2))) correct = false
    if(!checkLetter(line(3))) correct = false
    if(!checkNumber(line(4))) correct = false
    correct
  }

  def parse(line: String) = {
    if(!correctness(line)) println("Wrong argument")
    else{
      //zwrócenie funkcji
      move(line(0) + line(1), line(3) + line(4))
    }
  }

  def main(args: Array[String]): Unit = {
    if(correctness("C1,D3")) println("Tak")
    else println("Nie")
  }

}
