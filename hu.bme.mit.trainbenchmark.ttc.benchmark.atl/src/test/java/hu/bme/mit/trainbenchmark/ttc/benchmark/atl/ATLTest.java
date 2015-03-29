package hu.bme.mit.trainbenchmark.ttc.benchmark.atl;

import hu.bme.mit.trainbenchmark.ttc.benchmark.atl.ATLBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.test.TrainBenchmarkTest;

public class ATLTest extends TrainBenchmarkTest {

	@Override
	protected AbstractBenchmarkLogic getBenchmarkLogic(final BenchmarkConfig bc) {
		return new ATLBenchmarkLogic(bc);
	}
	
}
