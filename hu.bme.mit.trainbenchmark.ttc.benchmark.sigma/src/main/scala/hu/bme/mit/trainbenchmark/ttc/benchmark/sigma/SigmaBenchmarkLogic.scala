package hu.bme.mit.trainbenchmark.ttc.benchmark.sigma

import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig
import hu.bme.mit.trainbenchmark.ttc.constants.QueryConstants

// This is the consequence of the unfortunate design of AbstractBenchmarkLogic
abstract class BaseBenchmarkLogic extends AbstractBenchmarkLogic {
  protected def _benchmarkConfig: BenchmarkConfig = benchmarkConfig
  protected def _benchmarkConfig_=(s: BenchmarkConfig) { benchmarkConfig = s }
}

class SigmaBenchmarkLogic(config: BenchmarkConfig) extends BaseBenchmarkLogic {

  import SigmaBenchmarkCase._

  _benchmarkConfig = config
  
  override def getBenchmarkCase(query: String) = query match {
    case QueryConstants.POSLENGTH => Solution.PosLength
    case QueryConstants.SWITCHSENSOR => Solution.SwitchSensor
    case QueryConstants.SWITCHSET => Solution.SwitchSet
    case QueryConstants.ROUTESENSOR => Solution.RouteSensor
    case QueryConstants.SEMAPHORENEIGHBOR => Solution.SemaphoreNeighbor
    case _ => sys.error(s"Unknown query: $query")
  }

}