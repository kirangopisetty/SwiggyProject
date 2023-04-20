package Simulation

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TC1_GET extends Simulation {

  //http configuration
  val httpConf = http.baseUrl("https://reqres.in/")
                 http.header("Accept", "application/json")
                 http.header("Content-Type", "application/json")

   //scenario configuration
   val scn1 = scenario("TO GET THE LIST OF USERS IN PAGE-2")
              .exec(http("LIST USERS-PAGE-2")
                  .get("api/users?page=2")
                  .check(status is 200))

   //setup configuration
     setUp(scn1.inject(atOnceUsers(1))).protocols(httpConf)

}
