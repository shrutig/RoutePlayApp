package models

case class Route(start: String, dest: String, mode: String, timeHours: Int)

object Route {
  val availableRoute = Seq(Route("Agra", "Mumbai","road",6),
    Route("Delhi", "Mumbai","road",5),
    Route("Delhi", "Kolkata","rail",4),
    Route("Chennai", "Kolkata","air",9),
    Route("Chennai", "Delhi","road",10),
    Route("Hyderabad", "Bangalore","air",13),
    Route("Hyderabad", "Mumbai","road",14),
    Route("Hyderabad", "Delhi","air",19),
    Route("Agra", "Kolkata","rail",9),
    Route("Srinagar", "Mumbai","road",16))

  def fetch: Seq[Route] = {
    availableRoute
  }

  def fetchByCity(name: String): Seq[Route] = {
    availableRoute filter(a => a.start ==name || a.dest==name)
    //availableRoute.filter(a => a.start.equals(name) || a.dest.equals(name) )
  }

  def fetchByTwoCity(start:String,dest:String): Seq[Route] ={
    availableRoute filter(a => (a.start == start && a.dest== dest)||(a.start == dest && a.dest ==start))
    //availableRoute.filter(a => a.start.equals(name) || a.dest.equals(name) )
  }



}