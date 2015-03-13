package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.GenericBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.test.TrainBenchmarkTest;

public class EMFIncQueryTest extends TrainBenchmarkTest {

	@Override
	protected String getTool() {
		return "EMFIncQuery";
	}

	@Override
	protected GenericBenchmarkLogic getBenchmarkLogic(final BenchmarkConfig bc) {
		return new EMFIncQueryBenchmarkLogic(bc);
	}
	
}
