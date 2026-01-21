package uk.gov.hmrc.perftests.example

import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AuthRequests extends ServicesConfiguration{

  val authWizUrl: String = baseUrlFor("auth-login-stub") + "/auth-login-stub/gg-sign-in"

  lazy val navigateToAuth: HttpRequestBuilder =
    http("Navigate to Auth wizard")
      .get(authWizUrl)
      .check(status.is(200))

  def logIn(): HttpRequestBuilder =
    http("Login as a user")
      .post(authWizUrl)
      .formParam("redirectionUrl", RegisterRequests.Pages.registerStart)
      .formParam("excludeGnapToken", "No")
      .formParam("credentialStrength", "strong")
      .formParam("authorityId", "")
      .formParam("confidenceLevel", "250")
      .formParam("affinityGroup", "Individual")
      .formParam("nino","AA000003D")
      .check(status.is(303))
}
