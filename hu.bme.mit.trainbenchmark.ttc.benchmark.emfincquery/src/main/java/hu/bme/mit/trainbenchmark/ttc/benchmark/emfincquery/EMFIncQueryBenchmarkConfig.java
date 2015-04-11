package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.ChangeSet;

import org.apache.commons.cli.ParseException;

public class EMFIncQueryBenchmarkConfig extends BenchmarkConfig {

	private static final String LOCALSEARCHOPTION = "localSearch";
	private boolean localSearch;

	public EMFIncQueryBenchmarkConfig(String[] args, String tool) throws ParseException {
		super(args, tool);
	}

	public EMFIncQueryBenchmarkConfig(final String tool, final int size, final int runIndex, final String query, final int iterationCount,
			final ChangeSet changeSet, final long transformationConstant, final boolean localSearch) {
		super(tool, size, runIndex, query, iterationCount, changeSet, transformationConstant);
		this.localSearch = localSearch;
	}
	
	@Override
	protected void initOptions() {
		super.initOptions();
		options.addOption(LOCALSEARCHOPTION,false,"uses the local search strategy for pattern matching");
		
	}
	
	@Override
	public void processArguments(String[] args) throws ParseException {
		super.processArguments(args);
		
		localSearch = cmd.hasOption(LOCALSEARCHOPTION);
	}

	public boolean isLocalSearch() {
		return localSearch;
	}
	
}
