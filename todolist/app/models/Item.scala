package models

/**
 * User: bss
 * Date: 7/9/13
 * Time: 10:04 AM
 */

import play.api.Play.current
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import mongoContext._

case class Item(
  @Key("_id") name: String,
  content: String
)

object Item extends ModelCompanion[Item, String] {
  val dao = new SalatDAO[Item, String](collection =
    mongoCollection("items")) {}
}

//object Item {
//
//  private var state = List[Item]()
//
//  def all() = state
//
//  def create(name: String, content: String) = {
//    val newItem = Item(name, content)
//    state = newItem :: state
//  }
//
//  def delete(name: String) = {
////    val myFilter = (item: Item) => item.name == name
//
//    state = state.filterNot(_.name == name)
////    state = state.filterNot((item) => item.name == name)
////    state = state.filterNot(myFilter)
//  }
//}
