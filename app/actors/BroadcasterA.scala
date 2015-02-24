package actors

import akka.actor.{Terminated, ActorRef, Actor}

class BroadcasterA extends Actor
{
  var actors: List[ActorRef] = Nil

  override def receive: Receive = {
    case "hi" =>
      actors = sender() :: actors
      context watch sender
    case s @ ("left" | "right") =>
      actors.foreach {
        _ ! (s + "!")
      }
    case Terminated(actor) =>
      actors = actors filter (_ != sender())
  }
}
