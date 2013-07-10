package controllers

import play.api._
import play.api.mvc._
import models.Item

object Application extends Controller with Secured {
  
  def index = Action {
    Ok(views.html.index("Your old application is ready."))
  }

//  def all = AuthAction { user =>
//    Action {
//      val items =
////      val snapshot = Item.all()
////      val msg = snapshot mkString "\n"
//      Ok(msg)
//    }
//  }

  def allHtml = AuthAction { user =>
    Action {
      val snapshot = Item.findAll().toList
      Ok(views.html.items(snapshot))
    }
  } // https://gist.github.com/bancek/5956593

  def create() = AuthAction { user =>
      Action { request =>
      val name = request.body.asFormUrlEncoded.get.get("name").get.head
      val content = request.body.asFormUrlEncoded.get.get("content").get.head

      val item = Item(name, content)
      Item.save(item)

      Redirect(routes.Application.allHtml())
    }
  }

  def delete() = AuthAction { user =>
    Action { request =>
      val name = request.body.asFormUrlEncoded.get.get("name").get.head
      Item.removeById(name)
      Redirect(routes.Application.allHtml())
    }
  }
  
}