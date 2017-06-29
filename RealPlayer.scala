import CheckerColor._

class RealPlayer(var myColor: CheckerColor, var myName: String) extends Player {

  def this() = this(myColor, myName)

  def getNextMove(master: Master): Move = Parser.parse(scala.io.StdIn.readLine())
}