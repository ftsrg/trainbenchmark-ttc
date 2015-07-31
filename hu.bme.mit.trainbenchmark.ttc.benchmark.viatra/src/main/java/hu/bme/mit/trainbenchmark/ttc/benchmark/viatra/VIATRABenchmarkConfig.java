package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra;

import org.apache.commons.cli.ParseException;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.ChangeSet;

public class VIATRABenchmarkConfig extends BenchmarkConfig {

	public VIATRABenchmarkConfig(final String[] args) throws ParseException {
		super(args);
	}

	public VIATRABenchmarkConfig(final int size, final int runs, final String query, final int iterationCount,
			final ChangeSet changeSet, final long transformationConstant) {
		super(size, runs, query, iterationCount, changeSet, transformationConstant);
	}

	@Override
	protected void initOptions() {
		super.initOptions();
	}

	@Override
	public String getTool() {
		return "VIATRA";
	}

}
