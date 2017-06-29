import CheckerColor._

class RealPlayer(var myColorr: CheckerColor, var myNamee: String) extends Player(myColorr, myNamee) {

  def getNextMove(master: Master): Move = {
    println("Player " + myNamee + ":")
    Parser.parse(scala.io.StdIn.readLine())
  }
}