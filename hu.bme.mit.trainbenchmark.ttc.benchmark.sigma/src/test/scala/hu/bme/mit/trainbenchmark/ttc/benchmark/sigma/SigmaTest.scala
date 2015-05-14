package hu.bme.mit.trainbenchmark.ttc.benchmark.sigma

import hu.bme.mit.trainbenchmark.ttc.benchmark.test.TrainBenchmarkTest
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig

class SigmaTest extends TrainBenchmarkTest {

  protected def getBenchmarkLogic(bc: BenchmarkConfig) = new SigmaBenchmarkLogic(bc)
  
}