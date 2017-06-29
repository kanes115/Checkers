import CheckerColor._

class RealPlayer(var myColorr: CheckerColor, var myNamee: String) extends Player(myColorr, myNamee) {

  def getNextMove(master: Master): Move = Parser.parse(scala.io.StdIn.readLine())
}