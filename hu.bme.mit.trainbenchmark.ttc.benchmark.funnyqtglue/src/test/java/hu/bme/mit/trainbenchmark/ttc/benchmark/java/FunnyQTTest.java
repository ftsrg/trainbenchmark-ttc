package hu.bme.mit.trainbenchmark.ttc.benchmark.java;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.funnyqtglue.FunnyQTBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.test.TrainBenchmarkTest;

public class FunnyQTTest extends TrainBenchmarkTest {

	@Override
	protected AbstractBenchmarkLogic getBenchmarkLogic(final BenchmarkConfig bc) {
		return new FunnyQTBenchmarkLogic(bc);
	}
	
}
