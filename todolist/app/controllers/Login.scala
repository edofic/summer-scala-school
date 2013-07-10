package controllers

import play.api._
import play.api.mvc._

/**
 * User: bss
 * Date: 7/9/13
 * Time: 12:56 PM
 */

object Login extends Controller {

  def login = Action {
    Ok(views.html.login())
  }

  def doLogin = Action { request =>
    val username = request.body.asFormUrlEncoded.get.get("username").get.head
    val password = request.body.asFormUrlEncoded.get.get("password").get.head

    //do some fancy shmancy auth
    if (username == "scala" && password == "jeKul") {
      Redirect(routes.Application.allHtml()).withSession("user" -> username)
    } else {
      Redirect(routes.Login.login())
    }
  }

  def logout = Action { request =>
    Redirect(routes.Application.allHtml()).withNewSession
  }
}
