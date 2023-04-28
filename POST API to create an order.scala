package Simulation

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TC2_POST extends Simulation {

  //httpConfiguration

  val httpConf = http.baseUrl("https://reqres.in")
  http.header("Accept", "application/json")
  http.header("Content-Type", "application/json")

  //scenarioConfiguration

  val scn = scenario("To add a user using POST API")
    .exec(http("CREATE USER")
      .post("/api/users")
      .body(RawFileBody("src/test/resources/TestData/addUser.json")).asJson
      .header("Content-Type", "application/json")
      .check(status is 201))
           
  //setUpConfiguration

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
}
fixed the prod bug by charles