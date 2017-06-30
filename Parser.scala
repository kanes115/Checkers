import com.sun.media.sound.InvalidFormatException

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

  def parse(line: String): Move = {
    if(!correctness(line)) throw new InvalidFormatException("Wrong argument")
    else{
      //zwrócenie funkcji
      val start = new Position(line(0).toInt - 65, line(1).toInt - 49)
      val end = new Position(line(3).toInt - 65, line(4).toInt - 49)
      // return
      new Move(start, end)
    }
  }

  def main(args: Array[String]): Unit = {
    println("Insert player1 (White):")
    val p1: Player = new RealPlayer(CheckerColor.White, scala.io.StdIn.readLine())
    println("Insert player2 (Black):")
    val p2: Player = new RealPlayer(CheckerColor.Black, scala.io.StdIn.readLine())
    val board = new Board()
    val master = new Master(p1, p2, board)
    master.run()
  }

}
