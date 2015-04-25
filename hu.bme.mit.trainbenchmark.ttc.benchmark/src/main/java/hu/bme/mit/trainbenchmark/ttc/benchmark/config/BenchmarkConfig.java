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
	protected static final String RUNS = "runs";
	protected static final String ITERATION_COUNT = "iterationCount";
	protected static final String QUERY = "query";
	protected static final String FIXED = "fixed";
	protected static final String PROPORTIONAL = "proportional";
	protected static final String TRANSFORMATION_CONSTANT = "transformationConstant";

	// modification constants
	protected ChangeSet changeSet;
	protected long transformationConstant;

	protected int iterationCount;
	protected int runs;
	protected String query;
	protected String tool;

	public BenchmarkConfig(final String args[], final String tool) throws ParseException {
		super(args);
		this.tool = tool;
	}

	public BenchmarkConfig(final String tool, final int size, final int runs, final String query, final int iterationCount,
			final ChangeSet changeSet, final long transformationConstant) {
		super(size);
		this.tool = tool;
		this.runs = runs;
		this.query = query;
		this.iterationCount = iterationCount;
		this.transformationConstant = transformationConstant;
		this.changeSet = changeSet;
	}

	@Override
	protected void initOptions() {
		super.initOptions();

		options.addOption(requiredOption(QUERY, "the query to run, e.g. RouteSensor"));
		options.addOption(requiredOption(CHANGE_SET, "the size of the change set, possible values: {fixed, proportional}"));
		options.addOption(RUNS, true, "number of runs");
		options.addOption(ITERATION_COUNT, true, "number of modify-check iterations");
		options.addOption(TRANSFORMATION_CONSTANT, true, "constant value for the transformations: "
				+ "for a fixed change set, it defines the number of elements; "
				+ "for a proportional change set, it defines the proportion of the elements");
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

		final String runsString = cmd.getOptionValue(RUNS);
		if (runsString != null) {
			runs = new Integer(runsString);
		} else {
			runs = 1;
		}

		final String transformationConstantString = cmd.getOptionValue(TRANSFORMATION_CONSTANT);
		if (transformationConstantString != null) {
			transformationConstant = new Integer(iterationCountString);
		} else {
			transformationConstant = 10;
		}
	}

	public int getRuns() {
		return runs;
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
