package hu.bme.mit.trainbenchmark.ttc.benchmark.sigma

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig

 
object SigmaBenchmarkMain extends App {
  
  new SigmaBenchmarkLogic(new SigmaBenchmarkConfig(args)).runBenchmark()
  
}