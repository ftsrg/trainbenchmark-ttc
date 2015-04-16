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

package hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.transformations.TransformationUtil;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.util.BenchmarkResult;
import hu.bme.mit.trainbenchmark.ttc.benchmark.util.Util;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

public abstract class AbstractBenchmarkCase {

	protected BenchmarkResult bmr;
	protected BenchmarkConfig bc;
	protected Collection<Object> matches;
	protected Comparator<Object> comparator;

	// simple getters and setters
	public BenchmarkResult getBenchmarkResult() {
		return bmr;
	}

	// shorthands
	public String getName() {
		return bc.getQuery();
	}

	public Collection<Object> getMatches() {
		return matches;
	}

	// this should be implemented for the match representation of each tool
	protected abstract void registerComparator();

	// these should be implemented for each tool
	protected void init() throws IOException {
	}

	protected void destroy() throws IOException {
	}

	protected abstract void read() throws IOException;

	protected abstract Collection<Object> check() throws IOException;

	protected abstract void modify(Collection<Object> matches);

	// generic methods

	protected long getMemoryUsage() throws IOException {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	public void benchmarkInit(final BenchmarkConfig bc) throws IOException {
		this.bc = bc;

		bmr = new BenchmarkResult(bc.getTool(), bc.getQuery());
		bmr.setBenchmarkConfig(bc);
		registerComparator();
		init();
		runGC();
	}

	public void benchmarkDestroy() throws IOException {
		destroy();
	}

	public void benchmarkRead() throws IOException {
		bmr.restartClock();
		read();
		bmr.setReadTime();

		bmr.setReadMemory(getMemoryUsage());
	}

	public void benchmarkCheck() throws IOException {
		bmr.restartClock();
		check();
		bmr.addResultSize(matches.size());
		bmr.addCheckTime();

		bmr.addCheckMemory(getMemoryUsage());
	}

	public void benchmarkModify() throws IOException {
		final long nElementsToModify = Util.calcModify(bmr);
		bmr.addModifiedElementsSize(nElementsToModify);

		// create a sorted copy of the matches
		// we do not measure this in the benchmark results
		final Ordering<Object> ordering = Ordering.from(comparator);
		final List<Object> sortedMatches = ordering.sortedCopy(matches);
		final List<Object> elementsToModify = TransformationUtil.pickRandom(nElementsToModify, sortedMatches);

		// we measure the transformation
		bmr.restartClock();
		modify(elementsToModify);
		bmr.addTransformationTime();

		bmr.addTransformationMemory(getMemoryUsage());
	}

	protected void runGC() throws IOException {
		Util.runGC();
	}

}
