package actors

import akka.actor.{Actor, ActorRef}


class SocketHandlerA(out: ActorRef) extends Actor
{
  override def receive: Receive =
  {
    case s: String if s.endsWith("!") =>
      out ! s
    case s: String =>
      context.actorSelection("/system/websockets/*/handler") ! (s + "!")
  }
}
