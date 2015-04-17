/*******************************************************************************
 * Copyright (c) 2010-2014, Benedek Izso, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.trainbenchmark.ttc.benchmark.config;

import hu.bme.mit.trainbenchmark.ttc.config.GenericConfig;

import org.apache.commons.cli.ParseException;

public class BenchmarkConfig extends GenericConfig {

	protected static final String CHANGE_SET = "changeSet";
	protected static final String RUN_INDEX = "runIndex";
	protected static final String ITERATION_COUNT = "iterationCount";
	protected static final String QUERY = "query";
	protected static final String FIXED = "fixed";
	protected static final String PROPORTIONAL = "proportional";

	// modification constants
	protected ChangeSet changeSet;
	protected long transformationConstant = 10;

	protected int iterationCount;
	protected int runIndex;
	protected String query;
	protected String tool;

	public BenchmarkConfig(final String args[], final String tool) throws ParseException {
		super(args);
		this.tool = tool;
	}

	public BenchmarkConfig(final String tool, final int size, final int runIndex, final String query, final int iterationCount,
			final ChangeSet changeSet, final long transformationConstant) {
		super(size);
		this.tool = tool;
		this.runIndex = runIndex;
		this.query = query;
		this.iterationCount = iterationCount;
		this.transformationConstant = transformationConstant;
		this.changeSet = changeSet;
	}

	@Override
	protected void initOptions() {
		super.initOptions();

		options.addOption(requiredOption(QUERY, "the query to run, e.g. RouteSensor"));
		options.addOption(requiredOption(CHANGE_SET, "the size of the change set, possible values: {fixed,proportional}"));
		options.addOption(RUN_INDEX, true, "index of the run in the benchmark series");
		options.addOption(ITERATION_COUNT, true, "number of modify-check iterations");
	}

	@Override
	public void processArguments(final String[] args) throws ParseException {
		super.processArguments(args);

		// queries argument -> testCases list
		query = cmd.getOptionValue(QUERY);
		switch (cmd.getOptionValue(CHANGE_SET).toString()) {
		case FIXED:
			changeSet = ChangeSet.FIXED;
			break;
		case PROPORTIONAL:
			changeSet = ChangeSet.PROPORTIONAL;
			break;
		default:
			throw new IllegalArgumentException(CHANGE_SET + " " + cmd.getOptionValue(CHANGE_SET) + " not defined.");
		}

		final String iterationCountString = cmd.getOptionValue(ITERATION_COUNT);
		if (iterationCountString != null) {
			iterationCount = new Integer(iterationCountString);
		} else {
			iterationCount = 1;
		}

		final String runIndexString = cmd.getOptionValue(RUN_INDEX);
		if (runIndexString != null) {
			runIndex = new Integer(runIndexString);
		} else {
			runIndex = 0;
		}
	}

	public int getRunIndex() {
		return runIndex;
	}

	public int getIterationCount() {
		return iterationCount;
	}

	public String getQuery() {
		return query;
	}

	public String getTool() {
		return tool;
	}

	public ChangeSet getChangeSet() {
		return changeSet;
	}

	public long getTransformationConstant() {
		return transformationConstant;
	}
}
