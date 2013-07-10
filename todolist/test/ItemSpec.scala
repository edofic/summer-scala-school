/**
 * User: bss
 * Date: 7/9/13
 * Time: 2:54 PM
 */

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import models._

class ItemSpec extends Specification with MongoTests {

  "Item" should {

    "create item" in {
      withApp {
        val item = Item("foo", "bar")
        Item.save(item)

        val items = Item.findAll()

        items.length must equalTo(1)
      }
    }

    "give us empty list of items" in {
      withApp {
        val items = Item.findAll()

        items.length must equalTo(0)
      }
    }

  }

}
