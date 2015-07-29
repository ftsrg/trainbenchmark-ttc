package hu.bme.mit.trainbenchmark.ttc.benchmark.java;

import java.io.IOException;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.ChangeSet;
import hu.bme.mit.trainbenchmark.ttc.benchmark.funnyqtglue.FunnyQTBenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.funnyqtglue.FunnyQTBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.test.TrainBenchmarkTest;

public class FunnyQTTest extends TrainBenchmarkTest {

	@Override
	protected AbstractBenchmarkLogic getBenchmarkLogic(final BenchmarkConfig bc) {
		return new FunnyQTBenchmarkLogic(bc);
	}
	
	@Override
	public BenchmarkConfig initialize(final String query) throws IOException {
		return new FunnyQTBenchmarkConfig(1, 1, query, 1, ChangeSet.FIXED, 1);
	}

}
