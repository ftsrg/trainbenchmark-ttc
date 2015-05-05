package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.ChangeSet;

import org.apache.commons.cli.ParseException;

public class EMFIncQueryBenchmarkConfig extends BenchmarkConfig {

	private static final String LOCALSEARCHOPTION = "localSearch";
	private boolean localSearch;

	public EMFIncQueryBenchmarkConfig(final String[] args) throws ParseException {
		super(args);
	}

	public EMFIncQueryBenchmarkConfig(final int size, final int runs, final String query, final int iterationCount,
			final ChangeSet changeSet, final long transformationConstant, final boolean localSearch) {
		super(size, runs, query, iterationCount, changeSet, transformationConstant);
		this.localSearch = localSearch;
	}

	@Override
	protected void initOptions() {
		super.initOptions();
		options.addOption(LOCALSEARCHOPTION, false, "uses the local search strategy for pattern matching");

	}

	@Override
	public void processArguments(final String[] args) throws ParseException {
		super.processArguments(args);

		localSearch = cmd.hasOption(LOCALSEARCHOPTION);
	}

	public boolean isLocalSearch() {
		return localSearch;
	}

	@Override
	public String getTool() {
		if (isLocalSearch()) {
			return "EMFIncQuery-LocalSearch";
		} else {
			return "EMFIncQuery-Incremental";
		}
	}

}
