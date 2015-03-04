package controllers

import actors.SocketHandlerA
import akka.actor.{ActorRef, Props}
import play.api.Logger
import play.api.Play.current
import play.api.libs.json.JsValue
import play.api.mvc._

import scala.util.Random


object Application extends Controller
{
  Random.setSeed(System.currentTimeMillis())
  val controlId = Math.abs(Random.nextLong())
  val controlUrl = "http://localhost:9000/" + controlId
  Logger.info("control url: " + controlUrl)


  def index = Action {
    Ok(views.html.index(false))
  }


  def control(id: Long) = Action {
    Ok(views.html.index(id == controlId))
  }


  def socket = WebSocket.acceptWithActor[JsValue, JsValue] { implicit request =>
    out: ActorRef => Props(classOf[SocketHandlerA], out)
  }

}