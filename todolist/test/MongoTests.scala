/**
 * User: bss
 * Date: 7/9/13
 * Time: 2:51 PM
 */

import com.mongodb.casbah.MongoClient
import play.api.test._
import play.api.test.Helpers._
import com.mongodb.casbah.Imports._

trait MongoTests {

  def withApp[T](block: => T) = {
    val host = "192.168.3.203"
    val dbName = "lukazakrajsek_test"

    val mongoClient = MongoClient(host)
    mongoClient.dropDatabase(dbName)

    val app = FakeApplication(
      additionalConfiguration =
        Map("mongodb.default.db" -> dbName)
    )

    running(app)(block)
  }

}
