package actors

import akka.actor.{Actor, ActorRef}
import play.api.libs.json.{JsBoolean, JsObject}


class SocketHandlerA(out: ActorRef) extends Actor
{
  override def receive: Receive =
  {
    case js: JsObject =>
      if ((js \ "broadcast").asOpt[Boolean].getOrElse(false))
        out ! js
      else {
        val msg = js +("broadcast", JsBoolean(true))
        context.actorSelection("/system/websockets/*/handler") ! msg
      }
  }
}
