package actors

import akka.actor.{ActorRef, Actor}


class SocketHandlerA(out: ActorRef, broadcaster: ActorRef) extends Actor
{
  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    broadcaster ! "hi"
  }

  override def receive: Receive = {
    case s @ ("left" | "right") =>
      broadcaster ! s
    case s @ ("left!" | "right!") =>
      out ! s
  }
}
