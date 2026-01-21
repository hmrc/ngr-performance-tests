package uk.gov.hmrc.perftests.example

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object RegisterRequests extends ServicesConfiguration{

  val registerBaseUrl: String = baseUrlFor("ngr-login-register-frontend") + "/ngr-login-register-frontend"

  object Pages {
    lazy val registerStart: String = s"$registerBaseUrl/register"
    lazy val provideTRN: String = s"$registerBaseUrl/provide-your-tax-reference-number"
    lazy val confirmTRN: String = s"$registerBaseUrl/confirm-utr"
    lazy val checkAnswers: String = s"$registerBaseUrl/check-answers"
  }

  def getProvideTRNPage: HttpRequestBuilder = {
    http("Navigate to the Provide Your Tax Reference Number Page")
      .get(Pages.provideTRN)
      .check(status is 303)
  }

  def getConfirmUtrPage: HttpRequestBuilder = {
    http("Navigate to the Confirm Your UTR Page")
      .get(Pages.confirmTRN)
      .formParam("confirmUTR","Yes(1097122222)")
      .check(status is 303)
  }

  def getCheckAnswersPage: HttpRequestBuilder = {
    http("Navigate to the Check your answers page")
      .get(Pages.checkAnswers)
      .check(status is 303)
  }

}
