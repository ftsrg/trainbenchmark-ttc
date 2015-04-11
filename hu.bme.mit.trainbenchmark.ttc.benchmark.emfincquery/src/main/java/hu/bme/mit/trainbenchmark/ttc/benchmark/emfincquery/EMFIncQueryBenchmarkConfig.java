package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;

import org.apache.commons.cli.ParseException;

public class EMFIncQueryBenchmarkConfig extends BenchmarkConfig {

	private static final String LOCALSEARCHOPTION = "localSearch";
	private boolean localSearch;

	public EMFIncQueryBenchmarkConfig(String[] args, String tool) throws ParseException {
		super(args, tool);
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
