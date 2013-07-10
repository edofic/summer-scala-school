/**
 * User: bss
 * Date: 7/9/13
 * Time: 2:54 PM
 */

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import play.api.libs.ws.WS

class FunctionalTest extends Specification with MongoTests {

  "Our app" should {

    "run in a server" in new WithServer {
      val res = await(WS.url("http://localhost:" + port + "/all")
        .get)

      res.status must equalTo(OK)
      res.body must contain("Login")
    }

  }

}
