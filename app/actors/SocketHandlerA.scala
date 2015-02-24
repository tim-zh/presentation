package actors

import akka.actor.{Actor, ActorRef}


class SocketHandlerA(out: ActorRef) extends Actor
{
  override def receive: Receive =
  {
    case s @ ("left" | "right") =>
      context.actorSelection("/system/websockets/*/handler") ! (s + "!")
    case s @ ("left!" | "right!") =>
      out ! s
  }
}
