import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"          %% "performance-test-runner"   % "6.1.0"         % Test,
    "org.asynchttpclient"   %  "async-http-client"         % "2.12.3"        % Test,
    "uk.gov.hmrc"           %% "uri-template"              % "1.14.0"        % Test,
    "org.playframework"     %% "play-json"                 % "3.0.4"         % Test
  )

}
