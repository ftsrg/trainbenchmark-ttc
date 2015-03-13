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

	private static final String TRANSFORM = "transform";
	private static final String CHECK = "check";
	private static final String READ = "read";
	private static final String MEMORY = "memory";
	private static final String TIME = "time";

	protected String tool;
	protected String query;
	protected BenchmarkConfig bc;
	protected Random random;
	protected long startTime;

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
	protected List<Long> transformationTimes = new ArrayList<>();
	protected List<Long> transformationMemory = new ArrayList<>();

	public BenchmarkResult(final String tool, final String query) {
		this.tool = tool;
		this.query = query;
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
		transformationTimes.add(stopClock());
	}

	public void addTransformationMemory(final long memoryUsage) {
		transformationMemory.add(memoryUsage);
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
			generateRow(builder, "result", "scalar", i, resultSizes.get(i));
		}

		// phases
		generateRow(builder, READ, TIME, 0, readTime);
		generateRow(builder, READ, MEMORY, 0, readMemory);
		for (int i = 0; i < checkTimes.size(); i++) {
			generateRow(builder, CHECK, TIME, i, checkTimes.get(i));
			generateRow(builder, CHECK, MEMORY, i, checkMemory.get(i));
		}
		for (int i = 0; i < transformationTimes.size(); i++) {
			generateRow(builder, TRANSFORM, TIME, i, transformationTimes.get(i));
			generateRow(builder, TRANSFORM, MEMORY, i, transformationMemory.get(i));
		}

		return builder.toString();
	}

	protected void generateRow(final StringBuilder builder, final String phase, final String metricName, final int i, final long value) {
		// Scenario
		builder.append(bc.getChangeSet());
		builder.append(SEPARATOR);
		// RunIndex
		builder.append(bc.getRunIndex());
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
