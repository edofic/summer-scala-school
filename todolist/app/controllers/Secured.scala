package controllers

import play.api.mvc._

/**
 * User: bss
 * Date: 7/9/13
 * Time: 1:04 PM
 */

trait Secured {
  this: Controller =>

  def usernameFromRequest(header: RequestHeader): Option[String] = {
    header.session.get("user")
  }

  def onUnauthorized(header: RequestHeader) = {
    Redirect(routes.Login.login())
  }

  def AuthAction(f: String => EssentialAction): EssentialAction = {
    Security.Authenticated(usernameFromRequest,onUnauthorized)(f)
  }
}
