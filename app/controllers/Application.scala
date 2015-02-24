package controllers

import actors.{BroadcasterA, SocketHandlerA}
import akka.actor.{Props, ActorRef}
import play.api._
import play.api.mvc._
import play.api.Play.current
import play.libs.Akka


object Application extends Controller {

  val broadcaster = Akka.system().actorOf(Props(classOf[BroadcasterA]))

  def index = Action {
    Ok(views.html.index(false))
  }

  def control = Action {
    Ok(views.html.index(true))
  }

  def socket = WebSocket.acceptWithActor[String, String] { implicit request =>
    out: ActorRef => Props(classOf[SocketHandlerA], out, broadcaster)
 	}

}