package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.test.TrainBenchmarkTest;

public class EMFIncQueryTest extends TrainBenchmarkTest {

	@Override
	protected AbstractBenchmarkLogic getBenchmarkLogic(final BenchmarkConfig bc) {
		return new EMFIncQueryBenchmarkLogic(bc);
	}
	
}
