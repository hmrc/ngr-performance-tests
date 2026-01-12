package uk.gov.hmrc.perftests.example

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.example.AuthRequests._
import uk.gov.hmrc.perftests.example.RegisterRequests._


class RegisterSimulation extends PerformanceTestRunner{


  setup("registerRequestEndToEnd","Navigate through NGR Login Register frontend to register a ratepayer").withRequests(
    navigateToAuth,
    logIn(),
    RegisterRequests.getProvideTRNPage,
    RegisterRequests.getConfirmUtrPage,
    RegisterRequests.getCheckAnswersPage
  )


}
