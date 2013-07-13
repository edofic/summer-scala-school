package controllers

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data._

object Login extends Controller {

  val loginForm = Form(
    tuple(
      "username" -> text,
      "password" -> text
    )
  )

  def login = Action {
    Ok(views.html.login(loginForm))
  }

  def doLogin = Action { implicit request =>

    val (username, password) = loginForm.bindFromRequest.get

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
