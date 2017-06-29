class RealPlayer(val name: String) extends Player{

  def getNextMove(master: Master): Move = Parser.parse(scala.io.StdIn.readLine())

  def getName: String = name
}