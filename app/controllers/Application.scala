package controllers

import actors.SocketHandlerA
import akka.actor.{ActorRef, Props}
import play.api.Play.current
import play.api.mvc._


object Application extends Controller
{

  def index = Action {
    Ok(views.html.index(false))
  }


  def control = Action {
    Ok(views.html.index(true))
  }


  def socket = WebSocket.acceptWithActor[String, String] { implicit request =>
    out: ActorRef => Props(classOf[SocketHandlerA], out)
  }

}