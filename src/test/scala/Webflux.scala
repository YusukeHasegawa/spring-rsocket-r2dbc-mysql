import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Webflux extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")

  val scn = scenario("Webflux")
    .exec(http("request_0")
      .get("/address/630868")
      .check(status.is(200)))

  setUp(scn.inject(constantUsersPerSec(30) during (30))).protocols(httpProtocol)
}