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

package hu.bme.mit.trainbenchmark.ttc.benchmark.util;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.constants.TrainBenchmarkConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BenchmarkResult {

	private static final String RSS = "rss";
	private static final String REPAIR = "repair";
	private static final String CHECK = "check";
	private static final String RECHECK = "recheck";
	private static final String READ = "read";
	private static final String MEMORY = "memory";
	private static final String TIME = "time";

	protected String tool;
	protected String query;
	protected BenchmarkConfig bc;
	protected Random random;
	protected long startTime;

	protected int runIndex;

	protected final String SEPARATOR = "\t";

	protected List<Long> modifiedElementsSizes = new ArrayList<>();
	protected List<Long> memoryUsages = new ArrayList<>();
	protected List<Integer> resultSizes = new ArrayList<>();

	// phase 1
	protected Long readTime;
	protected Long readMemory;
	// phase 2
	protected List<Long> checkTimes = new ArrayList<>();
	protected List<Long> checkMemory = new ArrayList<>();
	// phase 3
	protected List<Long> repairTimes = new ArrayList<>();
	protected List<Long> repairMemory = new ArrayList<>();

	public BenchmarkResult(final String tool, final String query, final int runIndex) {
		this.tool = tool;
		this.query = query;
		this.runIndex = runIndex;

		this.random = new UniqueRandom(TrainBenchmarkConstants.RANDOM_SEED);
	}

	// benchmarkconfig

	public BenchmarkConfig getBenchmarkConfig() {
		return bc;
	}

	public void setBenchmarkConfig(final BenchmarkConfig bc) {
		this.bc = bc;
	}

	// timing

	public void restartClock() {
		startTime = System.nanoTime();
	}

	public long stopClock() {
		final long currentTime = System.nanoTime();
		final long nanos = currentTime - startTime;
		return nanos;
	}

	// phase 1
	public void setReadTime() {
		readTime = stopClock();
	}

	public void setReadMemory(final long memoryUsage) {
		readMemory = memoryUsage;
	}

	// phase 2
	public void addCheckTime() {
		checkTimes.add(stopClock());
	}

	public void addCheckMemory(final long memoryUsage) {
		checkMemory.add(memoryUsage);
	}

	// phase 3
	public void addTransformationTime() {
		repairTimes.add(stopClock());
	}

	public void addTransformationMemory(final long memoryUsage) {
		repairMemory.add(memoryUsage);
	}

	// random

	public void setRandom(final Random random) {
		this.random = random;
	}

	public Random getRandom() {
		return random;
	}

	// memory usage

	public void addMemoryUsage(final long memoryUsage) {
		memoryUsages.add(memoryUsage);
	}

	// modification parameters

	public void addModifiedElementsSize(final long modifiedElementsSize) {
		modifiedElementsSizes.add(modifiedElementsSize);
	}

	// result sizes

	public void addResultSize(final int size) {
		resultSizes.add(size);
	}

	public List<Integer> getResultSizes() {
		return resultSizes;
	}

	public long getLastResultSize() {
		return resultSizes.get(resultSizes.size() - 1);
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();

		for (int i = 0; i < resultSizes.size(); i++) {
			String phase = (i == 0) ? phase = CHECK : RECHECK;
			generateRow(builder, phase, RSS, i, resultSizes.get(i));
		}

		// phases
		generateRow(builder, READ, TIME, 0, readTime);
		generateRow(builder, READ, MEMORY, 0, readMemory);
		for (int i = 0; i < checkTimes.size(); i++) {
			String phase = (i == 0) ? phase = CHECK : RECHECK;
			generateRow(builder, phase, TIME, i, checkTimes.get(i));
			generateRow(builder, phase, MEMORY, i, checkMemory.get(i));
		}
		for (int i = 0; i < repairTimes.size(); i++) {
			generateRow(builder, REPAIR, TIME, (i + 1), repairTimes.get(i));
			generateRow(builder, REPAIR, MEMORY, (i + 1), repairMemory.get(i));
		}

		return builder.toString();
	}

	protected void generateRow(final StringBuilder builder, final String phase, final String metricName, final int i, final long value) {
		// Scenario
		builder.append(bc.getChangeSet().toString().toLowerCase());
		builder.append(SEPARATOR);
		// RunIndex
		builder.append(runIndex);
		builder.append(SEPARATOR);
		// Tool
		builder.append(bc.getTool());
		builder.append(SEPARATOR);
		// Size
		builder.append(bc.getSize());
		builder.append(SEPARATOR);
		// Query
		builder.append(bc.getQuery());
		builder.append(SEPARATOR);
		// PhaseName
		builder.append(phase);
		builder.append(SEPARATOR);
		// Iteration
		builder.append(i);
		builder.append(SEPARATOR);
		// MetricName
		builder.append(metricName);
		builder.append(SEPARATOR);
		// MetricValue
		builder.append(value);

		// newline
		builder.append(System.lineSeparator());
	}

}
